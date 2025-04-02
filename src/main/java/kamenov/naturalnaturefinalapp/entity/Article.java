package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "article",uniqueConstraints = @UniqueConstraint(columnNames = {"title", "category"}))
public class Article extends BaseEntity {
    @Column(name = "title",nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(name = "image_path",nullable = false)
    private String imagePath;

    @Column(name = "category",nullable = false)
    private String category;
    public Article() {

    }

    public Article(String title, String content, String imagePath, String category) {
        this.title = title;
        this.content = content;
        this.imagePath = imagePath;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Article setContent(String content) {
        this.content = content;
        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Article setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public Article setCategory(String category) {
        this.category = category;
        return this;
    }
}
