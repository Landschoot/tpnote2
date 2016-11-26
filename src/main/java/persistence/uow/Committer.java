package persistence.uow;

import domain.Personne;
import persistence.db.PersonneMapper;

/**
 * Created by lauthieb on 26/11/2016.
 */
public class Committer extends Visiteur {
    @Override
    public void visiter(Personne p) {
        PersonneMapper.getInstance().update(p);
    }
}
