package kamenov.naturalnaturefinalapp.service.impl;



import kamenov.naturalnaturefinalapp.entity.UserEntity;
import kamenov.naturalnaturefinalapp.entity.UserRoleEnt;
import kamenov.naturalnaturefinalapp.entity.dto.RegisterDto;
import kamenov.naturalnaturefinalapp.entity.enums.UserRoleEnum;
import kamenov.naturalnaturefinalapp.repositories.UserRepository;
import kamenov.naturalnaturefinalapp.repositories.UserRoleRepository;
import kamenov.naturalnaturefinalapp.service.UserService;
import kamenov.naturalnaturefinalapp.user.AppUserDetails;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository,
                           UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public UserEntity registerUser(RegisterDto userRegisterDto) {
        if (userRepository.findByUsername(userRegisterDto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.findByEmail(userRegisterDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        UserEntity user = modelMapper.map(userRegisterDto, UserEntity.class);
        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));

        user.setFullName(userRegisterDto.getFullName());
        user.setEmail(userRegisterDto.getEmail());
        user.setUsername(userRegisterDto.getUsername());

        // Добавяне на роля по подразбиране
        UserRoleEnt userRole = userRoleRepository.findByRole(UserRoleEnum.USER)
                .orElseThrow(() -> new IllegalStateException("USER role not found in database"));
        user.setRoles(Collections.singletonList(userRole));

        return userRepository.save(user);
    }
//    @Override
//    public UserEntity registerUser(RegisterDto userRegisterDto, Consumer<Authentication> successfulRegister) {
//        UserEntity user = modelMapper.map(userRegisterDto, UserEntity.class);
//        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
//        user.setFullName(userRegisterDto.getFullName())
//                .setEmail(userRegisterDto.getEmail())
//                .setUsername(userRegisterDto.getUsername());
//
//        // Добавяне на роля по подразбиране
//        UserRoleEnt userRole = userRoleRepository.findByRole(UserRoleEnum.USER)
//                .orElseThrow(() -> new IllegalStateException("USER role not found in database"));
//        user.setRoles(Collections.singletonList(userRole));
//
//        userRepository.save(user);
//
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            successfulRegister.accept(authentication);
//        }
//        return user;
//    }

    @Override
    public UserEntity findByName(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Optional<AppUserDetails> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof AppUserDetails appUserDetails) {
            return Optional.of(appUserDetails);
        }
        return Optional.empty();
    }
}

//package kamenov.naturalnaturefinalapp.service.impl;
//
//
//import jakarta.transaction.Transactional;
//import kamenov.naturalnaturefinalapp.entity.UserEntity;
//import kamenov.naturalnaturefinalapp.entity.UserRoleEnt;
//import kamenov.naturalnaturefinalapp.entity.dto.RegisterDto;
//import kamenov.naturalnaturefinalapp.entity.enums.UserRoleEnum;
//import kamenov.naturalnaturefinalapp.repositories.UserRepository;
//import kamenov.naturalnaturefinalapp.repositories.UserRoleRepository;
//import kamenov.naturalnaturefinalapp.service.UserService;
//import kamenov.naturalnaturefinalapp.user.AppUserDetails;
//import kamenov.naturalnaturefinalapp.user.LoggedUser;
//
//
//import org.modelmapper.ModelMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.webauthn.management.UserCredentialRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.Optional;
//import java.util.function.Consumer;
//
//@Service
//@Transactional
//public class UserServiceImpl implements UserService {
//    @Override
//    public UserEntity registerUser(RegisterDto userRegisterDto, Consumer<Authentication> successfulRegister) {
//        return null;
//    }
//
//    @Override
//    public UserEntity findByName(String username) {
//        return null;
//    }
//
//    @Override
//    public Optional<AppUserDetails> getCurrentUser() {
//        return Optional.empty();
//    }
//
//    @Override
//    public UserEntity findByEmail(String email) {
//        return null;
//    }
////
////    private final ModelMapper modelMapper;
////
////    //private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
////
//////    private final UserDetailsService userDetailsService;
////
////    private final UserRepository userRepository;
////private final UserService userService;
////
////    private final PasswordEncoder passwordEncoder;
////private final UserRoleRepository userRoleRepository;
////
////    public UserServiceImpl(ModelMapper modelMapper,
////                        //   UserDetailsService userDetailsService,
////                           UserRepository userRepository, UserService userService,
////                           PasswordEncoder passwordEncoder,
////                           UserRoleRepository userRoleRepository) {
////        this.modelMapper = modelMapper;
////
//////        this.userDetailsService = userDetailsService;
////        this.userRepository = userRepository;
////        this.userService = userService;
////        this.passwordEncoder = passwordEncoder;
////        this.userRoleRepository = userRoleRepository;
////    }
//////    @Override
//////    public UserEntity registerUser(UserEntity user) {
//////        // Криптиране на паролата
//////        user.setPassword(passwordEncoder.encode(user.getPassword()));
//////        user.setConfirmPassword(passwordEncoder.encode(user.getPassword()));
//////        return userRepository.save(user);
//////    }
////
////    @Override
////    @Transactional
////    public UserEntity registerUser(RegisterDto userRegisterDto, Consumer<Authentication> successfulRegister) {
////        UserEntity user = modelMapper.map(userRegisterDto, UserEntity.class);
////        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
////        user.setFullName(userRegisterDto.getFullName())
////                .setEmail(userRegisterDto.getEmail())
////                .setUsername(userRegisterDto.getUsername());
////
////        // Добавяне на роля по подразбиране
////        UserRoleEnt userRole = userRoleRepository.findByRole(UserRoleEnum.USER)
////                .orElseThrow(() -> new IllegalStateException("USER role not found in database"));
////        user.setRoles(Collections.singletonList(userRole));
////
////        userRepository.save(user);
////
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        if (authentication != null) {
////            successfulRegister.accept(authentication);
////        }
////        return user;
////    }
////
//////    @Override
//////    public UserEntity registerUser(RegisterDto userRegisterDto,
//////                                   Consumer<Authentication> successfulRegister) {
//////        UserEntity user = modelMapper.map(userRegisterDto, UserEntity.class);
//////        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));
//////        UserRoleEnt userRole = new UserRoleEnt();
//////        userRole.setRole(UserRoleEnum.USER);
//////        user.setRoles(Collections.singletonList(userRole));
//////         //user.getRoles().add(userService.findByName(String.valueOf(UserRoleEnum.USER)));
////////        if (userRegisterDto.getImage() == null || Objects.equals(userRegisterDto.getImage().getOriginalFilename(), "")) {
////////            user.setImage(profileImageService.getDefaultProfileImage());
////////
////////        }
////////        user.setImage(profileImageService.saveProfileImage(userRegisterDto.
////////                getImage(), user));
//////
//////
//////        user. setFullName(userRegisterDto.getFullName()).
//////                setEmail(userRegisterDto.getEmail()).
//////                setUsername(userRegisterDto.getUsername()).
//////                setPassword(passwordEncoder.encode(userRegisterDto.getPassword())
//////
//////                );
//////
//////        userRepository.save(user);
//////
//////        UserDetails userDetails =
//////                userDetailsService.loadUserByUsername(userRegisterDto.getUsername());
//////
//////        Authentication authentication = new UsernamePasswordAuthenticationToken(
//////                userDetails,
//////                userDetails.getPassword(),
//////                userDetails.getAuthorities()
//////        );
//////
//////        successfulRegister.accept(authentication);
//////        return user;
//////    }
////
//////    @Override
//////    public UserViewModel getUserProfile() {
//////        UserEntity user = loggedUser.get();
//////        return modelMapper.map(user,UserViewModel.class);
//////    }
//////
//////    @Override
//////    public UserViewModel findBId(Long id) {
//////        return userRepository.findById(id).
//////                map(user -> modelMapper.map(user,UserViewModel.class))
//////                .orElse(null);
////////        UserEntity user = loggedUser.get();
////////        user = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
////////        return modelMapper.map(user,UserViewModel.class);
//////    }
////
////    @Override
////    public UserEntity findByName(String username) {
////        return userRepository.findByUsername(username)
////                .orElse(null);
////    }
////
////    @Override
////    public Optional<AppUserDetails> getCurrentUser() {
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        if ( authentication != null &&
////                authentication.getPrincipal()
////                        instanceof AppUserDetails appUserDetails) {
////            return Optional.of(appUserDetails);
////        }
////
////        return Optional.empty();
////    }
////
////    @Override
////    public UserEntity findByEmail(String email) {
////        return userRepository.findByEmail(email)
////                .orElse(null);
////    }
//}
