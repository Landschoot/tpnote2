package domain;

import lombok.Builder;
import lombok.Data;
import persistence.uow.IDomainObject;
import persistence.uow.Observateur;
import persistence.uow.Visiteur;

import java.util.List;

/**
 * Created by landschoot on 25/11/16.
 * Classe qui représente une personne
 */
@Data
@Builder
public class Personne implements IDomainObject {
    private List<Observateur> obs;
    private String identifiant;
    private String nom;
    private String prenom;
    private String description;
    private Personne pere;
    private List<Personne> fils;

    @Override
    public void accepter(Visiteur v) {
        v.visiter(this);
    }

    @Override
    public void add(Observateur o) {
        obs.add(o);
    }

    @Override
    public void notifier() {
        for (Observateur o : obs)
            o.action(this);
    }
}
