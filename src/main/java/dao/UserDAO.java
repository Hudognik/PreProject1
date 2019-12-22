package dao;

import entity.User;

import java.util.List;

public interface UserDAO extends DAO<User, Integer> {

    @Override
    List<User> getAll();

    @Override
    void add(User user);

    @Override
    void update(User user);

    @Override
    void deleteById(Integer id);
}
