package kamenov.naturalnaturefinalapp.service;

import kamenov.naturalnaturefinalapp.entity.ResponsibleFashion;

import java.util.List;

public interface ResponsibleFashionService {
    List<ResponsibleFashion> getAllResponsibleFashions();
    List<ResponsibleFashion> getResponsibleFashionsByCategory(String category);
    void saveResponsibleFashion(ResponsibleFashion responsibleFashion);
    boolean existsByTitle(String title);

    void updateResponsibleFashion(ResponsibleFashion responsibleFashion);
}
