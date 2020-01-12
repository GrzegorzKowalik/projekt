package cl.reddit.action.user;

import cl.reddit.action.AbstractAction;
import cl.reddit.model.user.User;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/user")
@Results({
        @Result(name = "user", location = "user.jsp")
//        @Result(name = "json", type = "json", params = {"root", "resultJSON"})
})
public class UserAction extends AbstractAction {
    private static final String USER = "user";

    private User user;
    @Action("user-content")
    public String userContent() {
        if (getUser() != null && getUser().getId() > 0){
             return USER;
        }
        return ERROR;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
