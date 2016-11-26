package persistence.vp;

import java.sql.SQLException;

public interface Factory<T> {
    T create() throws SQLException;
}
