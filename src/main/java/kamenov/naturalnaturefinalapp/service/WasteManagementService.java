package kamenov.naturalnaturefinalapp.service;

import kamenov.naturalnaturefinalapp.entity.WasteManagementTip;

import java.util.List;

public interface WasteManagementService {


    // Вземане на всички съвети, сортирани по приоритет
    List<WasteManagementTip> getAllTips();

    // Вземане на съвети по категория
    List<WasteManagementTip> getTipsByCategory(String category);

    // Добавяне на нов съвет с валидации
    void addTip(String category, String description, int priority);

    // Вземане на уникалните категории
    List<String> getCategories();
}
