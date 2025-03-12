package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(nullable = false)
    private String author;
    @Column(columnDefinition = "TEXT")// Временно статично име
    private String content;
    private String imagePath;
    @Column(nullable = false)// URL на каченото изображение
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();
    @Version // Добавяме поле за оптимистично заключване
    private Long version;
    public Post(String author, String content, String imagePath) {
        this.author = author;
        this.content = content;
        this.imagePath = imagePath;
        this.createdAt = LocalDateTime.now();
    }

    public Post() {

    }

    public String getImagePath() {
        return imagePath;
    }

    public Post setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public Post setVersion(Long version) {
        this.version = version;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Post setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Post setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }



    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Post setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Post setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }
    public void addComment(Comment comment) {
        comments.add(comment);
    }
}