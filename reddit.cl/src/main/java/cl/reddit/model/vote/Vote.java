package cl.reddit.model.vote;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private Long idUser;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_post", referencedColumnName = "id")
    private Long idPost;

    @ManyToOne
    @JoinColumn(name = "id_comment", referencedColumnName = "id")
    private Long idComment;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_type", referencedColumnName = "id")
    private VoteType voteType;

    @CreationTimestamp
    @NotNull
    @Column(name = "ts_created")
    private Timestamp tsCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteType voteType) {
        this.voteType = voteType;
    }

    public Timestamp getTsCreated() {
        return tsCreated;
    }

    public void setTsCreated(Timestamp tsCreated) {
        this.tsCreated = tsCreated;
    }
}
