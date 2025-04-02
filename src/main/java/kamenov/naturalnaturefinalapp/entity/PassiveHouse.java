package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "passive_houses")
public class PassiveHouse extends BaseEntity{
    @Column(name = "title",nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url",nullable = false)
    private String imageUrl;
    @Column()
    private String category; // Категория (Energy Efficiency, Solar Power Systems и т.н.)
    @Column(name = "video_url")
    private String videoUrl;

    public PassiveHouse() {
    }

    public PassiveHouse(String title, String description,
                        String imageUrl, String category, String videoUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.category = category;
        this.videoUrl = videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public PassiveHouse setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PassiveHouse setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public PassiveHouse setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public PassiveHouse setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public PassiveHouse setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}
