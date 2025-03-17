package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "premium_content")
public class PremiumContent extends BaseEntity{

    private String title;
    private String description;
    private String type; // "video", "ebook", "webinar"
    private String url; // URL към видеото, eBook и т.н.
    private String thumbnailPath;

    public PremiumContent() {
    }

    public String getTitle() {
        return title;
    }

    public PremiumContent setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PremiumContent setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getType() {
        return type;
    }

    public PremiumContent setType(String type) {
        this.type = type;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PremiumContent setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public PremiumContent setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
        return this;
    }
}
