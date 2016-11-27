import domain.IPersonne;
import domain.Personne;
import gui.IdentificationFrame;
import persistence.db.PersonneMapper;

/**
 * Created by landschoot on 25/11/1.
 */
public class Application {
    public static void main(String[] args) throws Exception {
        IPersonne personne = PersonneMapper.getInstance().findByIdentifiant("tony");
    }
}
