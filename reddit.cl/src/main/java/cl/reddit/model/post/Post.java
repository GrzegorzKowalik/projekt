package cl.reddit.model.post;

import cl.reddit.model.AbstractEntity;
import cl.reddit.model.category.Category;
import cl.reddit.model.comment.Comment;
import cl.reddit.model.file.File;
import cl.reddit.model.user.User;
import cl.reddit.model.vote.Vote;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private Category category;

    @NotNull
    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "body", length = 20000)
    private String body;

    @NotNull
    @CreationTimestamp
    @Column(name = "ts_created")
    private Timestamp tsCreated;

    @NotNull
    @UpdateTimestamp
    @Column(name = "ts_modified")
    private Timestamp tsModified;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private Set<File> files;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private Set<Vote> votes;

    @OrderBy("tsCreated asc")
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private Set<Comment> comments = new LinkedHashSet<Comment>();

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Timestamp getTsModified() {
        return tsModified;
    }

    public void setTsModified(Timestamp tsModified) {
        this.tsModified = tsModified;
    }

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
