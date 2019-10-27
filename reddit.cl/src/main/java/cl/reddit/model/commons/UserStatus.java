package cl.reddit.model.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_status")
public class UserStatus {

    @Id
    @Column(name = "id", length = 20)
    private String id;
}
