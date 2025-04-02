package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.entity.ResponsibleFashion;
import kamenov.naturalnaturefinalapp.repositories.ResponsibleFashionRepository;
import kamenov.naturalnaturefinalapp.service.ResponsibleFashionService;




import kamenov.naturalnaturefinalapp.service.ResponsibleFashionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsibleFashionServiceImpl implements ResponsibleFashionService {

    private final ResponsibleFashionRepository responsibleFashionRepository;

    public ResponsibleFashionServiceImpl(ResponsibleFashionRepository responsibleFashionRepository) {
        this.responsibleFashionRepository = responsibleFashionRepository;
        System.out.println("ResponsibleFashionServiceImpl: Constructor called. Repository: " + responsibleFashionRepository);
    }

    @Override
    public List<ResponsibleFashion> getAllResponsibleFashions() {
        List<ResponsibleFashion> fashions = responsibleFashionRepository.findAll();
        System.out.println("ResponsibleFashionServiceImpl: All Responsible Fashions: " + fashions);
        return fashions;
    }

    @Override
    public List<ResponsibleFashion> getResponsibleFashionsByCategory(String category) {
        List<ResponsibleFashion> fashions = responsibleFashionRepository.findByCategory(category);
        System.out.println("ResponsibleFashionServiceImpl: Responsible Fashions for category " + category + ": " + fashions);
        return fashions;
    }

    @Override
    public void saveResponsibleFashion(ResponsibleFashion responsibleFashion) {
        System.out.println("ResponsibleFashionServiceImpl: Saving responsible fashion: " + responsibleFashion.getTitle());
        responsibleFashionRepository.save(responsibleFashion);
        System.out.println("ResponsibleFashionServiceImpl: Responsible Fashion saved. Total count: " + responsibleFashionRepository.count());
    }
    @Override
    public boolean existsByTitle(String title) {
        return responsibleFashionRepository.existsByTitle(title);
    }
}
