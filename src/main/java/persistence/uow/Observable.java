package persistence.uow;

public interface Observable {
    void add(Observateur o);
    void notifier();
}