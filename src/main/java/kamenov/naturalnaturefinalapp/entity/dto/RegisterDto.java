package kamenov.naturalnaturefinalapp.entity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import kamenov.naturalnaturefinalapp.validation.passwordMatcher.PasswordMatcher;
import kamenov.naturalnaturefinalapp.validation.uniqUsername.UniqueUsername;
import kamenov.naturalnaturefinalapp.validation.uniqueEmail.UniqueEmail;
import org.hibernate.validator.constraints.Length;

@PasswordMatcher(
        password = "password",
        confirmPassword = "confirmPassword"
)
public class RegisterDto {

    @NotBlank
    @UniqueUsername
    @Length(min = 3, max = 20, message = "The username must be between 3 and 20 characters")
    @NotBlank(message = "The field must not be empty")
    private String username;

    @Size(min = 2, max = 200)
    @NotBlank(message = "Name cannot be empty!")
    private String fullName;

    @NotBlank
    @UniqueEmail
    @Email(message = "Invalid email")
    @NotBlank(message = "The field must not be empty")
    private String email;

    @Length(min = 6, max = 20, message = "The password must be between 6 and 20 characters")
    @NotBlank(message = "The field must not be empty")
    private String password;
    @Length(min = 6, max = 20, message = "The password length must be between 6 and 20 characters")
    @NotBlank
    private String confirmPassword;


    public RegisterDto() {
    }

    public RegisterDto(String username, String fullName, String email, String password, String confirmPassword) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public @NotBlank @Length(min = 3, max = 20, message = "The username must be between 3 and 20 characters") @NotBlank(message = "The field must not be empty") String getUsername() {
        return username;
    }

    public RegisterDto setUsername(@NotBlank @Length(min = 3, max = 20, message = "The username must be between 3 and 20 characters") @NotBlank(message = "The field must not be empty") String username) {
        this.username = username;
        return this;
    }

    public @Size(min = 2, max = 200) @NotBlank(message = "Name cannot be empty!") String getFullName() {
        return fullName;
    }

    public RegisterDto setFullName(@Size(min = 2, max = 200) @NotBlank(message = "Name cannot be empty!") String fullName) {
        this.fullName = fullName;
        return this;
    }

    public @NotBlank @Email(message = "Invalid email") @NotBlank(message = "The field must not be empty") String getEmail() {
        return email;
    }

    public RegisterDto setEmail(@NotBlank @Email(message = "Invalid email") @NotBlank(message = "The field must not be empty") String email) {
        this.email = email;
        return this;
    }

    public @Length(min = 6, max = 20, message = "The password must be between 6 and 20 characters") @NotBlank(message = "The field must not be empty") String getPassword() {
        return password;
    }

    public RegisterDto setPassword(@Length(min = 6, max = 20, message = "The password must be between 6 and 20 characters") @NotBlank(message = "The field must not be empty") String password) {
        this.password = password;
        return this;
    }

    public @Length(min = 6, max = 20, message = "The password length must be between 6 and 20 characters") @NotBlank String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterDto setConfirmPassword(@Length(min = 6, max = 20, message = "The password length must be between 6 and 20 characters") @NotBlank String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

}
