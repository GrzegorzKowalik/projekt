package cl.reddit.action.user;

import cl.reddit.model.user.dto.UserDTO;
import cl.reddit.service.commons.RegistrationService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("")
@Results({
        @Result(name = "success", location = "register.jsp"),
        @Result(name = "registered", location = "index.jsp")
})
@Action("register")
public class RegisterAction extends ActionSupport {

    private UserDTO userDTO;

    private RegistrationService registrationService = new RegistrationService();

    @Action("sign-in")
    public String signIn(){
        if(registrationService.registerUserFromUserDTO(getUserDTO()))
            return "registered";
        return "success";
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
