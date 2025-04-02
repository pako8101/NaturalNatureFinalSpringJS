package kamenov.naturalnaturefinalapp.web;




import kamenov.naturalnaturefinalapp.entity.Article;
import kamenov.naturalnaturefinalapp.entity.ResponsibleFashion;
import kamenov.naturalnaturefinalapp.service.ArticleService;
import kamenov.naturalnaturefinalapp.service.ResponsibleFashionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ResponsibleFashionController {

    private final ResponsibleFashionService responsibleFashionService;
    private final ArticleService articleService;

    public ResponsibleFashionController(ResponsibleFashionService responsibleFashionService, ArticleService articleService) {
        this.responsibleFashionService = responsibleFashionService;
        this.articleService = articleService;
        initializeData();
    }
    private void initializeData() {
        // Инициализация на Responsible Fashion
        String[] fashionTitles = {
                "Introduction: Embracing Ethical Fashion for Eco-friendly Living",
                "Discover Sustainable Clothing Brands: Ethical Practices and Eco-friendly Materials",
                "The Environmental Impact of Fast Fashion: Making Smarter Shopping Decisions",
                "Practical Tips for Integrating Ethical Fashion Into Your Daily Style Choices",
                "Conclusion: Supporting a Greener Future Through Ethical Fashion"
        };

        String[] fashionDescriptions = {
                "Ethical fashion is more than a trend—it's a movement towards sustainability and responsibility. Learn how to embrace eco-friendly living through your fashion choices.",
                "Explore brands that prioritize ethical practices and use eco-friendly materials like organic cotton, " +
                        "recycled polyester, and hemp.Thanks",
                "Fast fashion has a massive environmental footprint. Understand its impact and learn how to make smarter shopping decisions.",
                "Incorporate ethical fashion into your wardrobe with these practical tips, from choosing quality over quantity to supporting local artisans.",
                "By choosing ethical fashion, you’re supporting a greener future. Take action today for a more sustainable tomorrow."
        };
        String[] fashionImageUrls = {
                "/images/fashion.jpg",
                "/images/sustainable-brands.jpg",
                "/images/fast-fashion-impact.jpg",
                "/images/ethical-fashion-tips.jpg",
                "/images/ethical-fashion-conclusion.jpg"
        };
        String[] fashionCategories = {
                "Introduction",
                "Sustainable Brands",
                "Fast Fashion Impact",
                "Practical Tips",
                "Conclusion"
        };



        String[] fashionVideoUrls = {
                "https://www.youtube.com/embed/HMwdb1hqCz4",
                "https://www.youtube.com/embed/E8NXx4IA40U",
                "https://www.youtube.com/embed/fast-fashion-impact-video",
                null,
                "https://www.youtube.com/embed/ethical-fashion-conclusion-video"
        };

        for (int i = 0; i < fashionTitles.length; i++) {
            String title = fashionTitles[i];
            if (!responsibleFashionService.existsByTitle(title)) {
                System.out.println("ResponsibleFashionController: Initializing Responsible Fashion: " + title);
                try {
                    responsibleFashionService.saveResponsibleFashion(new ResponsibleFashion(
                            title,
                            fashionDescriptions[i],
                            fashionImageUrls[i],
                            fashionCategories[i],

                            fashionVideoUrls[i]
                    ));
                } catch (Exception e) {
                    System.out.println("ResponsibleFashionController: Failed to save Responsible Fashion: " + title + ". Reason: " + e.getMessage());
                }
            } else {
                System.out.println("ResponsibleFashionController: Responsible Fashion already exists: " + title);
            }
        }

        // Инициализация на Articles за Responsible Fashion
        String[] articleTitles = {
                "Conscious Consumerism | Making Informed Choices In Ethical Fashion",
                "Capsule Wardrobes | Simplifying Your Style For A Sustainable Closet",
                "The Impact Of Fast Fashion | Understanding The Costs Of Mass Production",
                "Fashion Revolution: Advocating for Transparency and Ethical Practices",
                "Upcycling And Thrifting | Reviving Old Garments For A Greener Wardrobe",
                "The Role Of Vegan Fashion | Cruelty-Free Clothing And Accessories"
        };

        String[] articleContents = {
                "Learn how to make informed choices as a conscious consumer in the world of ethical fashion.",
                "Discover the benefits of a capsule wardrobe for a more sustainable and minimalist style.",
                "Understand the hidden costs of fast fashion and its impact on the environment and society.",
                "Join the Fashion Revolution movement to advocate for transparency and ethical practices in the industry.",
                "Revive old garments through upcycling and thrifting for a greener, more sustainable wardrobe.",
                "Explore the role of vegan fashion in creating cruelty-free clothing and accessories."
        };

        String[] articleImagePaths = {
                "/images/conscious-consumerism.jpg",
                "/images/capsule-wardrobe.jpg",
                "/images/fast-fashion-costs.jpg",
                "/images/fashion-revolution.jpg",
                "/images/upcycling-thrifting.jpg",
                "/images/vegan-fashion.jpg"
        };

        for (int i = 0; i < articleTitles.length; i++) {
            String title = articleTitles[i];
            if (!articleService.existsByTitle(title)) {
                System.out.println("ResponsibleFashionController: Initializing Article: " + title);
                try {
                    articleService.saveArticle(new Article(
                            title,
                            articleContents[i],
                            articleImagePaths[i],
                            "Responsible Fashion"

                    ));
                } catch (Exception e) {
                    System.out.println("ResponsibleFashionController: Failed to save article: " + title + ". Reason: " + e.getMessage());
                }
            } else {
                System.out.println("ResponsibleFashionController: Article already exists: " + title);
            }
        }
    }

    @GetMapping("/responsible-fashion")
    public String getResponsibleFashion(@RequestParam(defaultValue = "0") int page, Model model) {
        // Проверка за отрицателна страница
        if (page < 0) {
            page = 0;
        }

        // Добавяне на секциите за Responsible Fashion
        List<ResponsibleFashion> introduction = responsibleFashionService.getResponsibleFashionsByCategory("Introduction");
        List<ResponsibleFashion> sustainableBrands = responsibleFashionService.getResponsibleFashionsByCategory("Sustainable Brands");
        List<ResponsibleFashion> fastFashionImpact = responsibleFashionService.getResponsibleFashionsByCategory("Fast Fashion Impact");
        List<ResponsibleFashion> practicalTips = responsibleFashionService.getResponsibleFashionsByCategory("Practical Tips");
        List<ResponsibleFashion> conclusion = responsibleFashionService.getResponsibleFashionsByCategory("Conclusion");

        model.addAttribute("introduction", introduction);
        model.addAttribute("sustainableBrands", sustainableBrands);
        model.addAttribute("fastFashionImpact", fastFashionImpact);
        model.addAttribute("practicalTips", practicalTips);
        model.addAttribute("conclusion", conclusion);

        // Пагинация за статии
        Pageable pageable = PageRequest.of(page, 3);
        Page<?> articles = articleService.getArticlesByCategory("Responsible Fashion", pageable);
        System.out.println("ResponsibleFashionController: Articles size: " + (articles != null ? articles.getContent().size() : "null"));
        System.out.println("ResponsibleFashionController: Total Pages: " + (articles != null ? articles.getTotalPages() : "null"));

        model.addAttribute("articles", articles != null ? articles.getContent() : List.of());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", articles != null ? articles.getTotalPages() : 0);
        model.addAttribute("hasPrevious", page > 0);
        model.addAttribute("hasNext", articles != null && page < articles.getTotalPages() - 1);

        return "responsible-fashion";
    }
//    private void initializeData() {
//        // Инициализация на Responsible Fashion
//        List<ResponsibleFashion> allResponsibleFashions = responsibleFashionService.getAllResponsibleFashions();
//        if (allResponsibleFashions.isEmpty()) {
//            System.out.println("ResponsibleFashionController: Initializing Responsible Fashions...");
//            responsibleFashionService.saveResponsibleFashion(new ResponsibleFashion(
//                    "Introduction: Embracing Ethical Fashion for Eco-friendly Living",
//                    "Ethical fashion is more than a trend—it's a movement towards sustainability and responsibility. Learn how to embrace eco-friendly living through your fashion choices.",
//                    "Introduction",
//                    "/images/ethical-fashion-intro.jpg",
//                    "https://www.youtube.com/embed/ethical-fashion-intro-video"
//            ));
//            responsibleFashionService.saveResponsibleFashion(new ResponsibleFashion(
//                    "Discover Sustainable Clothing Brands: Ethical Practices and Eco-friendly Materials",
//                    "Explore brands that prioritize ethical practices and use eco-friendly materials like organic cotton, recycled polyester, and hemp.",
//                    "Sustainable Brands",
//                    "/images/sustainable-brands.jpg",
//                    null
//            ));
//            responsibleFashionService.saveResponsibleFashion(new ResponsibleFashion(
//                    "The Environmental Impact of Fast Fashion: Making Smarter Shopping Decisions",
//                    "Fast fashion has a massive environmental footprint. Understand its impact and learn how to make smarter shopping decisions.",
//                    "Fast Fashion Impact",
//                    "/images/fast-fashion-impact.jpg",
//                    "https://www.youtube.com/embed/fast-fashion-impact-video"
//            ));
//            responsibleFashionService.saveResponsibleFashion(new ResponsibleFashion(
//                    "Practical Tips for Integrating Ethical Fashion Into Your Daily Style Choices",
//                    "Incorporate ethical fashion into your wardrobe with these practical tips, from choosing quality over quantity to supporting local artisans.",
//                    "Practical Tips",
//                    "/images/ethical-fashion-tips.jpg",
//                    null
//            ));
//            responsibleFashionService.saveResponsibleFashion(new ResponsibleFashion(
//                    "Conclusion: Supporting a Greener Future Through Ethical Fashion",
//                    "By choosing ethical fashion, you’re supporting a greener future. Take action today for a more sustainable tomorrow.",
//                    "Conclusion",
//                    "/images/ethical-fashion-conclusion.jpg",
//                    "https://www.youtube.com/embed/ethical-fashion-conclusion-video"
//            ));
//            System.out.println("ResponsibleFashionController: Responsible Fashions initialized.");
//        } else {
//            System.out.println("ResponsibleFashionController: Responsible Fashions already initialized. Count: " + allResponsibleFashions.size());
//        }
//        try {
//
//
//            // Инициализация на Articles за Responsible Fashion
//            String category = "Responsible Fashion";
//            if (!articleService.existsByTitleAndCategory("Conscious Consumerism | Making Informed Choices In Ethical Fashion", category)) {
//                articleService.saveArticle(new Article("Conscious Consumerism | Making Informed Choices In Ethical Fashion",
//                        "Learn how to make informed choices as a conscious consumer in the world of ethical fashion.", category, "/images/conscious-consumerism.jpg"));
//            }
//            if (!articleService.existsByTitleAndCategory("Capsule Wardrobes | Simplifying Your Style For A Sustainable Closet", category)) {
//                articleService.saveArticle(new Article("Capsule Wardrobes | Simplifying Your Style For A Sustainable Closet",
//                        "Discover the benefits of a capsule wardrobe for a more sustainable and minimalist style.", category, "/images/capsule-wardrobe.jpg"));
//            }
//            if (!articleService.existsByTitleAndCategory("The Impact Of Fast Fashion | Understanding The Costs Of Mass Production", category)) {
//                articleService.saveArticle(new Article("The Impact Of Fast Fashion | Understanding The Costs Of Mass Production",
//                        "Understand the hidden costs of fast fashion and its impact on the environment and society.", category, "/images/fast-fashion-costs.jpg"));
//            }
//            if (!articleService.existsByTitleAndCategory("Fashion Revolution: Advocating for Transparency and Ethical Practices", category)) {
//                articleService.saveArticle(new Article("Fashion Revolution: Advocating for Transparency and Ethical Practices",
//                        "Join the Fashion Revolution movement to advocate for transparency and ethical practices in the industry.", category, "/images/fashion-revolution.jpg"));
//            }
//            if (!articleService.existsByTitleAndCategory("Upcycling And Thrifting | Reviving Old Garments For A Greener Wardrobe", category)) {
//                articleService.saveArticle(new Article("Upcycling And Thrifting | Reviving Old Garments For A Greener Wardrobe",
//                        "Revive old garments through upcycling and thrifting for a greener, more sustainable wardrobe.", category, "/images/upcycling-thrifting.jpg"));
//            }
//            if (!articleService.existsByTitleAndCategory("The Role Of Vegan Fashion | Cruelty-Free Clothing And Accessories", category)) {
//                articleService.saveArticle(new Article("The Role Of Vegan Fashion | Cruelty-Free Clothing And Accessories",
//                        "Explore the role of vegan fashion in creating cruelty-free clothing and accessories.", category, "/images/vegan-fashion.jpg"));
//            }
//
//
//        } catch (Exception e) {
//            System.out.println("ResponsibleFashionController: Failed to save article: " + ". Reason: " + e.getMessage());
//        }
//        System.out.println("ResponsibleFashionController: Articles initialized.");
//
//
//    }
//
//    @GetMapping("/responsible-fashion")
//    public String getResponsibleFashion(@RequestParam(defaultValue = "0") int page, Model model) {
//        // Проверка за отрицателна страница
//        if (page < 0) {
//            page = 0;
//        }
//
//        // Добавяне на секциите за Responsible Fashion
//        List<ResponsibleFashion> introduction = responsibleFashionService.getResponsibleFashionsByCategory("Introduction");
//        List<ResponsibleFashion> sustainableBrands = responsibleFashionService.getResponsibleFashionsByCategory("Sustainable Brands");
//        List<ResponsibleFashion> fastFashionImpact = responsibleFashionService.getResponsibleFashionsByCategory("Fast Fashion Impact");
//        List<ResponsibleFashion> practicalTips = responsibleFashionService.getResponsibleFashionsByCategory("Practical Tips");
//        List<ResponsibleFashion> conclusion = responsibleFashionService.getResponsibleFashionsByCategory("Conclusion");
//
//        model.addAttribute("introduction", introduction);
//        model.addAttribute("sustainableBrands", sustainableBrands);
//        model.addAttribute("fastFashionImpact", fastFashionImpact);
//        model.addAttribute("practicalTips", practicalTips);
//        model.addAttribute("conclusion", conclusion);
//
//        // Пагинация за статии
//        Pageable pageable = PageRequest.of(page, 3);
//        Page<?> articles = articleService.getArticlesByCategory("Responsible Fashion", pageable);
//        System.out.println("ResponsibleFashionController: Articles size: " + (articles != null ? articles.getContent().size() : "null"));
//        System.out.println("ResponsibleFashionController: Total Pages: " + (articles != null ? articles.getTotalPages() : "null"));
//
//        model.addAttribute("articles", articles != null ? articles.getContent() : List.of());
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", articles != null ? articles.getTotalPages() : 0);
//        model.addAttribute("hasPrevious", page > 0);
//        model.addAttribute("hasNext", articles != null && page < articles.getTotalPages() - 1);
//
//        return "responsible-fashion";
//    }
}
