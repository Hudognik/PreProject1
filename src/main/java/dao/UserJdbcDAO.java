package dao;

import entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO {
    private Connection connection;

    public UserJdbcDAO(Connection connection) throws SQLException {
        this.connection = connection;
        createTable();
    }

    @Override
    public User getById(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT from user where id=?");
        statement.setLong(1, id);
        User user = (User) statement.executeQuery();
        statement.close();
        return user;
    }

    @Override
    public List<User> getAll() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("select * from user");
        ResultSet result = statement.getResultSet();
        List<User> clients = new ArrayList<User>();
        while (result.next()) {
            clients.add(new User(result.getInt("id"), result.getString("name"), result.getString("password"), result.getString("email")));
        }
        result.close();
        statement.close();
        return clients;
    }

    @Override
    public void add(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into user (name, password, email) values (?,?,?)");
        statement.setString(1, user.getName());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getEmail());
        statement.execute();
        statement.close();
    }

    @Override
    public void update(User user) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("update user set name=?, password=?, email=? where id=?");
        statement.setString(1, user.getName());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getEmail());
        statement.setInt(4, user.getId());
        statement.execute();
        statement.close();
    }

    @Override
    public void deleteById(Integer id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("delete from user where id=?");
        statement.setLong(1, id);
        statement.execute();
        statement.close();
    }

    public void createTable() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("create table if not exists user (id int auto_increment, name varchar(256), password varchar(256), email varchar(256), primary key (id))");
        stmt.close();
    }
}
