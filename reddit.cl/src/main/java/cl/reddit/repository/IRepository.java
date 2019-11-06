package cl.reddit.repository;

import java.lang.reflect.Type;
import java.util.Set;

public interface IRepository<T> {

    T findById(Long id);
    Set<T> findAll();
    T create(T t);
    boolean delete(T t);
    boolean update(T t);
}
