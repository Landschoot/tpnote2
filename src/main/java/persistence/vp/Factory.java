package persistence.vp;

import domain.exceptions.PersonNotFoundException;

import java.sql.SQLException;

/**
 * Interface décrivant une factory
 *
 * @param <T> le type d'objet que crééra la factory
 *
 * @author Laurent THIEBAULT & Ludovic LANDSCHOOT
 */
public interface Factory<T> {
    /**
     * Créer le type T.
     * @return
     * @throws SQLException
     * @throws PersonNotFoundException
     */
    T create() throws SQLException, PersonNotFoundException;
}
