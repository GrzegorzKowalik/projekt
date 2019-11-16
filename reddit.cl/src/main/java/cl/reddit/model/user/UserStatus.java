package cl.reddit.model.user;

import cl.reddit.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user_status")
public class UserStatus extends AbstractEntity implements Serializable {

    public UserStatus() {
        super();
    }

    public UserStatus(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "id", length = 20)
    private String id;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
