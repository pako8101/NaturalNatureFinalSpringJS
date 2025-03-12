package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "comments")
public class Comment {
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
    @Version // Добавяме поле за оптимистично заключване
    private Long version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;
    public Comment(String author, String content, String imagePath, Post post) {
        this.author = author;
        this.content = content;
        this.imagePath = imagePath;
        this.post = post;
        this.createdAt = LocalDateTime.now();
    }

    public Comment() {

    }

    public Long getId() {
        return id;
    }

    public Comment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Comment setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Comment setImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public Long getVersion() {
        return version;
    }

    public Comment setVersion(Long version) {
        this.version = version;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public Comment setPost(Post post) {
        this.post = post;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Comment setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
