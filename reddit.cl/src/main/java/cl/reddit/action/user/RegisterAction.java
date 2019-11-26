package cl.reddit.action.user;

import cl.reddit.action.AbstractAction;
import cl.reddit.model.user.dto.UserDTO;
import cl.reddit.service.commons.RegistrationService;
import org.apache.struts2.convention.annotation.*;
import org.json.JSONObject;

@Namespace("")
@ParentPackage("json-default")
@Results({
        @Result(name = "success", location = "index.jsp"),
        @Result(name = "json", type = "json", params = {"root", "resultJSON"}),
        @Result(name = "registered", location = "user/welcome.jsp")
})
public class RegisterAction extends AbstractAction {

    private UserDTO userDTO;
    private String resultJSON = null;

    private RegistrationService registrationService = new RegistrationService();

    @Action("sign-in")
    public String signIn() {
        boolean errors = false;
        JSONObject result = new JSONObject();
        result.put(STATUS, ERROR);
        if(registrationService.nickAlreadyExists(getUserDTO().getNick().trim())) {
            result.put("userDTO.nick", "Duplicate nick!");
            errors = true;
        }
        if(registrationService.emailAlreadyExists(getUserDTO().getEmail().trim())) {
            result.put("userDTO.email", "Duplicate email!");
            errors = true;
        }
        if(getUserDTO().getPassword().trim().length() < 4) {
            result.put("userDTO.password", "Password must be at least 4 characters long!");
            errors = true;
        }
        if(!errors && registrationService.registerUserFromUserDTO(getUserDTO())) {
            result.put(STATUS, OK);
        }
        setResultJSON(result.toString());
        return "json";
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getResultJSON() {
        return resultJSON;
    }

    public void setResultJSON(String resultJSON) {
        this.resultJSON = resultJSON;
    }
}
