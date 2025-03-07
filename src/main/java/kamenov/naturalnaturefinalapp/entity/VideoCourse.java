package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class VideoCourse extends BaseEntity{

    private String title;
    private String description;
    private String videoUrl;
}
