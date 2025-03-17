package kamenov.naturalnaturefinalapp.service;

import kamenov.naturalnaturefinalapp.entity.PremiumContent;

import java.util.List;

public interface PremiumContentService {
    List<PremiumContent> getAllContent();

    PremiumContent saveContent(PremiumContent content);
}
