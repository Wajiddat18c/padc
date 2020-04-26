package padc.dat18c.renoblvd.auth;

import javax.persistence.*;

@Entity
@Table(name = "auth_user_group")
public class AuthGroup {

    @Id
    @Column(name = "AUTH_USER_GROUP_ID")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "AUTH_GROUP")
    private String groupAuth;

    public AuthGroup() {
    }

    public AuthGroup(String username, String authGroup) {
        this.username = username;
        this.groupAuth = authGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroupAuth() {
        return groupAuth;
    }

    public void setGroupAuth(String groupAuth) {
        this.groupAuth = groupAuth;
    }
}