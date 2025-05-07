package kamenov.naturalnaturefinalapp.service.impl;

import jakarta.annotation.PostConstruct;
import kamenov.naturalnaturefinalapp.entity.GreenTip;
import kamenov.naturalnaturefinalapp.repositories.GreenTipRepository;
import kamenov.naturalnaturefinalapp.service.GreenTipService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreenTipServiceImpl implements GreenTipService {
    private static final Logger logger = LoggerFactory.getLogger(GreenTipServiceImpl.class);
    private final GreenTipRepository greenTipRepository;

    @Autowired
    public GreenTipServiceImpl(GreenTipRepository greenTipRepository) {
        this.greenTipRepository = greenTipRepository;
    }
@Override
    @PostConstruct
    public void initTips() {
    greenTipRepository.deleteAll();
        if (greenTipRepository.count() == 0) {
            logger.info("Initializing green tips...");
            greenTipRepository.save(new GreenTip(
                    "Use Reusable Containers",
                    "Store food in glass or stainless steel containers instead of plastic ones." +
                            "Using reusable containers is one of the simplest and most impactful ways to reduce everyday waste." +
                            " Instead of relying on single-use plastic boxes, switching to glass or stainless steel containers offers a safer," +
                            " more sustainable alternative. These containers are durable, don't leach harmful chemicals, and help keep food fresh for longer." +
                            " They’re perfect for meal prep, leftovers, or carrying lunch to work or school. " +
                            "By reusing containers, we reduce the need for constant packaging production and decrease greenhouse gas emissions. " +
                            "Modern designs make them lightweight, microwave- and dishwasher-safe, and easy to carry. " +
                            "Over time, this switch saves money and supports a zero-waste lifestyle. Choosing reusable options sends a strong message about caring for our planet. You can even get stylish or stackable versions to better organize your fridge or pantry. Pairing reusable containers with cloth bags and metal cutlery creates a fully eco-friendly eating experience. This small lifestyle change can lead to significant environmental benefits. Teaching children to use fun, colorful containers also helps build sustainable habits early. Every container reused is one less piece of plastic polluting nature." +
                            " Embrace reusability – it’s good for your health, your wallet, and the Earth.",
                    "/images/greentips/reusable-container.jpg"
            ));
            greenTipRepository.save(new GreenTip(
                    "Switch to Bar Soap",
                    "Replace liquid soap in plastic bottles with bar soap to reduce waste." +
                            "Switching to bar soap is a small yet powerful move toward reducing plastic waste." +
                            " Liquid soap often comes in bulky plastic bottles, many of which are not recycled properly. " +
                            "In contrast, bar soap can be purchased with zero or minimal packaging. " +
                            "It typically lasts longer than liquid soap and uses fewer ingredients and resources to produce." +
                            " Many bar soaps are made with natural, skin-friendly ingredients like essential oils, herbs, or shea butter. " +
                            "You can find a variety of options to suit every skin type and scent preference. " +
                            "Bar soaps are also great for travel—no liquid restrictions and no risk of spills. " +
                            "Nowadays, even shampoo and conditioner come in solid bar forms. " +
                            "This change reduces clutter in your bathroom and your environmental footprint. By choosing bars over bottles, " +
                            "you directly cut down on plastic waste in landfills and oceans. It's a cost-effective, " +
                            "practical step with real ecological benefits. Many eco-conscious brands also offer refillable tins or compostable wrappers. " +
                            "Even small changes like this help normalize sustainability in daily routines. " +
                            "Switching to bar soap isn't just a trend—it's a smarter, cleaner way forward.",
                    "/images/greentips/bar-soap.jpg"
            ));
            greenTipRepository.save(new GreenTip(
                    "Avoid Plastic Wrap",
                    "Use beeswax wraps or silicone lids to cover food instead of plastic wrap." +
                            "Plastic wrap is convenient, but it's one of the most wasteful and non-recyclable kitchen products." +
                            " Every day, millions of households use it once and throw it away—adding to the global plastic crisis. " +
                            "Fortunately, there are much better alternatives. Beeswax wraps, made from organic cotton and beeswax, " +
                            "can be reused dozens of times and molded around food or containers. Silicone stretch lids are flexible, " +
                            "durable, and fit snugly over bowls, jars, or even cut fruits. " +
                            "Glass containers with lids offer the easiest and most effective food storage method without plastic. " +
                            "Avoiding plastic wrap helps protect your health by reducing exposure to microplastics in food." +
                            " It also prevents pollution in rivers, oceans, and ecosystems." +
                            " Reusable options are often more cost-effective over time and can be cleaned with just warm water and soap. " +
                            "Adopting plastic-free habits encourages others and contributes to a broader culture of sustainability. " +
                            "Even small changes in your kitchen can lead to a more conscious and responsible lifestyle. " +
                            "Making your kitchen zero-waste is easier than ever with so many stylish and functional alternatives. " +
                            "Choose wisely—your future self and the planet will thank you.",
                    "/images/greentips/beeswax-wrap.jpg"
            ));
            logger.info("Green tips initialized successfully.");
        } else {
            logger.info("Green tips already exist in the database: {} tips found.", greenTipRepository.count());
        }
    }
@Override
    public List<GreenTip> getAllTips() {
        List<GreenTip> tips = greenTipRepository.findAll();
        logger.info("Retrieved {} green tips from the database.", tips.size());
        return tips;
    }
}
