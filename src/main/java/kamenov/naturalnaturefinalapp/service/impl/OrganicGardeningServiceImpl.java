package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.entity.OrganicGardeningTip;
import kamenov.naturalnaturefinalapp.repositories.OrganicGardeningTipRepository;
import kamenov.naturalnaturefinalapp.service.OrganicGardeningService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganicGardeningServiceImpl implements OrganicGardeningService {
    private final OrganicGardeningTipRepository tipRepository;

    public OrganicGardeningServiceImpl(OrganicGardeningTipRepository tipRepository) {
        this.tipRepository = tipRepository;
    }

    @Override
    public List<OrganicGardeningTip> getAllTips() {
        return tipRepository.findAll().stream().toList();
    }

    @Override
    public OrganicGardeningTip saveTip(OrganicGardeningTip tip) {
        return tipRepository.save(tip);
    }
}
