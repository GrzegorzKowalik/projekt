package cl.reddit.repository;

import cl.reddit.model.user.User;
import cl.reddit.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import java.util.List;

public class UserRepository extends AbstractRepository<User> {

    private Logger log = LoggerFactory.getLogger(UserRepository.class);

    @Override
    public User create(User user) {
        Long result = 0L;
        if(emailOrNickExists(user.getNick(), user.getEmail()))
            return user;
        if(user.getId() == null || user.getId() <= 0) {
            result = (Long)super.create(user);
        }
        user.setId(result);
        return user;
    }

    public User findById(Long id) {
        return super.findById(id, User.class);
    }

    public List<User> findAll() {
        return super.findAll(User.class);
    }

    public boolean delete(Long id) {
        return super.delete(id, User.class);
    }

    public boolean emailOrNickExists(String nick, String email) {
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("SELECT 1 FROM User WHERE email = :email OR nick = :nick");
        query.setParameter("email", email);
        query.setParameter("nick", nick);
        return query.getResultList().size() > 0;
    }
}
