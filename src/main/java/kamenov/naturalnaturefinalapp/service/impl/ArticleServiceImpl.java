package kamenov.naturalnaturefinalapp.service.impl;

import jakarta.annotation.PostConstruct;
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

@Service
public class ArticleServiceImpl implements ArticleService {
    private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);
    private final ArticleRepository articleRepository;
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @PostConstruct
    public void initArticles() {
        if (articleRepository.count() == 0) {
            logger.info("Initializing articles...");
            // Статии за устойчив транспорт
            articleRepository.save(new Article(
                    "The Rise of Electric Vehicles",
                    "Electric vehicles (EVs) are transforming the transportation industry. Learn how they reduce emissions and what to expect in the future.",
                    "/images/electric-car-2.jpg",
                    "Sustainable Transport"
            ));
            articleRepository.save(new Article(
                    "Why Biking is the Future of Urban Mobility",
                    "Biking is not only eco-friendly but also improves health and reduces traffic congestion. Discover why cities are investing in bike lanes.",
                    "/images/biking-future.jpg",
                    "Sustainable Transport"
            ));
            articleRepository.save(new Article(
                    "Public Transport: A Sustainable Choice",
                    "Public transport systems like buses and trains can significantly lower your carbon footprint. Here’s how to make the most of them.",
                    "/images/public-transport.jpg",
                    "Sustainable Transport"
            ));
            articleRepository.save(new Article(
                    "Walking: The Simplest Way to Go Green",
                    "Walking is a zero-emission way to travel. Find out how small changes in your routine can make a big difference.",
                    "/images/walking-green.jpg",
                    "Sustainable Transport"
            ));
            articleRepository.save(new Article(
                    "Hybrid Cars: Bridging the Gap",
                    "Hybrid cars offer a balance between fuel efficiency and performance. Learn how they work and why they’re a great option.",
                    "/images/hybrid-cars.jpg",
                    "Sustainable Transport"
            ));
            articleRepository.save(new Article(
                    "The Impact of Carpooling on the Environment",
                    "Carpooling reduces the number of vehicles on the road, " +
                            "cutting emissions and saving money. See how you can get started.",
                    "/images/carpooling-impact.jpg",
                    "Sustainable Transport"
            ));
            articleRepository.save(new Article(
                    "Sustainable Transportation Policies",
                    "Governments worldwide are implementing policies to promote sustainable transportation. Explore the latest initiatives.",
                    "/images/electric-car-2.jpg",
                    "Sustainable Transport"
            ));
            articleRepository.save(new Article(
                    "The Role of Technology in Green Transport",
                    "From apps to smart traffic systems, " +
                            "technology is making transportation more sustainable. " +
                            "Dive into the innovations driving change.",
                    "/images/green-bus-2.jpg",
                    "Sustainable Transport"
            ));
            articleRepository.save(new Article(
                    "E-Scooters: A New Trend in Urban Travel",
                    "Electric scooters are gaining popularity in cities. " +
                            "Are they a sustainable solution or just a trend?",
                    "/images/e-scooters.jpg",
                    "Sustainable Transport"
            ));
            // Пример за статия от друга категория
            articleRepository.save(new Article(
                    "Reducing Plastic Waste at Home",
                    "Learn simple tips to reduce plastic waste in your daily life.",
                    "/images/plastic-pale.jpg",
                    "Reducing Plastic"
            ));
            logger.info("Articles initialized successfully.");
        } else {
            logger.info("Articles already exist in the database: {} articles found.", articleRepository.count());
        }
    }
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
}
