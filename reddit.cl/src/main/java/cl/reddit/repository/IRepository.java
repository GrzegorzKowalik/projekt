package cl.reddit.repository;

import java.util.List;

public interface IRepository<T> {

    T findById(Long id);
    List<T> findAll();
    T create(T t);
    boolean delete(T t);
    boolean update(T t);
}
