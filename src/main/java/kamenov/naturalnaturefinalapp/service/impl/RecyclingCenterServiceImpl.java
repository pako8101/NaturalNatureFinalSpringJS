package kamenov.naturalnaturefinalapp.service.impl;


import kamenov.naturalnaturefinalapp.entity.RecyclingCenter;
import kamenov.naturalnaturefinalapp.repositories.RecyclingCenterRepository;
import kamenov.naturalnaturefinalapp.service.RecyclingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingCenterServiceImpl implements RecyclingCenterService {

    private final RecyclingCenterRepository repository;
    @Autowired
    public RecyclingCenterServiceImpl(RecyclingCenterRepository repository) {
        this.repository = repository;
    }
@Override
    public List<RecyclingCenter> getCentersByCity(String city) {
        return repository.findByCity(city);
    }

    @Override
    public List<RecyclingCenter> getAllCenters() {
        return repository.findAll();
    }
}
