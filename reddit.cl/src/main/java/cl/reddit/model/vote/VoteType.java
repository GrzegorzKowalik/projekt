package cl.reddit.model.vote;

import cl.reddit.model.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "vote_type")
public class VoteType extends AbstractEntity implements Serializable {

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
