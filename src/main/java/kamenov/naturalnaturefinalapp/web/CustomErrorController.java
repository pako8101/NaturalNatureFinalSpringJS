package kamenov.naturalnaturefinalapp.web;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        // Взимаме статус кода на грешката
        Integer statusCode = (Integer) request.getAttribute("jakarta.servlet.error.status_code");
        String errorMessage = (String) request.getAttribute("jakarta.servlet.error.message");
        String requestUri = (String) request.getAttribute("jakarta.servlet.error.request_uri");

        // Ако няма съобщение за грешка, задаваме персонализирано съобщение според статус кода
        if (errorMessage == null || errorMessage.isEmpty()) {
            errorMessage = switch (statusCode != null ? statusCode : 500) {
                case 400 -> "Bad Request: The server cannot process the request due to a client error.";
                case 401 -> "Unauthorized: Authentication is required to access this resource.";
                case 403 -> "Forbidden: You don't have permission to access this resource.";
                case 404 -> "Not Found: The requested resource could not be found on the server.";
                case 405 -> "Method Not Allowed: The request method is not supported for this resource.";
                case 429 -> "Too Many Requests: You have exceeded the rate limit. Please try again later.";
                case 500 -> "Internal Server Error: Something went wrong on the server.";
                default -> "An unexpected error occurred.";
            };
        }

        // Добавяме информация за грешката в модела
        model.addAttribute("statusCode", statusCode != null ? statusCode : "Unknown");
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("requestUri", requestUri != null ? requestUri : "Unknown");

        return "error";
    }
}
