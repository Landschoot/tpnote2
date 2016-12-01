package service;

import domain.IUser;
import domain.exceptions.PersonNotFoundException;
import persistence.db.UserMapper;
import persistence.uow.UnitOfWork;

/**
 * Classe représentant un service pour les utilisateurs.
 *
 * @author Ludovic LANDSCHOOT & Laurent THIEBAULT
 */
public class UserService {
    private static UserService instance = null;

    private UserMapper userMapper;
    private UnitOfWork unitOfWork;

    public static UserService getInstance() {
        if(instance == null){
            instance = new UserService();
        }
        return instance;
    }

    private UserService(){
        this.userMapper = UserMapper.getInstance();
        this.unitOfWork = UnitOfWork.getInstance();
    }

    /**
     * Récupére un utilisateur par son identifiant.
     * @param id
     * @return
     * @throws PersonNotFoundException
     */
    public IUser findById(String id) throws PersonNotFoundException {
        return userMapper.findByIdentifiant(id);
    }

    public void commit() {
        unitOfWork.commit();
    }

    public void rollback() {
        unitOfWork.rollback();
    }
}
