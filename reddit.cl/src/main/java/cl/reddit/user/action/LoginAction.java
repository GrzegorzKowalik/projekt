package cl.reddit.user.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;


@Namespace("/user")
@Results({
        @Result(name = "success", location = "login.jsp"),
        @Result(name = "logged", location = "index.jsp")
})
@Action("login")
public class LoginAction extends ActionSupport {

    @Action("log-in")
    public String userLogin(){
        return "logged";
    }
}