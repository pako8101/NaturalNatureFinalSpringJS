package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ArticleGarden extends BaseEntity {
    @Column(name = "title",nullable = false,unique = true)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

}
