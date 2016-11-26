package persistence.uow;

public interface Visitable {
    void accepter(Visiteur v);
}
