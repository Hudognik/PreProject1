package dao;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends DAO<User, Integer> {

    @Override
    List<User> getAll() throws SQLException;

    @Override
    void add(User user) throws SQLException;

    @Override
    void update(User user) throws SQLException;

    @Override
    void deleteById(Integer id) throws SQLException;
}
