package service;

import domain.IUser;
import domain.exceptions.PersonNotFoundException;
import persistence.db.UserMapper;
import persistence.uow.UnitOfWork;

/**
 * Created by landschoot on 26/11/16.
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
