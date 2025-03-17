package kamenov.naturalnaturefinalapp.web;

import kamenov.naturalnaturefinalapp.entity.PremiumContent;
import kamenov.naturalnaturefinalapp.service.PremiumContentService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PremiumMembershipController {
    private final PremiumContentService contentService;

    public PremiumMembershipController(PremiumContentService contentService) {
        this.contentService = contentService;
    }

    @GetMapping("/premium-membership")
    @Transactional(readOnly = true)
    public String getPremiumMembershipPage(Model model) {
        if (contentService.getAllContent().isEmpty()) {
            PremiumContent video = new PremiumContent();
            video.setTitle("How to Start an Urban Organic Garden");
            video.setDescription("Learn the basics of organic gardening in small spaces with expert tips.");
            video.setType("video");
            video.setUrl("https://example.com/urban-garden-video");
            video.setThumbnailPath("/images/urban-garden-video.jpg");

            PremiumContent ebook = new PremiumContent();
            ebook.setTitle("Eco Travel Guide 2025");
            ebook.setDescription("Discover the top eco-friendly destinations with sustainable travel tips.");
            ebook.setType("ebook");
            ebook.setUrl("https://example.com/eco-travel-guide.pdf");
            ebook.setThumbnailPath("/images/eco-travel-guide.jpg");

            PremiumContent webinar = new PremiumContent();
            webinar.setTitle("Live Webinar: Sustainable Living 101");
            webinar.setDescription("Join our expert for a live session on reducing your carbon footprint.");
            webinar.setType("webinar");
            webinar.setUrl("https://example.com/webinar-sustainable-living");
            webinar.setThumbnailPath("/images/webinar.jpg");

            contentService.saveContent(video);
            contentService.saveContent(ebook);
            contentService.saveContent(webinar);
        }

        model.addAttribute("contents", contentService.getAllContent());
        return "premium-membership";
    }
}
