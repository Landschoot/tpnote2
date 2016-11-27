package persistence.uow;

import domain.IUser;

public interface Observateur {
    void action(IUser o);
}
