package cl.reddit.repository;

import cl.reddit.model.AbstractEntity;
import cl.reddit.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

abstract class AbstractRepository<T extends AbstractEntity> {

    Serializable create(T t) {
        Long result;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        result = (Long)session.save(t);
        session.getTransaction().commit();
        return result;
    };

    T findById(Serializable id, Class<T> clazz) {
        T result = null;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        result = session.get(clazz, id);
        session.getTransaction().commit();
        return result;
    };

    List<T> findAll(Class<T> clazz) {
        Session session = HibernateUtil.getSession();
        CriteriaQuery<T> cq = session.getCriteriaBuilder().createQuery(clazz);
        Root<T> entry = cq.from(clazz);
        List<T> result = session.createQuery(cq.select(entry)).getResultList();
        return result;
    };

    boolean delete(Serializable id, Class<T> clazz){
        boolean result;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(id);
        result = session.load(clazz, id) != null;
        session.getTransaction().commit();
        return result;
    }

    public boolean update(T t) {
        boolean result = false;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        result = (T)session.merge(t) != null;
        session.getTransaction().commit();
        return result;
    };
}
