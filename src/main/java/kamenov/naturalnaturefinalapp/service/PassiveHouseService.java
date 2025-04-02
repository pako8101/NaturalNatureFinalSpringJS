package kamenov.naturalnaturefinalapp.service;

import kamenov.naturalnaturefinalapp.entity.PassiveHouse;

import java.util.List;

public interface PassiveHouseService {
    List<PassiveHouse> getAllPassiveHouses();
    List<PassiveHouse> getPassiveHousesByCategory(String category);

    void savePassiveHouse(PassiveHouse passiveHouse);
    // void initPassiveHouses();
}
