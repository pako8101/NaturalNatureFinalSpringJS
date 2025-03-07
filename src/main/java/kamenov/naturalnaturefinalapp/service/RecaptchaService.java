package kamenov.naturalnaturefinalapp.service;

public interface RecaptchaService {
    boolean validateRecaptcha(String recaptchaToken);
}
