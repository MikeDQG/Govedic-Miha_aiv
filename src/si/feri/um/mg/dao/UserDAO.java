package src.si.feri.um.mg.dao;

import src.si.feri.um.mg.dao.interfaces.IUserDAO;
import src.si.feri.um.mg.vao.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UserDAO implements IUserDAO {

    private static volatile UserDAO instance;

    private UserDAO() {}

    private final List<User> users = Collections.synchronizedList(new ArrayList<>());

    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAO.class) {
                if (instance == null) {
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }


    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public Optional<User> getUser(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void deleteUser(String email) {
        users.stream().filter(user -> user.getEmail().equals(email)).findFirst().ifPresent(user -> users.remove(user));
    }

    @Override
    public void updateUser(User user) {
        Optional<User> user1 = getUser(user.getEmail());
        if (user1.isPresent()) {
            User user2 = user1.get();
            user2.setName(user.getName());
            user2.setBalance(user.getBalance());
            user2.setCarType(user.getCarType());
        }
    }
}
