package cl.reddit.action.user;

import cl.reddit.action.AbstractAction;
import cl.reddit.model.user.User;
import cl.reddit.model.user.dto.UserDTO;
import cl.reddit.service.user.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.convention.annotation.*;
import org.json.JSONObject;


@Namespace("")
@ParentPackage("json-default")
@Results({
        @Result(name = "json", type = "json", params = {"root", "resultJSON"})
})
public class LoginAction extends AbstractAction {

    private UserDTO userDTO;

    @Action("log-in")
    public String userLogin(){
        JSONObject result = new JSONObject();
        result.put(STATUS, ERROR);
        if(getUserDTO() != null) {
            User userToLogin = getUserService().findByEmail(getUserDTO().getEmail());
            if (userToLogin != null) {
                if (userToLogin.getPassword().equals(DigestUtils.sha256Hex(getUserDTO().getPassword()))) {
                    putUserInSession(userToLogin);
                    result.put(STATUS, OK);
                } else {
                    result.put("userDTO.password", "Wrong password!");
                }
            } else {
                result.put("userDTO.email", "User with given email not found!");
            }
        } else {
            result.put("userDTO", "Not recognized object!");
        }
        setResultJSON(result.toString());
        System.out.println(getUserFromSession());
        return JSON;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }


}
