package cl.reddit.repository;

import cl.reddit.model.user.User;
import cl.reddit.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserRepository {

    Logger log = LoggerFactory.getLogger(UserRepository.class);

    public User save(User user) {
        Session session = HibernateUtil.getSession();
        if(user.getId() == null) {
            session.beginTransaction();
            user = (User)session.save(user);
            session.getTransaction().commit();
            session.close();
            log.info("Inserted user:" + user.toString());
        } else {
            session.beginTransaction();
            user = (User)session.merge(user);
            session.getTransaction().commit();
            session.close();
            log.info("Updated user:" + user.toString());
        }
        return user;
    }
}
