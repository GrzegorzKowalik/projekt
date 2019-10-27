package cl.reddit.user.model;

import cl.reddit.commons.model.UserStatus;
import cl.reddit.commons.model.UserRole;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_status", referencedColumnName = "id")
    private UserStatus userStatus;

    @OneToMany
    @JoinColumn(name = "id_user", referencedColumnName = "id_role")
    private List<UserRole> userRoles;

    @Column(name = "nick", length = 30)
    private String nick;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "reputation")
    private int reputation;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "ts_created")
    @CreationTimestamp
    private Timestamp tsCreated;

    @Column(name = "ts_last_logged")
    private Timestamp tsLastLogged;

    @Column(name = "ts_status_changed")
    private Timestamp tsStatusChanged;

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

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
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
}
