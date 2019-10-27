package cl.reddit.model.vote;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vote_type")
public class VoteType {

    @Id
    @Column(name = "id", length = 20)
    private String id;
}
