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
    UserMapper personneMapper;
    static UnitOfWork inst = null;
    public UnitOfWork() {
        dirty = new HashSet<>();
        personneMapper = UserMapper.getInstance();
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
            personneMapper.update(o);
        }
        dirty.clear();
    }
}
