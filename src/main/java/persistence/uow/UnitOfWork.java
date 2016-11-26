package persistence.uow;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lauthieb on 26/11/2016.
 */
public class UnitOfWork implements Observateur {
    Set<IDomainObject> dirty;
    static UnitOfWork inst = null;
    public UnitOfWork() {
        dirty = new HashSet<IDomainObject>();
    }
    public static UnitOfWork getInstance() {
        if (inst == null)
            inst = new UnitOfWork();
        return inst;
    }
    public void action(IDomainObject o) {
        dirty.add(o);
    }
    public void commit() {
        Visiteur v = new Committer();
        for (IDomainObject o : dirty) {
            v.visiter(o);
        }
        dirty.clear();
    }
}
