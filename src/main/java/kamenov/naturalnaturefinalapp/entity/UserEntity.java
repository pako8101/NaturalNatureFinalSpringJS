package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false,name = "full_name")
    private String fullName;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Subscription> subscriptions;
    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
    private List<UserRoleEnt> roles = new ArrayList<>(); ;

    public UserEntity() {
    }

    public UserEntity(String username, String fullName,
                      String email, String password) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;

    }

    public UserEntity(String username, String fullName, String email,
                      String password,  List<UserRoleEnt> roles) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;

        this.roles = roles;
    }

    public Set<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public UserEntity setSubscriptions(Set<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
        return this;
    }

    public Long getId() {
        return id;
    }



    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserEntity setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<UserRoleEnt> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<UserRoleEnt> roles) {
        this.roles = roles;
        return this;
    }
}
