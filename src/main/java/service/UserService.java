package service;

import dao.UserJdbcDAO;
import entity.User;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
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
            getUserDAO().update(user);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteUser(Integer id) {
        try {
            getUserDAO().deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<User> getAllUsers() {
        try {
            return getUserDAO().getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public boolean addUser(User user) {
        UserJdbcDAO service = getUserDAO();
        try {
            List<User> list = service.getAll();
            for (User item : list) {
                if (item.getName().equals(user.getName())) {
                    return false;
                }
            }
            getUserDAO().add(user);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").                  //db type
                    append("127.0.0.1:").                     //host name
                    append("3306/").                          //port
                    append("db_example?").                    //db name
                    append("user=root&").                     //login
                    append("password=325033325033");          //password


            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    private static UserJdbcDAO getUserDAO() {
        try {
            return new UserJdbcDAO(getMysqlConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
