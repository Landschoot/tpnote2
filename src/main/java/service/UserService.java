package service;

import domain.IUser;
import domain.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by landschoot on 26/11/16.
 */
public class UserService {
    private static UserService instance = null;

    public static UserService getInstance() {
        if(instance == null){
            instance = new UserService();
        }
        return instance;
    }

    public List<User> findAll(){
        return new ArrayList<User>();
    }

    public User findById(String text) {
        List<IUser> fils = new ArrayList<>();
        fils.add(User.builder()
                .identifiant("fils")
                .name("name")
                .firstName("firstName")
                .evaluation("evaluation")
                .build());
        fils.add(User.builder()
                .identifiant("fils2")
                .name("name")
                .firstName("firstName")
                .evaluation("evaluation")
                .build());

        User pere =  User.builder()
                .identifiant("pere")
                .name("name")
                .firstName("firstName")
                .evaluation("evaluation")
                .build();

        User personne = User.builder()
                .identifiant("name")
                .name("name")
                .firstName("firstName")
                .evaluation("evaluation")
                .father(pere)
                .children(fils)
                .build();
        return personne;
    }

    public void commit(){

    }
}
