package kamenov.naturalnaturefinalapp.service;

import jakarta.annotation.PostConstruct;
import kamenov.naturalnaturefinalapp.entity.GreenTip;

import java.util.List;

public interface GreenTipService {
    @PostConstruct
    void initTips();

    List<GreenTip> getAllTips();
}
