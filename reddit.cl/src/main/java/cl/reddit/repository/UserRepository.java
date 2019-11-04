package cl.reddit.repository;

import cl.reddit.model.user.User;
import cl.reddit.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class UserRepository implements IRepository<User>{

    Logger log = LoggerFactory.getLogger(UserRepository.class);

    @Override
    public User create(User user) {
        Long result = null;
        Session session = HibernateUtil.getSession();
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
        return null;
    }

    @Override
    public Set<User> findAll() {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }
}
