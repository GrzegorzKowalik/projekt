package cl.reddit.action.user;

import cl.reddit.action.AbstractAction;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("")
@Results({
//        @Result(name = "json", type = "json", params = {"root", "resultJSON"})
        @Result(name = "success", location = "index.jsp"),
        @Result(name = "error", location = "login.jsp")
})
public class WelcomeAction extends AbstractAction {
}
