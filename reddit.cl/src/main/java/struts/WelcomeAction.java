package struts;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;


@Namespace("/")
@Result(name = "success", location = "index.jsp")
@Action("")
public class WelcomeAction extends ActionSupport {
}
