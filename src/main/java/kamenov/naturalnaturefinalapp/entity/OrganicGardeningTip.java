package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "gardening_tips")
public class OrganicGardeningTip extends BaseEntity{
    private String title;
    private String description;
    private String imagePath;

    public OrganicGardeningTip() {
    }

    public String getTitle() {
        return title;
    }

    public OrganicGardeningTip setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrganicGardeningTip setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public OrganicGardeningTip setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }
}
