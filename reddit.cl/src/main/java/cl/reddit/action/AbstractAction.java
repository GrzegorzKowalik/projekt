package cl.reddit.action;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport {
    protected final String JSON = "json";

    //JSON  basic fields
    protected final String STATUS = "status";

    //JSON statuses
    protected final String OK = "ok";
    protected final String ERROR = "error";
}
