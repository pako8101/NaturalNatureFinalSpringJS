package kamenov.naturalnaturefinalapp.web;



import kamenov.naturalnaturefinalapp.entity.ContactMessage;
import kamenov.naturalnaturefinalapp.repositories.ContactMessageRepository;
import kamenov.naturalnaturefinalapp.service.VisitorReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {

    private final ContactMessageRepository contactMessageRepository;

    private final VisitorReportService visitorReportService;
    @Autowired
    public ContactController(ContactMessageRepository contactMessageRepository, VisitorReportService visitorReportService) {
        this.contactMessageRepository = contactMessageRepository;
        this.visitorReportService = visitorReportService;
    }

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        model.addAttribute("contactMessage", new ContactMessage());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@ModelAttribute ContactMessage contactMessage, Model model) {
        contactMessageRepository.save(contactMessage);
        visitorReportService.sendContactMessageNotification(contactMessage);
        model.addAttribute("successMessage", "Thank you for your message! We'll get back to you soon.");
        return "contact";
    }
}
