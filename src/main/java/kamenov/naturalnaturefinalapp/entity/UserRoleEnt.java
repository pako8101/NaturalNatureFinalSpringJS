package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.*;
import kamenov.naturalnaturefinalapp.entity.enums.UserRoleEnum;


@Entity
@Table(name = "roles")
public class UserRoleEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    public UserRoleEnt() {
    }

    public Long getId() {
        return id;
    }

    public UserRoleEnt setId(Long id) {
        this.id = id;
        return this;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public UserRoleEnt setRole(UserRoleEnum role) {
        this.role = role;
        return this;
    }
}
