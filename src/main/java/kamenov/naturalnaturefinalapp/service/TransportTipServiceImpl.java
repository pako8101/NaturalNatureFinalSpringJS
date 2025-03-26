package kamenov.naturalnaturefinalapp.service;

import jakarta.annotation.PostConstruct;
import kamenov.naturalnaturefinalapp.entity.TransportTip;
import kamenov.naturalnaturefinalapp.repositories.TransportTipRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportTipServiceImpl implements TransportTipService {
    private static final Logger logger = LoggerFactory.getLogger(TransportTipService.class);
    private final TransportTipRepository transportTipRepository;

    public TransportTipServiceImpl(TransportTipRepository transportTipRepository) {
        this.transportTipRepository = transportTipRepository;
    }


    @PostConstruct
    public void initTips() {
        if (transportTipRepository.count() == 0) {
            logger.info("Initializing transport tips...");
            transportTipRepository.save(new TransportTip(
                    "Plan Your Trips",
                    "Combine to reduce the number of car trips.",
                    "/images/plan-trips.jpg"
            ));
            transportTipRepository.save(new TransportTip(
                    "Use a Bike for Short Distances",
                    "Cycle to nearby places instead of driving.",
                    "/images/bike-short.jpg"
            ));
            transportTipRepository.save(new TransportTip(
                    "Carpool with Friends",
                    "Share rides to work or events to cut emissions.",
                    "/images/carpool.jpg"
            ));
            transportTipRepository.save(new TransportTip(
                    "Walk More Often",
                    "Choose walking for short distances to reduce emissions.",
                    "/images/walk-more.jpg"
            ));
            logger.info("Transport tips initialized successfully.");
        } else {
            logger.info("Transport tips already exist in the database: {} tips found.", transportTipRepository.count());
        }
    }
@Override
    public List<TransportTip> getAllTips() {
        List<TransportTip> tips = transportTipRepository.findAll();
        logger.info("Retrieved {} transport tips from the database.", tips.size());
        return tips;
    }
}
