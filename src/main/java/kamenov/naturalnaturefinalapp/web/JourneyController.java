package kamenov.naturalnaturefinalapp.web;

import jakarta.transaction.Transactional;
import kamenov.naturalnaturefinalapp.entity.Journey;

import kamenov.naturalnaturefinalapp.entity.Section;
import kamenov.naturalnaturefinalapp.service.JourneyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JourneyController {

    private final JourneyService journeyService;

    public JourneyController(JourneyService journeyService) {
        this.journeyService = journeyService;
    }

//    @GetMapping("/journey")
//    public String getJourneyPage(Model model) {
//        // Добавяне на примерни данни (може да бъде заменено с форма за въвеждане)
//        Journey journey = new Journey();
//        journey.setTitle("Explore the Prehistoric Journey");
//        journey.setDescription("Travel back in time with eco-friendly adventures.");
//
//        // Eco-Friendly Destinations с подсекции
//       Section ecoFriendlyDestinations = new Section("Eco-Friendly Destinations",
//                "Visit pristine beaches and forests preserved for nature.", "/images/ocean-view.jpg");
//        ecoFriendlyDestinations.addSubsection(new Section.Subsection("Eco-Friendly Accommodations",
//                "Stay in sustainable lodges and eco-hotels.", "/images/eco-lodge.jpg"));
//        ecoFriendlyDestinations.addSubsection(new Section.Subsection("National Parks and Reserves",
//                "Explore protected areas with rich biodiversity.", "/images/national-park.jpg"));
//        journey.addSection(ecoFriendlyDestinations);
//
//        // Останалите секции
//        journey.addSection(new Section("Low-Impact Travel",
//                "Travel with minimal ecological footprint using sustainable methods.", "/images/mountain-trail.jpg"));
//        journey.addSection(new Section("Responsible Travel",
//                "Support local communities and protect wildlife on your journey.", "/images/forest-view.jpg"));
//
//        journeyService.saveJourney(journey);
//
//        model.addAttribute("journey", journeyService.getAllJourneys().get(0));
//        return "journey";
//    }
//    @GetMapping("/journey/{sectionId}/{index}")
//    public String getSubsectionDetail(@PathVariable Long sectionId, @PathVariable int index, Model model) {
//        Journey journey = journeyService.getAllJourneys().get(0);
//        Section section = journey.getSections().stream().filter(s -> s.getId().equals(sectionId)).findFirst().orElse(null);
//        if (section != null && index >= 0 && index < section.getSubsections().size()) {
//            model.addAttribute("subsection", section.getSubsections().get(index));
//        }
//        return "subsection-detail"; // Създай нов шаблон, наречен subsection-detail.html
//    }
@GetMapping("/journey")
@Transactional()
public String getJourneyPage(Model model) {
    // Проверка дали има съществуващо Journey
    Journey journey;
    if (journeyService.getAllJourneys().isEmpty()) {
        journey = new Journey();
        journey.setTitle("Embracing Sustainable Living and Sustainable Travel in National Parks");
        journey.setDescription("Travel back in time with eco-friendly adventures.");

        Section ecoFriendlyDestinations = new Section();
        ecoFriendlyDestinations.setId(1L); // Примерен ID
        ecoFriendlyDestinations.setName("Eco-Friendly Destinations");
        ecoFriendlyDestinations.setContent("Discover destinations that prioritize nature conservation.");
        ecoFriendlyDestinations.setImagePath("/images/ocean-view.jpg");

        Section lowImpactTravel = new Section();
        lowImpactTravel.setId(2L); // Примерен ID
        lowImpactTravel.setName("Low-Impact Travel");
        lowImpactTravel.setContent("Explore with minimal ecological footprint.");
        lowImpactTravel.setImagePath("/images/mountain-trail.jpg");

        Section responsibleTravel = new Section();
        responsibleTravel.setId(3L); // Примерен ID
        responsibleTravel.setName("Responsible Travel");
        responsibleTravel.setContent("Support local communities and wildlife.");
        responsibleTravel.setImagePath("/images/forest-view.jpg");

        journey.addSection(ecoFriendlyDestinations);
        journey.addSection(lowImpactTravel);
        journey.addSection(responsibleTravel);

        journeyService.saveJourney(journey); // Запазваме само ако е ново
    } else {
        journey = journeyService.getAllJourneys().get(0);
    }

    model.addAttribute("section", journey.getSections().get(0)); // По подразбиране
    model.addAttribute("journey", journey);
    return "journey";
}

    @GetMapping("/journey/{sectionId}")
    @Transactional()
    public String getSectionPage(@PathVariable Long sectionId, Model model) {
        Journey journey = journeyService.getAllJourneys().get(0);
        Section section = journey.getSections().stream()
                .filter(s -> s.getId().equals(sectionId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Section not found"));

        model.addAttribute("section", section);
        model.addAttribute("journey", journey);
        return "journey";
    }

    @GetMapping("/eco-accommodations")
    @Transactional
    public String getEcoAccommodationsPage(Model model) {

        model.addAttribute("pageTitle", "Eco-Friendly Accommodations");
        model.addAttribute("content", "Discover sustainable stays that blend luxury with nature. Imagine eco-lodges nestled along pristine coastlines, built with recycled materials, and powered by solar energy. These accommodations offer breathtaking ocean views, organic dining, and guided tours to local marine reserves, all while minimizing your carbon footprint. Perfect for travelers seeking a guilt-free escape with the sound of waves as your lullaby.");
        model.addAttribute("imagePath", "/images/eco-lodge.jpg");
        model.addAttribute("journey", journeyService.getAllJourneys());
        return "eco-accommodations";
    }

//    @GetMapping("/national-parks")
//    @Transactional()
//    public String getNationalParksPage(Model model) {
//
//
//        model.addAttribute("pageTitle", "The Key Role of National Parks and Reserves");
//        model.addAttribute("content", "Our planet’s national parks and reserves are like the heartbeats of nature, " +
//                "essential for keeping our environment healthy. They act as safe havens for a wide variety of plants and animals," +
//                " protecting endangered species from dangers like habitat loss and poaching.\n" +
//                "\n" +
//                "These special places also help to shield wildlife from human activities," +
//                " giving them space to live freely without interference from cities or industries.\n" +
//                "When you step into a national park, it feels like traveling back in time to an ancient world untouched by modern life.\n" +
//                "\n" +
//                "Here, old forests share stories of their strength, clear streams hold mysteries untold," +
//                " and powerful predators move through their habitats with grace. " +
//                "The sights, sounds, and smells all around you awaken a primal connection to nature that reminds us we are just visitors " +
//                "in this vast web of life.\n" +
//                "\n" +
//                "By supporting eco-friendly practices such as proper waste disposal and using sustainable transportation options within these " +
//                "protected areas, we can ensure that future generations inherit thriving ecosystems full of diverse plant and animal life. " +
//                "Every choice we make—like switching to reusable water bottles instead of " +
//                "disposable ones or sticking to marked trails to avoid damaging the soil—has a positive impact on these delicate environments."+
//                "\n");
//
//        model.addAttribute("imagePath", "/images/national-park.jpg");
//        model.addAttribute("journey", journeyService.getAllJourneys());
//
//
//        return "national-parks";
//    }
    @GetMapping("/national-parks")
    public String showNationalParks(Model model) {
        model.addAttribute("pageTitle", "National Parks and Reserves: Guardians of Nature");
        return "national-parks";
    }

    @GetMapping("/article-parks")
    public String showArticle(@RequestParam("id") Long id, Model model) {
        model.addAttribute("articleId", id);
        return "article-national";
    }

}