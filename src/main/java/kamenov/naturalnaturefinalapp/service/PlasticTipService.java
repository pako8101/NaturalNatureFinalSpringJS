package kamenov.naturalnaturefinalapp.service;

import jakarta.annotation.PostConstruct;
import kamenov.naturalnaturefinalapp.entity.PlasticTip;

import java.util.List;

public interface PlasticTipService {
    @PostConstruct
    void initTips();

    List<PlasticTip> getAllTips();
}
