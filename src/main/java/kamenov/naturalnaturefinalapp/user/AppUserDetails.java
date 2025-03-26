package kamenov.naturalnaturefinalapp.user;

import kamenov.naturalnaturefinalapp.entity.UserEntity;
import kamenov.naturalnaturefinalapp.entity.UserRoleEnt;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AppUserDetails extends org.springframework.security.core.userdetails.User {

    private String fullName;
    private final UserEntity userEntity;

    public AppUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userEntity = null; // Ще го инициализираме по-късно, ако е нужно
    }

    public AppUserDetails(UserEntity userEntity) {
        super(userEntity.getUsername(), userEntity.getPassword(),
                userEntity.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole().name()))
                        .collect(Collectors.toList()));
        this.userEntity = userEntity;
        this.fullName = userEntity.getFullName();
    }
    public AppUserDetails setFullName(String fullName) {
        this.fullName = fullName;
        return this; // Връща this за method chaining
    }


    private static Collection<? extends GrantedAuthority>
    mapRolesToAuthorities(List<UserRoleEnt> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole().name()))
                .collect(Collectors.toList());
    }


    public String getFullName() {
        return fullName != null ? fullName : (userEntity != null ? userEntity.getFullName() : null);
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

}