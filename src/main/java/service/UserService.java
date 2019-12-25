package service;

import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import entity.User;
import util.HibernateUtil;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    public UserService() {
    }

    public boolean updateUserInfo(User user) {
        getUserDAO().update(user);
        return true;
    }

    public boolean deleteUser(Integer id) {
        getUserDAO().deleteById(id);
        return true;
    }

    public List<User> getAllUsers() {
        return getUserDAO().getAll();

    }


    public boolean addUser(User user) {
        UserHibernateDAO service = getUserDAO();
        List<User> list = service.getAll();
        for (User item : list) {
            if (item.getName().equals(user.getName())) {
                return false;
            }
        }
        getUserDAO().add(user);
        return true;
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

    private static UserHibernateDAO getUserDAO() {
        return new UserHibernateDAO(HibernateUtil.getSessionFactory().openSession());
    }
}
