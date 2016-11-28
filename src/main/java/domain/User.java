package domain;

import lombok.Builder;
import lombok.Getter;
import persistence.uow.Observateur;

import java.util.List;

/**
 * Created by landschoot on 25/11/16.
 * Classe qui représente une personne
 */
@Getter
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

    public void setObs(List<Observateur> obs) {
        this.obs = obs;
    }

    @Override
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
        notifier();
    }

    @Override
    public void setName(String name) {
        this.name = name;
        notifier();
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifier();
    }

    @Override
    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
        notifier();
    }

    @Override
    public void setFather(IUser father) {
        this.father = father;
        notifier();
    }

    @Override
    public void setChildren(List<IUser> children) {
        this.children = children;
        notifier();
    }
}
