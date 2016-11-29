package domain.exceptions;

/**
 * Classe représentant l'exception concernant une personne non trouvée dans la base.
 *
 * @author Laurent THIEBAULT & Ludovic LANDSCHOOT
 */
public class PersonNotFoundException extends Exception {
    public PersonNotFoundException() {
        super("Personne introuvable.");
    }
}
