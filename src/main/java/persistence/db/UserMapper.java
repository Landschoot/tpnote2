package persistence.db;

import domain.IUser;
import domain.User;
import net.rakugakibox.util.YamlResourceBundle;
import persistence.uow.UnitOfWork;
import persistence.vp.ChildrenFactory;
import persistence.vp.FatherFactory;
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

public class UserMapper {
    HashMap<String, WeakReference<User>> objets;
    protected ResourceBundle bundle;
    private static UserMapper instance = null;
    Connection db = null;

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

    public IUser findByIdentifiant(String identifiant) throws SQLException {
        PreparedStatement preparedStatement = db.prepareStatement(this.bundle.getString("select.personne.by.identifiant"));
        preparedStatement.setString(1, identifiant);
        ResultSet rs = preparedStatement.executeQuery();

        if(!rs.next()) {
            /** TODO : exception NotFound **/
        }

        IUser user = createUser(rs);

        rs.close();
        return user;
    }

    private IUser createUser(ResultSet rs) throws SQLException {
        IUser user;

        user = User.builder()
                .identifiant(rs.getString(1))
                .name(rs.getString(2))
                .firstName(rs.getString(3))
                .evaluation(rs.getString(4))
                .obs(new ArrayList<>())
                .build();
        if (rs.getString(5) != null) {
            user.setFather(new VirtualProxyBuilder<>(IUser.class, new FatherFactory(rs.getString(5))).getProxy());
        }

        user.setChildren(new VirtualProxyBuilder<>(List.class, new ChildrenFactory(rs.getString(1))).getProxy());

        user.add(UnitOfWork.getInstance());
        return user;
    }

    public List<IUser> findChildren(String identifiant) {
        return new ArrayList<>();
    }

    public void update(IUser personne) {
        System.out.println("Mise à jour personne");
    }
}
