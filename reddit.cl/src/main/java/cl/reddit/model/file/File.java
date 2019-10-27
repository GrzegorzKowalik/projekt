package cl.reddit.model.file;

import cl.reddit.model.comment.Comment;
import cl.reddit.model.post.Post;
import cl.reddit.model.user.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_post", referencedColumnName = "id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "id_comment", referencedColumnName = "id")
    private Comment comment;

    @NotNull
    @Column(name = "path", length = 1000)
    private String path;

    @NotNull
    @CreationTimestamp
    @Column(name = "ts_created")
    private Timestamp tsCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getTsCreated() {
        return tsCreated;
    }

    public void setTsCreated(Timestamp tsCreated) {
        this.tsCreated = tsCreated;
    }
}
