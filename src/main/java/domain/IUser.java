package domain;

import persistence.uow.Observable;

import java.util.List;

/**
 * Interface d'un utilisateur.
 *
 * @author Laurent THIEBAULT & Ludovic LANDSCHOOT
 */
public interface IUser extends Observable {
    public String getIdentifiant();

    public void setIdentifiant(String identifiant);

    public String getName();

    public void setName(String name);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getEvaluation();

    public void setEvaluation(String evaluation);

    public IUser getFather();

    public void setFather(IUser father);

    public List<IUser> getChildren();

    public void setChildren(List<IUser> children);
}
