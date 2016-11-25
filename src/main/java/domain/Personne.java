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
    private String identifiant;
    private String nom;
    private String prenom;
    private String description;
    private Personne pere;
    private List<Personne> fils;

    public void addFils(Personne personne){
        this.fils.add(personne);
    }
}
