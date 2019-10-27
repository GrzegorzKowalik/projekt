package cl.reddit.commons.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id", length = 20)
    private String id;
}
