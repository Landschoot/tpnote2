package persistence.vp;

import domain.IUser;

import persistence.db.UserMapper;

import java.sql.SQLException;

public class FatherFactory implements Factory<IUser>{

    String identifiant;
    UserMapper personneMapper;

    public FatherFactory(String identifiant) {
        this.identifiant = identifiant;
        this.personneMapper = UserMapper.getInstance();
    }

    @Override
    public IUser create() throws SQLException {
        return personneMapper.findByIdentifiant(this.identifiant);
    }
}
