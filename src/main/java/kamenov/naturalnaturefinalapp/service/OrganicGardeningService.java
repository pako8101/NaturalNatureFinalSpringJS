package kamenov.naturalnaturefinalapp.service;

import kamenov.naturalnaturefinalapp.entity.OrganicGardeningTip;

import java.util.List;

public interface OrganicGardeningService {
    List<OrganicGardeningTip> getAllTips();

    OrganicGardeningTip saveTip(OrganicGardeningTip tip);


}
