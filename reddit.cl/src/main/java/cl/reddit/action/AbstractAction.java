package cl.reddit.action;

import cl.reddit.model.user.User;
import cl.reddit.service.user.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractAction extends ActionSupport implements SessionAware {

    private UserService userService = new UserService();

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

    public void setUserService(UserService userService) {
        this.userService = userService;
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
}
