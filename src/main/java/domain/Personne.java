package domain;

import lombok.Builder;
import lombok.Data;
import persistence.uow.Observable;
import persistence.uow.Observateur;

import java.util.List;

/**
 * Created by landschoot on 25/11/16.
 * Classe qui représente une personne
 */
@Data
@Builder
public class Personne implements IPersonne {
    private List<Observateur> obs;

    private String identifiant;
    private String nom;
    private String prenom;
    private String evaluation;
    private IPersonne pere;
    private List<IPersonne> fils;

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
