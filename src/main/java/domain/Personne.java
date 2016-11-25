package domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by landschoot on 25/11/16.
 * Classe qui représente une personne
 */
@Data
@Builder
public class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String description;
    private Personne pere;
    private List<Personne> fils;

    public Personne(int id, String nom, String prenom, String description, Personne pere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.description = description;
        this.pere = pere;
    }

    public void addFils(Personne personne){
        this.fils.add(personne);
    }
}
