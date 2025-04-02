package kamenov.naturalnaturefinalapp;

import kamenov.naturalnaturefinalapp.entity.UserEntity;
import kamenov.naturalnaturefinalapp.entity.UserRoleEnt;
import kamenov.naturalnaturefinalapp.entity.dto.RegisterDto;
import kamenov.naturalnaturefinalapp.entity.enums.UserRoleEnum;
import kamenov.naturalnaturefinalapp.repositories.UserRepository;
import kamenov.naturalnaturefinalapp.repositories.UserRoleRepository;
import kamenov.naturalnaturefinalapp.service.ApplicationUserDetailsService;
import kamenov.naturalnaturefinalapp.service.UserService;
import kamenov.naturalnaturefinalapp.user.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@SpringBootApplication

public class NaturalNatureFinalAppApplication {
//    @Autowired
//    private final UserService userService;
//
//    @Autowired
//    private final PasswordEncoder passwordEncoder;
//
//    public NaturalNatureFinalAppApplication( UserService userService,
//                                            PasswordEncoder passwordEncoder
//                                        ) {
//        this.userService = userService;
//        this.passwordEncoder = passwordEncoder;
//
//    }

    public static void main(String[] args) {
        SpringApplication.run(NaturalNatureFinalAppApplication.class, args);
    }
    @Bean
    public CommandLineRunner init(@Lazy UserService userService, UserRepository userRepository,
                                  UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Инициализация на роли
            if (userRoleRepository.count() == 0) {
                UserRoleEnt userRole = new UserRoleEnt();
                userRole.setRole(UserRoleEnum.USER);
                userRoleRepository.save(userRole);

                UserRoleEnt adminRole = new UserRoleEnt();
                adminRole.setRole(UserRoleEnum.ADMIN);
                userRoleRepository.save(adminRole);
            }

            // Инициализация на потребители
            if (userRepository.count() == 0) {
                UserRoleEnt adminRole = userRoleRepository.findByRole(UserRoleEnum.ADMIN)
                        .orElseThrow(() -> new IllegalStateException("ADMIN role not found"));
                UserRoleEnt userRole = userRoleRepository.findByRole(UserRoleEnum.USER)
                        .orElseThrow(() -> new IllegalStateException("USER role not found"));

                // Администратор
                UserEntity admin = new UserEntity();
                admin.setUsername("admin")
                        .setFullName("Admin")
                        .setEmail("admin@example.com")
                        .setPassword(passwordEncoder.encode("pako"))

                        .setRoles(Collections.singletonList(adminRole));
                userRepository.save(admin);

                // Нормален потребител
                UserEntity user = new UserEntity();
                user.setUsername("user")
                        .setFullName("User")
                        .setEmail("user@example.com")
                        .setPassword(passwordEncoder.encode("pako"))

                        .setRoles(Collections.singletonList(userRole));
                userRepository.save(user);
            }
        };
    }
//    @Bean
//    public CommandLineRunner init(UserService userService, PasswordEncoder passwordEncoder) {
//        return args -> {
//            if (userService.findByName("admin") == null) {
//                UserEntity admin = new UserEntity();
//                admin.setUsername("admin")
//                        .setFullName("Admin User")
//                        .setEmail("admin@example.com")
//                        .setPassword(passwordEncoder.encode("admin123"));
//                UserRoleEnt adminRole = new UserRoleEnt();
//                adminRole.setRole(UserRoleEnum.ADMIN);
//                admin.setRoles(Collections.singletonList(adminRole));
//                userService.registerUser(new RegisterDto("admin", "admin@example.com", "Admin User", "admin123", "admin123"), auth -> {});
//            }
//        };
//    }
}
