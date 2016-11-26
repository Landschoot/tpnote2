package persistence.db;

import domain.IPersonne;
import domain.Personne;
import net.rakugakibox.util.YamlResourceBundle;
import persistence.vp.PereFactory;
import persistence.vp.VirtualProxyBuilder;

import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class PersonneMapper {
    HashMap<String, WeakReference<Personne>> objets;
    protected ResourceBundle bundle;
    private static PersonneMapper instance = null;
    Connection db = null;

    public static PersonneMapper getInstance() {
        if (instance == null)
            instance = new PersonneMapper();
        return instance;
    }

    public PersonneMapper() {
        this.objets = new HashMap<>();
        this.db = SingletonDB.getInstance().getDb();
        this.bundle = ResourceBundle.getBundle("db/requests", YamlResourceBundle.Control.INSTANCE);
    }

    public IPersonne findByIdentifiant(String identifiant) throws SQLException {
        Personne personne = null;
        PreparedStatement preparedStatement = db.prepareStatement(this.bundle.getString("select.personne.by.identifiant"));
        preparedStatement.setString(1, identifiant);
        ResultSet rs = preparedStatement.executeQuery();

        while(rs.next()) {
            personne = Personne.builder()
                    .identifiant(rs.getString(1))
                    .nom(rs.getString(2))
                    .prenom(rs.getString(3))
                    .evaluation(rs.getString(4))
                    .pere(new VirtualProxyBuilder<>(IPersonne.class, new PereFactory(rs.getString(5))).getProxy())
                    .build();
        }
        rs.close();

        return personne;
    }

    public List<IPersonne> findFils(String identifiant) {
        return new ArrayList<>();
    }

    public void update(IPersonne personne) {
        System.out.println("Mise à jour personne");
    }
}
