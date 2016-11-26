package service;

import domain.Personne;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by landschoot on 26/11/16.
 */
public class PersonneService {
    private static PersonneService instance = null;

    public static PersonneService getInstance() {
        if(instance == null){
            instance = new PersonneService();
        }
        return instance;
    }

    public Personne findById(String text) {
        List<Personne> fils = new ArrayList<>();

        Personne personne = Personne.builder()
                .identifiant("toto")
                .nom("toto")
                .prenom("titi")
                .evaluation("tutu")
                .build();
        return personne;
    }
}
