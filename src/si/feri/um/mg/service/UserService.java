package src.si.feri.um.mg.service;

import src.si.feri.um.mg.dao.UserDAO;
import src.si.feri.um.mg.vao.User;

public class UserService {

    private final UserDAO userDAO = UserDAO.getInstance();

    public User createUser(String name, String email, String carType, double balance) {
        if (email == null || name == null || balance < 0 || carType == null) {
            throw new IllegalArgumentException();
        }
        User user = new User(email, name, balance, carType);
        userDAO.addUser(user);
        return user;
    }
}
