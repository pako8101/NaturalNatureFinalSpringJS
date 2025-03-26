package kamenov.naturalnaturefinalapp.service.impl;

import jakarta.annotation.PostConstruct;
import kamenov.naturalnaturefinalapp.entity.PlasticTip;
import kamenov.naturalnaturefinalapp.repositories.PlasticTipRepository;
import kamenov.naturalnaturefinalapp.service.PlasticTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlasticTipServiceImpl implements PlasticTipService {
private final PlasticTipRepository plasticTipRepository;
    @Autowired
    public PlasticTipServiceImpl(PlasticTipRepository plasticTipRepository) {
        this.plasticTipRepository = plasticTipRepository;
    }


@Override
    @PostConstruct
    public void initTips() {
        if (plasticTipRepository.count() == 0) {
            plasticTipRepository.save(new PlasticTip(
                    "Use Reusable Bags",
                    "Switch to reusable bags instead of plastic ones to reduce waste.",
                    "/resources/static/images/reusable-bag.jpeg"
            ));
            plasticTipRepository.save(new PlasticTip(
                    "Choose Metal Straws",
                    "Replace plastic straws with metal or bamboo alternatives.",
                    "images/metal-straw.jpeg"
            ));
            plasticTipRepository.save(new PlasticTip(
                    "Buy in Bulk",
                    "Purchase items in bulk to minimize plastic packaging.",
                    "/images/bulk-shopping.jpg"
            ));
        }
    }
@Override
    public List<PlasticTip> getAllTips() {
        return plasticTipRepository.findAll();
    }
}
