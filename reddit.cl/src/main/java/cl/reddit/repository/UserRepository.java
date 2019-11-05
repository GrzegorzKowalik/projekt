package cl.reddit.repository;

import cl.reddit.model.user.User;
import cl.reddit.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRepository implements IRepository<User>{

    Logger log = LoggerFactory.getLogger(UserRepository.class);

    @Override
    public User create(User user) {
        Long result;
        Session session = HibernateUtil.getSession();
        if(emailOrNickExists(user.getNick(), user.getEmail()))
            return user;
        if(user.getId() == null || user.getId() <= 0) {
            session.beginTransaction();
            result = (Long)session.save(user);
            session.getTransaction().commit();
            session.close();
            log.info("Inserted user:" + user.toString());
        } else {
            session.beginTransaction();
            result = (Long)session.merge(user);
            session.getTransaction().commit();
            session.close();
            log.info("Updated user:" + user.toString());
        }
        user.setId(result);
        return user;
    }

    @Override
    public User findById(Long id) {
        User result = null;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        result = session.load(User.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<User> findAll() {
        Session session = HibernateUtil.getSession();
        CriteriaQuery<User> cq = session.getCriteriaBuilder().createQuery(User.class);
        Root<User> entry = cq.from(User.class);
        return session.createQuery(cq.select(entry)).getResultList();
    }

    @Override
    public boolean delete(User user) {
        boolean result = false;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(user);
        result = session.load(User.class, user.getId()) != null;
        session.getTransaction().commit();
        session.close();
        log.info("Deleted user:" + user.toString());
        return result;
    }

    @Override
    public boolean update(User user) {
        boolean result = false;
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        result = (Long)session.merge(user) > 0;
        session.getTransaction().commit();
        session.close();
        log.info("Updated user:" + user.toString());
        return result;
    }

    public boolean emailOrNickExists(String nick, String email) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("SELECT 1 FROM User WHERE email = :email OR nick = :nick");
        query.setParameter("email", email);
        query.setParameter("nick", nick);
        return query.getResultList().size() > 0;
    }
}
