package cl.reddit.repository;

import cl.reddit.model.user.User;
import cl.reddit.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        boolean result = false;
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("SELECT 1 FROM User WHERE email = :email OR nick = :nick");
        query.setParameter("email", email);
        query.setParameter("nick", nick);
        result = query.getResultList().size() > 0;
        session.close();
        return result;
    }

    public User findByEmail(String email) {
        User result = null;
        Session session = HibernateUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        List<User> users = session.createQuery(criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("email"), email))).getResultList();
        if (users.size() == 1){
            result = users.get(0);
        }
        session.close();
        return result;
    }
}
