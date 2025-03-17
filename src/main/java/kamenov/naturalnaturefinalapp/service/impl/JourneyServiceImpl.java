package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.entity.Journey;
import kamenov.naturalnaturefinalapp.repositories.JourneyRepository;
import kamenov.naturalnaturefinalapp.service.JourneyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JourneyServiceImpl implements JourneyService {
    private final JourneyRepository journeyRepository;



    public JourneyServiceImpl(JourneyRepository journeyRepository) {
        this.journeyRepository = journeyRepository;
    }
@Override
    public List<Journey> getAllJourneys() {
        return journeyRepository.findAll();
    }
@Override
    public Journey saveJourney(Journey journey) {
        return journeyRepository.save(journey);
    }
}
