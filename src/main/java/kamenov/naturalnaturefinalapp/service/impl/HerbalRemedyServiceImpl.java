package kamenov.naturalnaturefinalapp.service.impl;

import jakarta.annotation.PostConstruct;
import kamenov.naturalnaturefinalapp.entity.HerbalRemedy;
import kamenov.naturalnaturefinalapp.repositories.HerbalRemedyRepository;
import kamenov.naturalnaturefinalapp.service.HerbalRemedyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerbalRemedyServiceImpl implements HerbalRemedyService {

    private static final Logger logger = LoggerFactory.getLogger(HerbalRemedyService.class);
    private final HerbalRemedyRepository herbalRemedyRepository;

    @Autowired
    public HerbalRemedyServiceImpl(HerbalRemedyRepository herbalRemedyRepository) {
        this.herbalRemedyRepository = herbalRemedyRepository;
    }

    @PostConstruct
    public void initRemedies() {
        if (herbalRemedyRepository.count() == 0) {
            logger.info("Initializing herbal remedies...");
            herbalRemedyRepository.save(new HerbalRemedy(
                    "Chamomile Tea",
                    "A soothing herbal tea made from chamomile flowers.",
                    "/images/chamomile-tea.jpg",
                    "Reduces stress, promotes sleep, soothes stomach issues.",
                    "Steep 1-2 teaspoons of dried chamomile in hot water for 5-10 minutes."
            ));
            herbalRemedyRepository.save(new HerbalRemedy(
                    "Peppermint Oil",
                    "An essential oil extracted from peppermint leaves.",
                    "/images/peppermint-oil.jpg",
                    "Relieves headaches, improves digestion, reduces nausea.",
                    "Apply diluted oil to temples or inhale for relief."
            ));
            herbalRemedyRepository.save(new HerbalRemedy(
                    "Echinacea Tincture",
                    "A tincture made from the echinacea plant.",
                    "/images/echinacea-tincture.jpg",
                    "Boosts immune system, fights colds and infections.",
                    "Take 1-2 droppers full in water daily during cold season."
            ));
            herbalRemedyRepository.save(new HerbalRemedy(
                    "Lavender Salve",
                    "A healing salve made with lavender essential oil.",
                    "/images/lavender-salve.jpg",
                    "Soothes burns, heals skin irritations, promotes relaxation.",
                    "Apply a small amount to affected areas as needed."
            ));
            logger.info("Herbal remedies initialized successfully.");
        } else {
            logger.info("Herbal remedies already exist in the database: {} remedies found.", herbalRemedyRepository.count());
        }
    }
@Override
    public List<HerbalRemedy> getAllRemedies() {
        List<HerbalRemedy> remedies = herbalRemedyRepository.findAll();
        logger.info("Retrieved {} herbal remedies from the database.", remedies.size());
        return remedies;
    }


}
