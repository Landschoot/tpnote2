package persistence.uow;

import domain.IUser;
import persistence.db.UserMapper;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lauthieb on 26/11/2016.
 */
public class UnitOfWork implements Observateur {
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
        dirty.clear();
    }
}
