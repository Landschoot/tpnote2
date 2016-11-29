package persistence.uow;

import domain.IUser;

/**
 * Interface décrivant un observateur.
 *
 * @author Laurent THIEBAULT & Ludovic LANDSCHOOT
 */
public interface Observer {
    void action(IUser o);
}
