package persistence.vp;

import domain.IPersonne;

import persistence.db.PersonneMapper;

import java.sql.SQLException;

public class PereFactory implements Factory<IPersonne>{

    String identifiant;
    PersonneMapper personneMapper;

    public PereFactory(String identifiant) {
        this.identifiant = identifiant;
        this.personneMapper = PersonneMapper.getInstance();
    }

    @Override
    public IPersonne create() throws SQLException {
        return personneMapper.findByIdentifiant(this.identifiant);
    }
}
