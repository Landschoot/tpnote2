package persistence.uow;

public interface Observateur {
    void action(IDomainObject o);
}
