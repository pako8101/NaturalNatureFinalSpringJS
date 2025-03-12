package kamenov.naturalnaturefinalapp.entity;

// src/main/java/com/example/model/WasteManagementTip.java

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "waste_tips")
public class WasteManagementTip extends BaseEntity {
    @Column(name = "category",nullable = false,unique = true)
    private String category;
    @Column(columnDefinition = "TEXT")
    private String description;
    @NotBlank
    private int priority; // 1-5, колко важен е съветът

    public WasteManagementTip(String category, String description, int priority) {
        this.category = category;
        this.description = description;
        this.priority = priority;
    }

    public WasteManagementTip() {
    }

    // Гетъри и сетъри
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
