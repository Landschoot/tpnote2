package persistence.uow;

import domain.IPersonne;

public interface Observateur {
    void action(IPersonne o);
}
