package src.si.feri.um.mg.dao.interfaces;

import src.si.feri.um.mg.vao.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {

    void addUser(User user);
    Optional<User> getUser(String email);
    List<User> getUsers();
    void deleteUser(String email);
    void updateUser(User user);
}
