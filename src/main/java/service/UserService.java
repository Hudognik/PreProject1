package service;

import entity.User;
import util.UserDaoFactory;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService instance;

    private UserService() {
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public boolean updateUserInfo(User user) {
        try {
            UserDaoFactory.getInstance().getDAO().update(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteUser(Integer id) {
        try {
            UserDaoFactory.getInstance().getDAO().deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<User> getAllUsers() {
        try {
            return UserDaoFactory.getInstance().getDAO().getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean addUser(User user) {
        try {
            List<User> list = UserDaoFactory.getInstance().getDAO().getAll();
            for (User item : list) {
                if (item.getName().equals(user.getName())) {
                    return false;
                }
            }
            UserDaoFactory.getInstance().getDAO().add(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
