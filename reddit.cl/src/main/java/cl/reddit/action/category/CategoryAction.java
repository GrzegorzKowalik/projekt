package cl.reddit.action.category;

import cl.reddit.action.AbstractAction;
import cl.reddit.model.category.Category;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import java.util.List;

@Namespace("/category")
@Results({
        @Result(name = "success", location = "category.jsp")
//        @Result(name = "json", type = "json", params = {"root", "resultJSON"})
})
public class CategoryAction extends AbstractAction {

    private Long idCategory;
    private Category category;

    @Override
    public String execute() throws Exception {
        setCategory(categoryService.findById(idCategory));
        return SUCCESS;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
