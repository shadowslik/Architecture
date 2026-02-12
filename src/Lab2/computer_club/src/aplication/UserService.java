package aplication;

import domain.User;

import java.util.List;

public interface UserService {

    User createUser(String name,double balance);
    boolean deleteUser(int userId);
    List<User> getAll();
    User getUser(int userId);
    User updateBalance(int userId, double newBalance);

}
