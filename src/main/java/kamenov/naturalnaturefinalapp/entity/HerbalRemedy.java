package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HerbalRemedy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String imagePath;
    private String benefits;
    private String usageInstructions;

    public HerbalRemedy() {
    }

    public HerbalRemedy(String name, String description, String imagePath, String benefits, String usageInstructions) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.benefits = benefits;
        this.usageInstructions = usageInstructions;
    }

    public String getUsageInstructions() {
        return usageInstructions;
    }

    public HerbalRemedy setUsageInstructions(String usageInstructions) {
        this.usageInstructions = usageInstructions;
        return this;
    }

    public Long getId() {
        return id;
    }

    public HerbalRemedy setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public HerbalRemedy setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public HerbalRemedy setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public HerbalRemedy setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public String getBenefits() {
        return benefits;
    }

    public HerbalRemedy setBenefits(String benefits) {
        this.benefits = benefits;
        return this;
    }


}
