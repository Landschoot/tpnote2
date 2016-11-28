package service;

import domain.IUser;
import domain.exceptions.PersonNotFoundException;
import persistence.db.UserMapper;

/**
 * Created by landschoot on 26/11/16.
 */
public class UserService {
    private static UserService instance = null;

    private UserMapper userMapper;

    public static UserService getInstance() {
        if(instance == null){
            instance = new UserService();
        }
        return instance;
    }

    private UserService(){
        this.userMapper = UserMapper.getInstance();
    }

    public IUser findById(String id) throws PersonNotFoundException {
        return userMapper.findByIdentifiant(id);
    }
}
