package kamenov.naturalnaturefinalapp.service;

import jakarta.annotation.PostConstruct;
import kamenov.naturalnaturefinalapp.entity.ArticleGarden;

import java.util.List;
import java.util.Optional;

public interface ArticleGardeningService {
    @PostConstruct
    void initArticles();

    List<ArticleGarden> getAllArticles();

    Optional<ArticleGarden> getArticleById(Long id);

    List<ArticleGarden> getPaginatedArticles(int page, int size);

    long getTotalArticles();
}
