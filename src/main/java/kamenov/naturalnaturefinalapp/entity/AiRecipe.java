package kamenov.naturalnaturefinalapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class AiRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ingredients;

    @Column(columnDefinition = "TEXT")
    private String recipe;

    private LocalDateTime generatedAt = LocalDateTime.now();

    public AiRecipe() {
    }

    public Long getId() {
        return id;
    }

    public AiRecipe setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIngredients() {
        return ingredients;
    }

    public AiRecipe setIngredients(String ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public String getRecipe() {
        return recipe;
    }

    public AiRecipe setRecipe(String recipe) {
        this.recipe = recipe;
        return this;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public AiRecipe setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
        return this;
    }
}
