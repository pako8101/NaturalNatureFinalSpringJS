package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.entity.WasteManagementTip;
import kamenov.naturalnaturefinalapp.service.WasteManagementService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WasteManagementServiceImpl implements WasteManagementService {



        private List<WasteManagementTip> tips;

    public WasteManagementServiceImpl() {
        this.tips = new ArrayList<>(); // Инициализираме списъка
        initializeTips(); // Попълваме с начални данни
    }

    // Метод за инициализация на примерни съвети
    private void initializeTips() {
        tips.add(new WasteManagementTip("Recycling", "Separate your waste into recyclable (plastic, paper, glass) and non-recyclable.", 5));
        tips.add(new WasteManagementTip("Composting", "Compost organic waste like food scraps and leaves in your backyard.", 4));
        tips.add(new WasteManagementTip("Reduce", "Use reusable bags instead of plastic ones to minimize waste.", 3));
        tips.add(new WasteManagementTip("Reuse", "Donate old clothes and items instead of throwing them away.", 4));
        tips.add(new WasteManagementTip("Hazardous Waste", "Check local programs for collecting batteries and electronics.", 5));
    }
@Override
        // Вземане на всички съвети, сортирани по приоритет
        public List<WasteManagementTip> getAllTips() {
            return tips.stream()
                    .sorted(Comparator.comparingInt(WasteManagementTip::getPriority).reversed())
                    .collect(Collectors.toList());
        }
@Override
// Вземане на съвети по категория
        public List<WasteManagementTip> getTipsByCategory(String category) {
            if (category == null || category.trim().isEmpty()) {
                throw new IllegalArgumentException("Category cannot be empty!");
            }
            return tips.stream()
                    .filter(tip -> tip.getCategory().equalsIgnoreCase(category))
                    .collect(Collectors.toList());
}

    @Override
    // Добавяне на нов съвет с валидации
        public void addTip(String category, String description, int priority) {
            // Валидации
            if (category == null || category.trim().isEmpty()) {
                throw new IllegalArgumentException("Category cannot be empty!");
            }
            if (description == null || description.trim().isEmpty()) {
                throw new IllegalArgumentException("Description cannot be empty!");
            }
            if (priority < 1 || priority > 5) {
                throw new IllegalArgumentException("Priority must be between 1 and 5!");
            }

            WasteManagementTip newTip = new WasteManagementTip(category, description, priority);
            tips.add(newTip);
    }
@Override
        // Вземане на уникалните категории
        public List<String> getCategories() {
            return tips.stream()
                    .map(WasteManagementTip::getCategory)
                    .distinct()
                    .collect(Collectors.toList());
        }
}
