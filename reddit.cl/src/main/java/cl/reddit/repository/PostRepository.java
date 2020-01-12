package cl.reddit.repository;

import cl.reddit.model.post.Post;
import cl.reddit.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PostRepository extends AbstractRepository<Post> {

    private Logger log = LoggerFactory.getLogger(PostRepository.class);


    public Post findById(Long id) {
        return super.findById(id, Post.class);
    }

    public List<Post> findAll() {
        return super.findAll(Post.class);
    }

    public boolean delete(Long id) {
        return super.delete(id, Post.class);
    }

    @Override
    public Post create(Post post) {
        post.setId((Long)super.create(post));
        return post;
    }

    public List<Post> findByIdUser(Long idUser) {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> root = criteriaQuery.from(Post.class);
        List<Post> posts = session.createQuery(criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("user"), idUser))).getResultList().stream().sorted(new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return o1.getTsCreated().compareTo(o2.getTsCreated());
            }
        }).collect(Collectors.toList());
        session.close();
        return posts;
    }

    public List<Post> findByIdCategory(Long idCategory) {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Post> criteriaQuery = criteriaBuilder.createQuery(Post.class);
        Root<Post> root = criteriaQuery.from(Post.class);
        List<Post> posts = session.createQuery(criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("category"), idCategory))).getResultList().stream().sorted(new Comparator<Post>() {
            @Override
            public int compare(Post o1, Post o2) {
                return o2.getTsCreated().compareTo(o1.getTsCreated());
            }
        }).collect(Collectors.toList());
        session.close();
        return posts;
    }
}
