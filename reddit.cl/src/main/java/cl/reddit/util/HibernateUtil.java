package cl.reddit.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateUtil {
    private static final SessionFactory concreteSessionFactory;
    static {
        try {
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(cl.reddit.model.user.User.class);
            cfg.addAnnotatedClass(cl.reddit.model.user.Role.class);
            cfg.addAnnotatedClass(cl.reddit.model.user.UserRole.class);
            cfg.addAnnotatedClass(cl.reddit.model.user.UserStatus.class);
            cfg.addAnnotatedClass(cl.reddit.model.post.Post.class);
            cfg.addAnnotatedClass(cl.reddit.model.vote.Vote.class);
            cfg.addAnnotatedClass(cl.reddit.model.vote.VoteType.class);
            cfg.addAnnotatedClass(cl.reddit.model.file.File.class);
            cfg.addAnnotatedClass(cl.reddit.model.comment.Comment.class);
            cfg.addAnnotatedClass(cl.reddit.model.category.Category.class);
            cfg.configure();
            concreteSessionFactory = cfg.buildSessionFactory();

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession() throws HibernateException {
        return concreteSessionFactory.openSession();
    }
}
