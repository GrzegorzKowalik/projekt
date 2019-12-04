package cl.reddit.repository;

import cl.reddit.model.user.UserRole;

public class UserRoleRepository extends AbstractRepository<UserRole> {

    public UserRole create(UserRole userRole){
        userRole.setId((Long)super.create(userRole));
        return userRole;
    }
}
