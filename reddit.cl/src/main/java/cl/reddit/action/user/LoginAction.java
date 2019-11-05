package cl.reddit.action.user;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;


@Namespace("")
@Results({
        @Result(name = "success", location = "login.jsp"),
        @Result(name = "logged", location = "/user/welcome.jsp")
})
@Action("login")
public class LoginAction extends ActionSupport {

    @Action("log-in")
    public String userLogin(){
        return "logged";
    }
}
