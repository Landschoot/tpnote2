package persistence.vp;

import domain.IUser;
import domain.exceptions.PersonNotFoundException;
import persistence.db.UserMapper;

import java.sql.SQLException;

/**
 * Classe représentant une factory pour un utilisateur.
 *
 * @author Ludovic LANDSCHOOT & Laurent THIEBAULT
 */
public class PersonFactory implements Factory<IUser>{

    String identifiant;
    UserMapper userMapper;

    public PersonFactory(String identifiant) {
        this.identifiant = identifiant;
        this.userMapper = UserMapper.getInstance();
    }

    @Override
    public IUser create() throws SQLException, PersonNotFoundException {
        return userMapper.findByIdentifiant(this.identifiant);
    }
}
