package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "plastic_tips")
public class PlasticTip extends BaseEntity{
    @Column(name = "title",nullable = false,unique = true)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_path",nullable = false)
    private String imagePath;

    public PlasticTip() {
    }

    public PlasticTip(String title, String description, String imagePath) {
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public PlasticTip setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PlasticTip setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public PlasticTip setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }
}
