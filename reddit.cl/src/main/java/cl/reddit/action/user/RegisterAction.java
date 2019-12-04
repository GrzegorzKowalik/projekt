package cl.reddit.action.user;

import cl.reddit.action.AbstractAction;
import cl.reddit.model.user.dto.UserDTO;
import cl.reddit.service.commons.RegistrationService;
import org.apache.struts2.convention.annotation.*;
import org.json.JSONArray;
import org.json.JSONObject;

@Namespace("")
@ParentPackage("json-default")
@Results({
        @Result(name = "json", type = "json", params = {"root", "resultJSON"})
})
public class RegisterAction extends AbstractAction {

    private UserDTO userDTO;

    private RegistrationService registrationService = new RegistrationService();

    @Action("sign-in")
    public String signIn() {
        boolean errors = false;
        JSONObject result = new JSONObject();
        result.put(STATUS, ERROR);
        if(getRegistrationService().nickAlreadyExists(getUserDTO().getNick().trim())) {
            result.put("userDTO.nick", "Duplicate nick!");
            errors = true;
        }
        if(getRegistrationService().emailAlreadyExists(getUserDTO().getEmail().trim())) {
            result.put("userDTO.email", "Duplicate email!");
            errors = true;
        }
        if(getUserDTO().getPassword().trim().length() < 4) {
            result.put("userDTO.password", "Password must be at least 4 characters long!");
            errors = true;
        }
        if(!errors && getRegistrationService().registerUserFromUserDTO(getUserDTO())) {
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

    public RegistrationService getRegistrationService() {
        return registrationService;
    }

    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
}
