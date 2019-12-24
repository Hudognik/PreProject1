package dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T, V> {

    List<T> getAll() throws SQLException;

    void add(T t) throws SQLException;

    void update(T t) throws SQLException;

    void deleteById(V id) throws SQLException;
}

