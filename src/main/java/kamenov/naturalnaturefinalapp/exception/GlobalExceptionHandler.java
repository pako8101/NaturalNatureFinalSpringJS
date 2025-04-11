package kamenov.naturalnaturefinalapp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.access.AccessDeniedException;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Обработва всички общи изключения
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, Model model) {
        logger.error("Unexpected error occurred: {}", ex.getMessage(), ex);
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject("errorMessage", "Oops! An unexpected error occurred. Please try again later.");
        mav.addObject("requestUri", "Unknown");
        return mav;
    }

    // Обработва NullPointerException
    @ExceptionHandler(NullPointerException.class)
    public ModelAndView handleNullPointerException(NullPointerException ex, Model model) {
        logger.error("NullPointerException occurred: {}", ex.getMessage(), ex);
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        mav.addObject("errorMessage", "A null pointer error occurred. Our team has been notified.");
        mav.addObject("requestUri", "Unknown");
        return mav;
    }

    // Обработва IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleIllegalArgumentException(IllegalArgumentException ex, Model model) {
        logger.error("IllegalArgumentException occurred: {}", ex.getMessage(), ex);
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("statusCode", HttpStatus.BAD_REQUEST.value());
        mav.addObject("errorMessage", "Invalid input: " + ex.getMessage());
        mav.addObject("requestUri", "Unknown");
        return mav;
    }

    // Обработва AccessDeniedException (403)
    @ExceptionHandler(AccessDeniedException.class)
    public ModelAndView handleAccessDeniedException(AccessDeniedException ex, Model model) {
        logger.warn("AccessDeniedException occurred: {}", ex.getMessage(), ex);
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("statusCode", HttpStatus.FORBIDDEN.value());
        mav.addObject("errorMessage", "Access Denied: You do not have permission to access this resource.");
        mav.addObject("requestUri", "Unknown");
        return mav;
    }

    // Обработва MethodArgumentNotValidException (400 - невалидни аргументи при валидация)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, Model model) {
        logger.error("MethodArgumentNotValidException occurred: {}", ex.getMessage(), ex);
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        StringBuilder errorMessage = new StringBuilder("Validation failed: ");
        for (FieldError error : fieldErrors) {
            errorMessage.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append("; ");
        }
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("statusCode", HttpStatus.BAD_REQUEST.value());
        mav.addObject("errorMessage", errorMessage.toString());
        mav.addObject("requestUri", "Unknown");
        return mav;
    }

    // Обработва HttpRequestMethodNotSupportedException (405 - неподдържан HTTP метод)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ModelAndView handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, Model model) {
        logger.error("HttpRequestMethodNotSupportedException occurred: {}", ex.getMessage(), ex);
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("statusCode", HttpStatus.METHOD_NOT_ALLOWED.value());
        mav.addObject("errorMessage", "Method Not Allowed: The request method " + ex.getMethod() + " is not supported for this resource.");
        mav.addObject("requestUri", "Unknown");
        return mav;
    }

    // Обработва DataIntegrityViolationException (409 - конфликт, често при база данни)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView handleDataIntegrityViolationException(DataIntegrityViolationException ex, Model model) {
        logger.error("DataIntegrityViolationException occurred: {}", ex.getMessage(), ex);
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("statusCode", HttpStatus.CONFLICT.value());
        mav.addObject("errorMessage", "Data Conflict: There was a conflict while processing your request. Please try again.");
        mav.addObject("requestUri", "Unknown");
        return mav;
    }
}