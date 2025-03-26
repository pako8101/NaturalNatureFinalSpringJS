package kamenov.naturalnaturefinalapp.service;

import kamenov.naturalnaturefinalapp.entity.Article;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ArticleService {
    List<Article> getFirstThreeSustainableTransportArticles();

    Page<Article> getSustainableTransportArticles(int page, int size);

    long getTotalSustainableTransportArticles();
}
