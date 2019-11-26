package cl.reddit.service.commons;

import cl.reddit.model.user.User;
import cl.reddit.model.user.UserStatus;
import cl.reddit.model.user.dto.UserDTO;
import cl.reddit.model.user.enumeration.EUserStatus;
import cl.reddit.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class RegistrationService {

    private UserRepository userRepository = new UserRepository();

    public boolean registerUserFromUserDTO(UserDTO userDTO) {
        User user = new User();
        user.setUserStatus(new UserStatus(EUserStatus.ACTIVE.name()));
        user.setEmail(userDTO.getEmail().trim());
        user.setNick(userDTO.getNick().trim());
        user.setPassword(userDTO.getPassword());
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        user.setTsCreated(stamp);
        user.setTsStatusChanged(stamp);
        user = userRepository.create(user);
        return user.getId() != null && user.getId() > 0;
    }

    public boolean nickAlreadyExists(String nick) {
        return userRepository.emailOrNickExists(nick, null);
    }

    public boolean emailAlreadyExists(String email) {
        return userRepository.emailOrNickExists(null, email);
    }
}
