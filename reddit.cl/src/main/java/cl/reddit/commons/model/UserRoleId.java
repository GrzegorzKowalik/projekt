package cl.reddit.commons.model;

import cl.reddit.user.model.User;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class UserRoleId {

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_role", referencedColumnName = "id")
    private Role role;
}
