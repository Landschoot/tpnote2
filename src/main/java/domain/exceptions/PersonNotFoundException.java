package domain.exceptions;

/**
 * Created by lauthieb on 29/11/2016.
 */
public class PersonNotFoundException extends Exception {
    public PersonNotFoundException() {
        super("Personne introuvable.");
    }
}
