package kamenov.naturalnaturefinalapp;

import kamenov.naturalnaturefinalapp.entity.Article;
import kamenov.naturalnaturefinalapp.service.ArticleService;
import kamenov.naturalnaturefinalapp.service.TransportTipService;
import kamenov.naturalnaturefinalapp.web.SustainableTransportationController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;
import kamenov.naturalnaturefinalapp.entity.TransportTip;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SustainableTransportationControllerTest {

    @Mock
    private ArticleService articleService;

    @Mock
    private TransportTipService transportTipService;

    @Mock
    private Model model;

    @InjectMocks
    private SustainableTransportationController controller;

    private List<Article> mockArticles;
    private List<TransportTip> mockTips;

    @BeforeEach
    void setUp() {
        // Подготвяме мок данни
        mockArticles = Arrays.asList(
                new Article("Title 1", "Content 1", "image1.jpg"),
                new Article("Title 2", "Content 2", "image2.jpg"),
                new Article("Title 3", "Content 3", "image3.jpg")
        );
        mockTips = Arrays.asList(
                new TransportTip("Tip 1"),
                new TransportTip("Tip 2"),
                new TransportTip("Tip 3")
        );
    }

    @Test
    void showSustainableTransportationPage_ShouldReturnCorrectViewAndAddAttributes() {
        // Arrange
        when(transportTipService.getAllTips()).thenReturn(mockTips);
        when(articleService.getFirstThreeSustainableTransportArticles()).thenReturn(mockArticles);

        // Act
        String viewName = controller.showSustainableTransportationPage(model);

        // Assert
        assertThat(viewName).isEqualTo("sustainable-transportation");
        verify(model).addAttribute("tips", mockTips);
        verify(model).addAttribute("articles", mockArticles);
        verify(transportTipService, times(1)).getAllTips();
        verify(articleService, times(1)).getFirstThreeSustainableTransportArticles();
    }

    @Test
    void showSustainableTransportArticlesPage_ShouldReturnCorrectViewAndAddPaginationAttributes() {
        // Arrange
        int page = 1;
        int pageSize = 3;
        Page<Article> mockPage = new PageImpl<>(mockArticles, PageRequest.of(page, pageSize), 12); // Общо 12 статии
        when(articleService.getSustainableTransportArticles(page, pageSize)).thenReturn(mockPage);

        // Act
        String viewName = controller.showSustainableTransportArticlesPage(page, model);

        // Assert
        assertThat(viewName).isEqualTo("sustainable-transportation-articles");
        verify(model).addAttribute("articles", mockArticles);
        verify(model).addAttribute("currentPage", page);
        verify(model).addAttribute("totalPages", 4); // 12 статии ÷ 3 на страница = 4 страници
        verify(articleService, times(1)).getSustainableTransportArticles(page, pageSize);
    }

    @Test
    void showSustainableTransportArticlesPage_WithDefaultPage_ShouldUsePageZero() {
        // Arrange
        int page = 0;
        int pageSize = 3;
        Page<Article> mockPage = new PageImpl<>(mockArticles, PageRequest.of(page, pageSize), 12);
        when(articleService.getSustainableTransportArticles(page, pageSize)).thenReturn(mockPage);

        // Act
        String viewName = controller.showSustainableTransportArticlesPage(page, model);

        // Assert
        assertThat(viewName).isEqualTo("sustainable-transportation-articles");
        verify(model).addAttribute("currentPage", 0);
        verify(articleService, times(1)).getSustainableTransportArticles(0, pageSize);
    }
}
