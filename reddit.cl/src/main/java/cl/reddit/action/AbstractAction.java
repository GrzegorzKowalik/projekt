package cl.reddit.action;

import cl.reddit.model.user.User;
import cl.reddit.repository.UserRepository;
import cl.reddit.service.user.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public abstract class AbstractAction extends ActionSupport {

    private UserService userService = new UserService();

    private Map<String, Object> session = ActionContext.getContext().getSession();
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

    protected User getUserFromSession() {
        return (User)getSession().get(USER);
    }

    private Map<String, Object> getSession() {
        return session;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getResultJSON() {
        return resultJSON;
    }

    public void setResultJSON(String resultJSON) {
        this.resultJSON = resultJSON;
    }
}
