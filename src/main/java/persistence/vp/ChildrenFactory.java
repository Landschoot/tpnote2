package persistence.vp;

import domain.IUser;
import persistence.db.UserMapper;

import java.sql.SQLException;
import java.util.List;

public class ChildrenFactory implements Factory<List<IUser>>{

    String identifiant;
    UserMapper userMapper;

    public ChildrenFactory(String identifiant) {
        this.identifiant = identifiant;
        this.userMapper = UserMapper.getInstance();
    }

    @Override
    public List<IUser> create() throws SQLException {
        return userMapper.findChildren(identifiant);
    }
}
