package kamenov.naturalnaturefinalapp.web;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

import kamenov.naturalnaturefinalapp.entity.UserEntity;
import kamenov.naturalnaturefinalapp.entity.dto.LoginDto;
import kamenov.naturalnaturefinalapp.entity.dto.RegisterDto;
import kamenov.naturalnaturefinalapp.repositories.UserRepository;
import kamenov.naturalnaturefinalapp.service.JwtService;
import kamenov.naturalnaturefinalapp.service.RecaptchaService;
import kamenov.naturalnaturefinalapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/user")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserRepository userRepository;
    private final SecurityContextRepository securityContextRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final RecaptchaService recaptchaService;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;
    @Value("${site_key}")
    private String recaptchaSiteKey;

    public AuthController(AuthenticationManager authenticationManager,
                          UserService userService, UserRepository userRepository, SecurityContextRepository securityContextRepository, RecaptchaService recaptchaService, ModelMapper modelMapper, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.userRepository = userRepository;
        this.securityContextRepository = securityContextRepository;
        this.recaptchaService = recaptchaService;
        this.modelMapper = modelMapper;
        this.jwtService = jwtService;
    }




        @GetMapping("/register")
        public String showRegistrationForm(Model model) {
        if(!model.containsAttribute("user")) {
            model.addAttribute("user", new RegisterDto());
        }
            model.addAttribute("recaptchaSiteKey", recaptchaSiteKey);
            return "register";
        }

        @PostMapping("/register")
        public String registerUser(@Valid @ModelAttribute("user") @RequestBody RegisterDto userRegisterDto,
                                   BindingResult bindingResult,
                                   HttpServletRequest request,
                                   HttpServletResponse response,
                                   RedirectAttributes redirectAttributes,
                                   @ModelAttribute("g-recaptcha-response") String recaptchaResponse,
                                   Model model) {
//            if (bindingResult.hasErrors()) {
//                return "register";
//            }
            if (bindingResult.hasErrors() || !userRegisterDto.getPassword()
                    .equals(userRegisterDto.getConfirmPassword())) {
                redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
                redirectAttributes.addFlashAttribute(
                        "org.springframework.validation.BindingResult.userRegisterDto", bindingResult);
                return "redirect:/user/register";
            }
            if (userService.findByName(userRegisterDto.getUsername()) != null) {
                model.addAttribute("error", "Username already exists");
                return "register";
            }
            if (userService.findByEmail(userRegisterDto.getEmail()) != null) {
                model.addAttribute("error", "Email already exists");
                return "register";
            }
            if (!recaptchaService.validateRecaptcha(recaptchaResponse)) {
                model.addAttribute("error", "Invalid reCAPTCHA");
                return "register";
            }
            UserEntity user =
                    userService.registerUser(userRegisterDto, successfulAuth -> {
                        SecurityContextHolderStrategy strategy = SecurityContextHolder.getContextHolderStrategy();

                        SecurityContext context = strategy.createEmptyContext();
                        context.setAuthentication(successfulAuth);

                        strategy.setContext(context);
                        securityContextRepository.saveContext(context, request, response);

                    });
            Cookie cookie = new Cookie("jwt", jwtService.generateToken(user));
            cookie.setPath("/");
            cookie.setMaxAge(60 * 60 * 24);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            String token = jwtService.generateToken(user);
//            userService.registerUser(userRegisterDto);
            return "redirect:/login?registered=true";
        }

        @GetMapping("/login")
        public String showLoginForm(Model model) {
            model.addAttribute("user", new LoginDto());
            return "login";
        }
//    @PostMapping("/login")
//    public String loginUser(@ModelAttribute("user") LoginDto user,
//                            @RequestParam("g-recaptcha-response") String recaptchaResponse,
//                            HttpServletRequest request,
//                            HttpServletResponse response,
//                            Model model) {
//        // Проверка на reCAPTCHA
//        if (!recaptchaService.validateRecaptcha(recaptchaResponse)) {
//            model.addAttribute("error", "Invalid reCAPTCHA");
//            return "login";
//        }
//
//        try {
//            // Аутентикация
//            Authentication auth = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
//            );
//            SecurityContextHolder.getContext().setAuthentication(auth);
//            securityContextRepository.saveContext(SecurityContextHolder.getContext(), request, response);
//
//            // Генериране на JWT токен
//            UserEntity userEntity = userService.findByName(user.getUsername().toString());
//            String token = jwtService.generateToken(userEntity);
//            Cookie cookie = new Cookie("jwt", token);
//            cookie.setPath("/");
//            cookie.setMaxAge(60 * 60 * 24);
//            cookie.setHttpOnly(true);
//            response.addCookie(cookie);
//
//            return "redirect:/green-cooking";
//        } catch (Exception e) {
//            logger.error("Login failed for user: " + user.getUsername(), e);
//            model.addAttribute("error", "Invalid username or password");
//            return "login";
//        }
//    }

        @PostMapping("/login")
        public String loginUser(@ModelAttribute("user") LoginDto user,
                                @ModelAttribute("g-recaptcha-response") String recaptchaResponse,
                                Model model) {
            if (!recaptchaService.validateRecaptcha(recaptchaResponse)) {
                model.addAttribute("error", "Invalid reCAPTCHA");
                return "login";
            }
            try {
                Authentication auth = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
                );
                SecurityContextHolder.getContext().setAuthentication(auth);
                return "redirect:/";
            } catch (Exception e) {
                model.addAttribute("error", "Invalid username or password");
                return "login";
            }
        }

        @GetMapping("/logout")
        public String logout() {
            SecurityContextHolder.clearContext();
            return "redirect:/login?logout=true";
        }


//    @PostMapping("/login-error")
//    public String onFailedLogin(@ModelAttribute(UsernamePasswordAuthenticationFilter
//            .SPRING_SECURITY_FORM_USERNAME_KEY) String username,
//                                RedirectAttributes redirectAttributes) {
//
//        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
//        redirectAttributes.addFlashAttribute("bad_credentials", true);
//
//
////        redirectAttributes.addFlashAttribute("username", username);
//        return "redirect:/user/login";
//        if (userServiceModel == null) {
//            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel());
//            redirectAttributes.addFlashAttribute("isFound", false);
//            return "redirect:login";
//        }

  //  }


}
