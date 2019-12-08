package cl.reddit.action.user;

import cl.reddit.action.AbstractAction;
import cl.reddit.model.user.dto.UserDTO;
import cl.reddit.service.commons.RegistrationService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("")
@Results({
//        @Result(name = "json", type = "json", params = {"root", "resultJSON"})
        @Result(name = "success", location = "register.jsp"),
        @Result(name = "error", location = "register.jsp"),
        @Result(name = "registered", location = "login.jsp")
})
public class RegisterAction extends AbstractAction {

    private UserDTO userDTO;
    private final String REGISTERED = "registered";

    private RegistrationService registrationService = new RegistrationService();


    @Action("sign-in")
    public String signIn() {
        boolean errors = false;
        if(userDTO == null) {
            addFieldError("userDTO", "Object is null!");
        } else {
            if (getRegistrationService().nickAlreadyExists(getUserDTO().getNick().trim())) {
                addFieldError("userDTO.nick", "Duplicate nick!");
                errors = true;
            }
            if (getRegistrationService().emailAlreadyExists(getUserDTO().getEmail().trim())) {
                addFieldError("userDTO.email", "Duplicate email!");
                errors = true;
            }
            if (getUserDTO().getPassword().trim().length() < 4) {
                addFieldError("userDTO.password", "Password must be at least 4 characters long!");
                errors = true;
            }
            if (!errors && getRegistrationService().registerUserFromUserDTO(getUserDTO())) {
                return REGISTERED;
            }
        }
        return ERROR;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public RegistrationService getRegistrationService() {
        return registrationService;
    }

    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
}
