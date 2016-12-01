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
    public static UnitOfWork inst = null;
    Set<IUser> dirty;
    UserMapper userMapper;

    public UnitOfWork() {
        dirty = new HashSet<>();
        userMapper = UserMapper.getInstance();
    }

    public static UnitOfWork getInstance() {
        if (inst == null)
            inst = new UnitOfWork();
        return inst;
    }

    /**
     * Ajoute un utilisateur à modifier.
     * @param o
     */
    public void action(IUser o) {
        dirty.add(o);
    }

    /**
     * Effectue les modifications sur tous les utilisateurs de la liste.
     */
    public void commit() {
        for (IUser o : dirty) {
            userMapper.update(o);
        }
        rollback();
    }

    /**
     * Reinitialise à vide la liste des utilisateurs à modifier.
     */
    public void rollback() {
        dirty.clear();
    }
}
