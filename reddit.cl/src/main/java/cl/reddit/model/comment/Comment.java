package cl.reddit.model.comment;

import cl.reddit.model.AbstractEntity;
import cl.reddit.model.post.Post;
import cl.reddit.model.user.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "comment")
public class Comment extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = { CascadeType.ALL})
    @JoinColumn(name = "id_parent", referencedColumnName = "id")
    private Comment parent;

    @OrderBy("tsCreated asc")
    @OneToMany(mappedBy = "parent")
    private Set<Comment> subComments = new LinkedHashSet<Comment>();

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_post", referencedColumnName = "id")
    private Post post;

    @NotNull
    @Column(name = "body", length = 1000)
    private String body;

    @NotNull
    @CreationTimestamp
    @Column(name = "ts_created")
    private Timestamp tsCreated;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public Set<Comment> getSubComments() {
        return subComments;
    }

    public void setSubComments(Set<Comment> subComments) {
        this.subComments = subComments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getTsCreated() {
        return tsCreated;
    }

    public void setTsCreated(Timestamp tsCreated) {
        this.tsCreated = tsCreated;
    }
}
