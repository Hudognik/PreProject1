package dao;

import java.util.List;

public interface DAO<T, V> {

    List<T> getAll();

    void add(T t);

    void update(T t);

    void deleteById(V id);
}

