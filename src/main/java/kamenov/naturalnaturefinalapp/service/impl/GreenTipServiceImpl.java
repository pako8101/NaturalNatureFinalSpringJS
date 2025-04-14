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
    private static final Logger logger = LoggerFactory.getLogger(GreenTipService.class);
    private final GreenTipRepository greenTipRepository;

    @Autowired
    public GreenTipServiceImpl(GreenTipRepository greenTipRepository) {
        this.greenTipRepository = greenTipRepository;
    }
@Override
    @PostConstruct
    public void initTips() {
        if (greenTipRepository.count() == 0) {
            logger.info("Initializing green tips...");
            greenTipRepository.save(new GreenTip(
                    "Use Reusable Containers",
                    "Store food in glass or stainless steel containers instead of plastic ones.",
                    "/images/greentips/reusable-container.jpg"
            ));
            greenTipRepository.save(new GreenTip(
                    "Switch to Bar Soap",
                    "Replace liquid soap in plastic bottles with bar soap to reduce waste.",
                    "/images/greentips/bar-soap.jpg"
            ));
            greenTipRepository.save(new GreenTip(
                    "Avoid Plastic Wrap",
                    "Use beeswax wraps or silicone lids to cover food instead of plastic wrap.",
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
