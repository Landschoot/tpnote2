package persistence.vp;

import domain.IUser;

import domain.exceptions.PersonNotFoundException;
import persistence.db.UserMapper;

import java.sql.SQLException;

public class FatherFactory implements Factory<IUser>{

    String identifiant;
    UserMapper userMapper;

    public FatherFactory(String identifiant) {
        this.identifiant = identifiant;
        this.userMapper = UserMapper.getInstance();
    }

    @Override
    public IUser create() throws SQLException, PersonNotFoundException {
        return userMapper.findByIdentifiant(this.identifiant);
    }
}
