package cl.reddit.service.user;

import cl.reddit.model.user.User;
import cl.reddit.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User findByEmail(String email) {
        return getUserRepository().findByEmail(email);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
