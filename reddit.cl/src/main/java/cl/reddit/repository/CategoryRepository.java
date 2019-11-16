package cl.reddit.repository;

import cl.reddit.model.category.Category;
import cl.reddit.util.HibernateUtil;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CategoryRepository extends AbstractRepository<Category> {

    private Logger log = LoggerFactory.getLogger(UserRepository.class);

    public Category findById(Long id) {
        return super.findById(id, Category.class);
    }

    public List<Category> findAll() {
        return super.findAll(Category.class);
    }

    public boolean delete(Long id) {
        return super.delete(id, Category.class);
    }

    @Override
    public Category create(Category category) {
        category.setId((Long)super.create(category));
        return category;
    }
}
