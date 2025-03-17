package kamenov.naturalnaturefinalapp.service;

import kamenov.naturalnaturefinalapp.entity.Journey;

import java.util.List;

public interface JourneyService {
    List<Journey> getAllJourneys();

    Journey saveJourney(Journey journey);
}
