package kamenov.naturalnaturefinalapp.service.impl;

import kamenov.naturalnaturefinalapp.entity.Article;
import kamenov.naturalnaturefinalapp.repositories.ArticleRepository;
import kamenov.naturalnaturefinalapp.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {
    private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);
    private final ArticleRepository articleRepository;
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


//    @PostConstruct
//    public void initArticles() {
//        if (articleRepository.count() == 0) {
//            logger.info("Initializing articles...");
//            // Статии за устойчив транспорт
//            articleRepository.save(new Article(
//                    "The Rise of Electric Vehicles",
//                    "Electric vehicles (EVs) are transforming the transportation industry. Learn how they reduce emissions and what to expect in the future.",
//                    "/images/electric-car-2.jpg",
//                    "Sustainable Transport"
//            ));
//            articleRepository.save(new Article(
//                    "Why Biking is the Future of Urban Mobility",
//                    "Biking is not only eco-friendly but also improves health and reduces traffic congestion. Discover why cities are investing in bike lanes.",
//                    "/images/biking-future.jpg",
//                    "Sustainable Transport"
//            ));
//            articleRepository.save(new Article(
//                    "Public Transport: A Sustainable Choice",
//                    "Public transport systems like buses and trains can significantly lower your carbon footprint. Here’s how to make the most of them.",
//                    "/images/public-transport.jpg",
//                    "Sustainable Transport"
//            ));
//            articleRepository.save(new Article(
//                    "Walking: The Simplest Way to Go Green",
//                    "Walking is a zero-emission way to travel. Find out how small changes in your routine can make a big difference.",
//                    "/images/walking-green.jpg",
//                    "Sustainable Transport"
//            ));
//            articleRepository.save(new Article(
//                    "Hybrid Cars: Bridging the Gap",
//                    "Hybrid cars offer a balance between fuel efficiency and performance. Learn how they work and why they’re a great option.",
//                    "/images/hybrid-cars.jpg",
//                    "Sustainable Transport"
//            ));
//            articleRepository.save(new Article(
//                    "The Impact of Carpooling on the Environment",
//                    "Carpooling reduces the number of vehicles on the road, " +
//                            "cutting emissions and saving money. See how you can get started.",
//                    "/images/carpooling-impact.jpg",
//                    "Sustainable Transport"
//            ));
//            articleRepository.save(new Article(
//                    "Sustainable Transportation Policies",
//                    "Governments worldwide are implementing policies to promote sustainable transportation. Explore the latest initiatives.",
//                    "/images/electric-car-2.jpg",
//                    "Sustainable Transport"
//            ));
//            articleRepository.save(new Article(
//                    "The Role of Technology in Green Transport",
//                    "From apps to smart traffic systems, " +
//                            "technology is making transportation more sustainable. " +
//                            "Dive into the innovations driving change.",
//                    "/images/green-bus-2.jpg",
//                    "Sustainable Transport"
//            ));
//            articleRepository.save(new Article(
//                    "E-Scooters: A New Trend in Urban Travel",
//                    "Electric scooters are gaining popularity in cities. " +
//                            "Are they a sustainable solution or just a trend?",
//                    "/images/e-scooters.jpg",
//                    "Sustainable Transport"
//            ));
//            // Пример за статия от друга категория
//            articleRepository.save(new Article(
//                    "Reducing Plastic Waste at Home",
//                    "Learn simple tips to reduce plastic waste in your daily life.",
//                    "/images/plastic-pale.jpg",
//                    "Reducing Plastic"
//            ));
//            logger.info("Articles initialized successfully.");
//        } else {
//            logger.info("Articles already exist in the database: {} articles found.", articleRepository.count());
//        }
//    }
@Override
    public List<Article> getFirstThreeSustainableTransportArticles() {
        return articleRepository.findByCategory("Sustainable Transport", PageRequest.of(0, 3)).stream().toList();
    }
    @Override
    public Page<Article> getSustainableTransportArticles(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return articleRepository.findByCategory("Sustainable Transport", pageable);
    }
    @Override
    public long getTotalSustainableTransportArticles() {
        return articleRepository.findByCategory("Sustainable Transport").size();
    }
    @Override
    public void updateArticle(Article article) {
        Optional<Article> existingArticle = articleRepository.findByTitle(article.getTitle());
        if (existingArticle.isPresent()) {
            Article updatedArticle = existingArticle.get();
            updatedArticle.setContent(article.getContent());
            updatedArticle.setCategory(article.getCategory());
            updatedArticle.setImagePath(article.getImagePath());
            articleRepository.save(updatedArticle);
        } else {
            articleRepository.save(article);
        }
    }

    @Override
    public Page<Article> getArticlesByCategory(String category, Pageable pageable) {
        return articleRepository.findByCategory(category, pageable);
    }
    @Override
    public boolean existsByTitleAndCategory(String title, String category) {
        return articleRepository.existsByTitleAndCategory(title, category);
    }
    @Override
    public void saveArticle(Article article) {
        System.out.println("ArticleServiceImpl: Saving article: " + article.getTitle());
        articleRepository.save(article);
        System.out.println("ArticleServiceImpl: Article saved. Total count: " + articleRepository.count());
    }
    @Override
    public boolean existsByTitle(String title) {
        return articleRepository.existsByTitle(title);
    }

    @Override
    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
//    @Override
//    public void initEcoHouses() {
//        if (articleRepository.count() == 0) {
//            articleRepository.saveAll(List.of(
//                    new Article("The Future of Passive Houses", "Exploring the latest trends in passive house design.", "Passive Houses", "/images/passive-house-1.jpg"),
//                    new Article("How to Retrofit Your Home for Energy Efficiency", "Practical tips for making your home more sustainable.", "Passive Houses", "/images/passive-house-2.jpg"),
//                    new Article("Solar Power: The Ultimate Guide", "Everything you need to know about solar energy in homes.", "Passive Houses", "/images/passive-house-3.jpg"),
//                    new Article("Water Conservation Techniques for Every Home", "Simple ways to save water in your household.", "Passive Houses", "/images/passive-house-4.jpg"),
//                    new Article("Wind Turbines for Residential Use", "A beginner's guide to wind energy at home.", "Passive Houses", "/images/passive-house-5.jpg"),
//                    new Article("Eco-Friendly Materials 101", "The best materials for sustainable construction.", "Passive Houses", "/images/passive-house-6.jpg"),
//                    new Article("Energy Star Appliances: Why They Matter", "How Energy Star appliances can reduce your energy bills.", "Passive Houses", "/images/passive-house-7.jpg"),
//                    new Article("Prefab Homes: The Future of Sustainable Living", "Why prefab homes are a smart choice for eco-conscious builders.", "Passive Houses", "/images/passive-house-8.jpg")
//            ));
//            System.out.println("Articles initialized.");
//        }
//    }
}
