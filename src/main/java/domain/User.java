package domain;

import lombok.Builder;
import lombok.Data;
import persistence.uow.Observateur;

import java.util.List;

/**
 * Created by landschoot on 25/11/16.
 * Classe qui représente une personne
 */
@Data
@Builder
public class User implements IUser {
    private List<Observateur> obs;

    private String identifiant;
    private String name;
    private String firstName;
    private String evaluation;
    private IUser father;
    private List<IUser> children;

    @Override
    public void add(Observateur o) {
        obs.add(o);
    }

    @Override
    public void notifier() {
        for (Observateur o : obs)
            o.action(this);
    }

    @Override
    public String toString() {
        return getName()+" "+ getFirstName();
    }
}
