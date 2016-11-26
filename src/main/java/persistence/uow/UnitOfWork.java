package persistence.uow;

import domain.IPersonne;
import persistence.db.PersonneMapper;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lauthieb on 26/11/2016.
 */
public class UnitOfWork implements Observateur {
    Set<IPersonne> dirty;
    PersonneMapper personneMapper;
    static UnitOfWork inst = null;
    public UnitOfWork() {
        dirty = new HashSet<>();
        personneMapper = PersonneMapper.getInstance();
    }
    public static UnitOfWork getInstance() {
        if (inst == null)
            inst = new UnitOfWork();
        return inst;
    }
    public void action(IPersonne o) {
        dirty.add(o);
    }
    public void commit() {
        for (IPersonne o : dirty) {
            personneMapper.update(o);
        }
        dirty.clear();
    }
}
