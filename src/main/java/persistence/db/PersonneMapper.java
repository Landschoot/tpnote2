package persistence.db;

import domain.Personne;

import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PersonneMapper {
    HashMap<String, WeakReference<Personne>> objets;

    private static PersonneMapper instance = null;
    Connection con = null;

    public static PersonneMapper getInstance() {
        if (instance == null)
            instance = new PersonneMapper();
        return instance;
    }

    public PersonneMapper() {
        objets = new HashMap<>();
        con = SingletonDB.getInstance().getDb();
    }

    public Personne findByIdentifiant(String identifiant) {
        return new Personne();
    }

    public List<Personne> findFils(String identifiant) {
        return new ArrayList<>();
    }

    public void update(Personne personne) {
        System.out.println("Mise à jour personne");
    }
}
