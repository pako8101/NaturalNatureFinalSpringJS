package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "video_course")
public class VideoCourse extends BaseEntity{

    private String title;
//    private String description;
    private String videoUrl;

    public VideoCourse(String title, String videoUrl) {
        this.title = title;
        this.videoUrl = videoUrl;
    }
}
