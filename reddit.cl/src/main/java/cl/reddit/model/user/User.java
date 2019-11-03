package cl.reddit.model.user;

import cl.reddit.model.file.File;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;


@Entity
@Table(name = "user_")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "id_status", referencedColumnName = "id")
    private UserStatus userStatus;

    @NotNull
    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles;

    @NotNull
    @Column(name = "nick", length = 30)
    private String nick;

    @NotNull
    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "reputation")
    private int reputation;

    @NotNull
    @Column(name = "email", length = 255)
    private String email;

    @NotNull
    @CreationTimestamp
    @Column(name = "ts_created")
    private Timestamp tsCreated;

    @Column(name = "ts_last_logged")
    private Timestamp tsLastLogged;

    @NotNull
    @Column(name = "ts_status_changed")
    private Timestamp tsStatusChanged;

    @OneToMany(mappedBy = "user")
    private Set<File> files;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getTsCreated() {
        return tsCreated;
    }

    public void setTsCreated(Timestamp tsCreated) {
        this.tsCreated = tsCreated;
    }

    public Timestamp getTsLastLogged() {
        return tsLastLogged;
    }

    public void setTsLastLogged(Timestamp tsLastLogged) {
        this.tsLastLogged = tsLastLogged;
    }

    public Timestamp getTsStatusChanged() {
        return tsStatusChanged;
    }

    public void setTsStatusChanged(Timestamp tsStatusChanged) {
        this.tsStatusChanged = tsStatusChanged;
    }

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userStatus=" + userStatus +
                ", userRoles=" + userRoles +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                ", reputation=" + reputation +
                ", email='" + email + '\'' +
                ", tsCreated=" + tsCreated +
                ", tsLastLogged=" + tsLastLogged +
                ", tsStatusChanged=" + tsStatusChanged +
                ", files=" + files +
                '}';
    }
}
