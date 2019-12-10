package cl.reddit.action.user;

import cl.reddit.action.AbstractAction;
import cl.reddit.model.user.User;
import cl.reddit.model.user.dto.UserDTO;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;


@Namespace("/")
@Results({
//        @Result(name = "json", type = "json", params = {"root", "resultJSON"})
        @Result(name = "logged", location = "index.jsp"),
        @Result(name = "error", location = "login.jsp"),
        @Result(name = "success", location = "login.jsp")
})
public class LoginAction extends AbstractAction {

    private UserDTO userDTO;
    private final String LOGGED = "logged";

    @Action("log-in")
    public String userLogin(){
        if(getUserDTO() != null) {
            User userToLogin = getUserService().findByEmail(getUserDTO().getEmail());
            if (userToLogin != null) {
                if (userToLogin.getPassword().equals(DigestUtils.sha256Hex(getUserDTO().getPassword()))) {
                    putUserInSession(userToLogin);
                    return LOGGED;
                } else {
                    addFieldError("userDTO.password", "Wrong password!");
                }
            } else {
                addFieldError("userDTO.email", "User with given email not found!");
            }
        } else {
            addFieldError("userDTO", "Not recognized object!");
        }
        return ERROR;
    }

    @Action("log-out")
    public String userLogout(){
        getSession().invalidate();
        return LOGGED;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
