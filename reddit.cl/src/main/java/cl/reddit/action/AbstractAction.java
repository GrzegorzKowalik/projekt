package cl.reddit.action;

import cl.reddit.model.category.Category;
import cl.reddit.model.post.Post;
import cl.reddit.model.user.User;
import cl.reddit.service.category.CategoryService;
import cl.reddit.service.post.CommentService;
import cl.reddit.service.post.PostService;
import cl.reddit.service.user.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractAction extends ActionSupport implements SessionAware {

    private UserService userService = new UserService();
    protected PostService postService = new PostService();
    protected CommentService commentService = new CommentService();
    protected CategoryService categoryService = new CategoryService();

    private SessionMap session ;
    protected final String JSON = "json";

    //Session map keys
    private final String USER = "user";

    //JSON  basic fields
    protected final String STATUS = "status";

    //JSON statuses
    protected final String OK = "ok";
    protected final String ERROR = "error";

    //JSON result
    private String resultJSON = null;

    protected void putUserInSession(String email) {
        getSession().put(USER, getUserService().findByEmail(email));
    }

    protected void putUserInSession(User user) {
        getSession().put(USER, user);
    }

    public User getUserFromSession() {
        return (User)getSession().get(USER);
    }

    public void setSession(Map<String, Object> session) {
        this.session = (SessionMap)session;
    }

    protected SessionMap getSession() {
        return session;
    }

    public UserService getUserService() {
        return userService;
    }


    public String getResultJSON() {
        return resultJSON;
    }

    public void setResultJSON(String resultJSON) {
        this.resultJSON = resultJSON;
    }

    public boolean hasRole(String role) {
        if (getUserFromSession() != null) {
            return getUserFromSession().getUserRoles().stream().map(x -> x.getRole().getId()).collect(Collectors.toList()).contains(role);
        }
        return false;
    }

    public List<Post> getAllPosts() {
        List<Post> list = postService.findAll();
        Collections.reverse(list);
        return list;
    }

    public List<Post> getAllPostsFromCategory(Long idCategory) {
        List<Post> result = new ArrayList<>();
        Category resultCat = categoryService.findById(idCategory);
        if (resultCat != null) {
            result = new ArrayList<>(resultCat.getPosts());
        }
        return result;
    }

    public List<Post> getAllPostsOfUser(Long idUser) {
        return postService.findByIdUser(idUser);
    }

    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }
}
