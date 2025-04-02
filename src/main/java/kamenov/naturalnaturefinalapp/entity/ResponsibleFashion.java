package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "responsible_fashion")
public class ResponsibleFashion extends BaseEntity{
    @Column(name = "title",nullable = false,length = 300)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url",nullable = false)
    private String imageUrl;
    @Column()
    private String category; // Категория (Energy Efficiency, Solar Power Systems и т.н.)
    @Column(name = "video_url")
    private String videoUrl;

    public ResponsibleFashion() {
    }

    public ResponsibleFashion(String title, String description,
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

    public ResponsibleFashion setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ResponsibleFashion setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ResponsibleFashion setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ResponsibleFashion setCategory(String category) {
        this.category = category;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public ResponsibleFashion setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }
}
