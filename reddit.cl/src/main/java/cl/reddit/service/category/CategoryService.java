package cl.reddit.service.category;

import cl.reddit.model.category.Category;
import cl.reddit.repository.CategoryRepository;

import java.util.Comparator;
import java.util.List;

public class CategoryService {

    private CategoryRepository categoryRepository = new CategoryRepository();

    public Category findById(Category category) {
        return findById(category.getId());
    }

    public Category findById(Long idCategory) {
        return categoryRepository.findById(idCategory);
    }

    public List<Category> findAll() {
        List<Category> result = categoryRepository.findAll();
        result.sort(new Comparator<Category>() {
            @Override
            public int compare(Category o1, Category o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return result;
    }
}
