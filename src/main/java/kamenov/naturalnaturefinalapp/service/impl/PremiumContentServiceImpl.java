package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.entity.PremiumContent;
import kamenov.naturalnaturefinalapp.repositories.PremiumContentRepository;
import kamenov.naturalnaturefinalapp.service.PremiumContentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PremiumContentServiceImpl implements PremiumContentService {

    private final PremiumContentRepository contentRepository;

    public PremiumContentServiceImpl(PremiumContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    @Override
    public List<PremiumContent> getAllContent() {
        return contentRepository.findAll();
    }

    @Override
    public PremiumContent saveContent(PremiumContent content) {
        return contentRepository.save(content);
    }
}
