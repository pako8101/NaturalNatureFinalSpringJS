package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "herbal_remedy")
public class HerbalRemedy extends BaseEntity{
    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String description;

    @Column(name = "image_path",nullable = false)
    private String imagePath;
    @Column(name = "benefits",nullable = false)
    private String benefits;
    @Column(name = "usage",nullable = false)
    private String usage;

    public HerbalRemedy() {
    }

    public HerbalRemedy(String name, String description, String imagePath, String benefits, String usage) {
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.benefits = benefits;
        this.usage = usage;
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

    public String getUsage() {
        return usage;
    }

    public HerbalRemedy setUsage(String usage) {
        this.usage = usage;
        return this;
    }
}
