package persistence.db;

import domain.IUser;
import domain.User;
import domain.exceptions.PersonNotFoundException;
import net.rakugakibox.util.YamlResourceBundle;
import persistence.uow.UnitOfWork;
import persistence.vp.ChildrenFactory;
import persistence.vp.PersonFactory;
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

/**
 * Classe d'accès aux données représentant un mapper d'utilisateur.
 *
 * @author Ludovic LANDSCHOOT & Laurent THIEBAULT
 */
public class UserMapper {
    private static UserMapper instance = null;
    Connection db = null;
    HashMap<String, WeakReference<User>> objets;
    protected ResourceBundle bundle;

    public static UserMapper getInstance() {
        if (instance == null)
            instance = new UserMapper();
        return instance;
    }

    private UserMapper() {
        this.objets = new HashMap<>();
        this.db = SingletonDB.getInstance().getDb();
        this.bundle = ResourceBundle.getBundle("db/requests", YamlResourceBundle.Control.INSTANCE);
    }

    /**
     * Récupére un utilisateur par son identifiant.
     * @param identifiant
     * @return
     * @throws PersonNotFoundException
     */
    public IUser findByIdentifiant(String identifiant) throws PersonNotFoundException {
        IUser user = null;

        try {
            PreparedStatement preparedStatement = db.prepareStatement(this.bundle.getString("select.user.by.identifiant"));
            preparedStatement.setString(1, identifiant);
            ResultSet rs = preparedStatement.executeQuery();

            if(!rs.next()) {
                throw new PersonNotFoundException();
            }

            user = createUser(rs);

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Récupére les enfants de l'utilisateur.
     * @param identifiant
     * @return
     */
    public List<IUser> findChildren(String identifiant) {
        List<IUser> children = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = db.prepareStatement(this.bundle.getString("select.children.by.identifiant.father"));
            preparedStatement.setString(1, identifiant);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                children.add(createUser(rs));
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return children;
    }

    /**
     * Créer un utilisateur.
     * @param rs
     * @return
     */
    private IUser createUser(ResultSet rs) {
        IUser user = null;

        try {
            user = User.builder()
                    .identifiant(rs.getString("identifiant"))
                    .lastName(rs.getString("lastname"))
                    .firstName(rs.getString("firstname"))
                    .evaluation(rs.getString("evaluation"))
                    .obs(new ArrayList<>())
                    .build();
            if (rs.getString("father") != null) {
                user.setFather(new VirtualProxyBuilder<>(IUser.class, new PersonFactory(rs.getString("father"))).getProxy());
            }
            user.setChildren(new VirtualProxyBuilder<>(List.class, new ChildrenFactory(rs.getString("identifiant"))).getProxy());
            user.add(UnitOfWork.getInstance());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Modifie un utilisateur.
     * @param user
     */
    public void update(IUser user) {
        try {
            PreparedStatement preparedStatement = db.prepareStatement(this.bundle.getString("update.user.by.identifiant"));
            preparedStatement.setString(1, user.getEvaluation());
            preparedStatement.setString(2, user.getIdentifiant());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
