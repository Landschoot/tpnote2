package domain;

import lombok.Builder;
import lombok.Getter;
import persistence.uow.Observer;

import java.util.List;

/**
 * Classe représentant un utilisateur.
 *
 * @author Laurent THIEBAULT & Ludovic LANDSCHOOT
 */
@Getter
@Builder
public class User implements IUser {
    private List<Observer> obs;

    private String identifiant;
    private String lastName;
    private String firstName;
    private String evaluation;
    private IUser father;
    private List<IUser> children;

    @Override
    public void add(Observer o) {
        obs.add(o);
    }

    @Override
    public void notif() {
        for (Observer o : obs)
            o.action(this);
    }

    @Override
    public String toString() {
        return getLastName() + " " + getFirstName();
    }

    @Override
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
        notif();
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
        notif();
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notif();
    }

    @Override
    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
        notif();
    }

    @Override
    public void setFather(IUser father) {
        this.father = father;
        notif();
    }

    @Override
    public void setChildren(List<IUser> children) {
        this.children = children;
        notif();
    }
}
