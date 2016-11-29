package persistence.uow;

import domain.IUser;
import lombok.Getter;
import persistence.db.UserMapper;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe représentant l'UnitOfWork.
 *
 * @author Laurent THIEBAULT & Ludovic LANDSCHOOT (via Clément BALLABRIGA)
 */
@Getter
public class UnitOfWork implements Observer {
    Set<IUser> dirty;
    UserMapper userMapper;
    static UnitOfWork inst = null;
    public UnitOfWork() {
        dirty = new HashSet<>();
        userMapper = UserMapper.getInstance();
    }
    public static UnitOfWork getInstance() {
        if (inst == null)
            inst = new UnitOfWork();
        return inst;
    }
    public void action(IUser o) {
        dirty.add(o);
    }
    public void commit() {
        for (IUser o : dirty) {
            userMapper.update(o);
        }
        rollback();
    }
    public void rollback() {
        dirty.clear();
    }
}
