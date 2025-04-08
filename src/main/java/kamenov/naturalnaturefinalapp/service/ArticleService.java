package kamenov.naturalnaturefinalapp.service;

import kamenov.naturalnaturefinalapp.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService {
    List<Article> getFirstThreeSustainableTransportArticles();

    Page<Article> getSustainableTransportArticles(int page, int size);

    long getTotalSustainableTransportArticles();
    Page<Article> getArticlesByCategory(String category, Pageable pageable);
//    void initEcoHouses();

    boolean existsByTitleAndCategory(String title, String category);

    void saveArticle(Article article);

    boolean existsByTitle(String title);

    Article getArticleById(Long id);

    void updateArticle(Article responsibleFashion);
}
