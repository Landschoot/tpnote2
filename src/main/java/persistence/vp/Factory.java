package persistence.vp;

import domain.exceptions.PersonNotFoundException;

import java.sql.SQLException;

public interface Factory<T> {
    T create() throws SQLException, PersonNotFoundException;
}
