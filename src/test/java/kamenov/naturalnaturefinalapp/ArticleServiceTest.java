package kamenov.naturalnaturefinalapp;



import kamenov.naturalnaturefinalapp.entity.Article;

import kamenov.naturalnaturefinalapp.repositories.ArticleRepository;
import kamenov.naturalnaturefinalapp.service.ArticleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;

    @InjectMocks
    private ArticleService articleService;

    private List<Article> mockArticles;

    @BeforeEach
    void setUp() {
        mockArticles = Arrays.asList(
                new Article("Title 1", "Content 1", "image1.jpg"),
                new Article("Title 2", "Content 2", "image2.jpg"),
                new Article("Title 3", "Content 3", "image3.jpg")
        );
    }

    @Test
    void getFirstThreeSustainableTransportArticles_ShouldReturnThreeArticles() {
        // Arrange
        when(articleRepository.findTop3ByCategory("Sustainable Transport"))
                .thenReturn(mockArticles);

        // Act
        List<Article> result = articleService.getFirstThreeSustainableTransportArticles();

        // Assert
        assertThat(result).hasSize(3);
        assertThat(result).isEqualTo(mockArticles);
        verify(articleRepository, times(1)).findTop3ByCategory("Sustainable Transport");
    }

    @Test
    void getSustainableTransportArticles_ShouldReturnPagedArticles() {
        // Arrange
        int page = 0;
        int pageSize = 3;
        Page<Article> mockPage = new PageImpl<>(mockArticles, PageRequest.of(page, pageSize), 12);
        when(articleRepository.findByCategory("Sustainable Transport", PageRequest.of(page, pageSize)))
                .thenReturn(mockPage);

        // Act
        Page<Article> result = articleService.getSustainableTransportArticles(page, pageSize);

        // Assert
        assertThat(result.getContent()).hasSize(3);
        assertThat(result.getTotalElements()).isEqualTo(12);
        assertThat(result.getTotalPages()).isEqualTo(4);
        verify(articleRepository, times(1)).findByCategory("Sustainable Transport", PageRequest.of(page, pageSize));
    }
}
