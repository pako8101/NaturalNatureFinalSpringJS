package kamenov.naturalnaturefinalapp.service;



import kamenov.naturalnaturefinalapp.entity.RecyclingCenter;

import java.util.List;

public interface RecyclingCenterService {
    List<RecyclingCenter> getCentersByCity(String city);

    List<RecyclingCenter> getAllCenters();
}
