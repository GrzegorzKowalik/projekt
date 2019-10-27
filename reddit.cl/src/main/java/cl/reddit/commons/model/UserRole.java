package cl.reddit.commons.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {

    @EmbeddedId
    private UserRoleId userRoleId;
}
