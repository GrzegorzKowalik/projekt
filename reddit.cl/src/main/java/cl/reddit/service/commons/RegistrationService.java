package cl.reddit.service.commons;

import cl.reddit.model.user.Role;
import cl.reddit.model.user.User;
import cl.reddit.model.user.UserRole;
import cl.reddit.model.user.UserStatus;
import cl.reddit.model.user.dto.UserDTO;
import cl.reddit.model.user.enumeration.EUserRole;
import cl.reddit.model.user.enumeration.EUserStatus;
import cl.reddit.repository.UserRepository;
import cl.reddit.repository.UserRoleRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Service
public class RegistrationService {

    private UserRepository userRepository = new UserRepository();
    private UserRoleRepository userRoleRepository = new UserRoleRepository();

    public boolean registerUserFromUserDTO(UserDTO userDTO) {
        User user = new User();
        user.setUserStatus(new UserStatus(EUserStatus.ACTIVE.name()));
        user.setEmail(userDTO.getEmail().trim());
        user.setNick(userDTO.getNick().trim());
        user.setPassword(DigestUtils.sha256Hex(userDTO.getPassword()));
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        user.setTsCreated(stamp);
        user.setTsStatusChanged(stamp);
        user = userRepository.create(user);
        if (user != null && user.getId() > 0) {
            Set<UserRole> userRoles = new HashSet<>();
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            Role role = new Role();
            role.setId(EUserRole.ROLE_USER.name());
            userRole.setRole(role);
            userRoles.add(userRoleRepository.create(userRole));
            user.setUserRoles(userRoles);
        }
        return user.getId() != null && user.getId() > 0;
    }

    public boolean nickAlreadyExists(String nick) {
        return userRepository.emailOrNickExists(nick, null);
    }

    public boolean emailAlreadyExists(String email) {
        return userRepository.emailOrNickExists(null, email);
    }
}
