package cl.reddit.model.user;

import cl.reddit.model.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role extends AbstractEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 20)
    private String id;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                '}';
    }
}
