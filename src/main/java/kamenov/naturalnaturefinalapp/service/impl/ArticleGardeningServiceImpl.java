package kamenov.naturalnaturefinalapp.service.impl;

import jakarta.annotation.PostConstruct;
import kamenov.naturalnaturefinalapp.entity.ArticleGarden;
import kamenov.naturalnaturefinalapp.repositories.ArticleGardenRepository;
import kamenov.naturalnaturefinalapp.service.ArticleGardeningService;


import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleGardeningServiceImpl implements ArticleGardeningService {
    private static final Logger logger =
            Logger.getLogger(ArticleGardeningServiceImpl.class.getName());

    private final ArticleGardenRepository articleRepository;
    @Autowired
    public ArticleGardeningServiceImpl(ArticleGardenRepository articleRepository) {
        this.articleRepository = articleRepository;
    }



    @PostConstruct
    @Override
    public void initArticles() {
        if (articleRepository.count() == 0) {
            logger.info("Initializing articles in the database...");
            String[] titles = {
                    "How to Start an Urban Garden on Your Balcony",
                    "Vertical Gardens: A Solution for Small Spaces",
                    "Composting in the City: How to Do It Easily",
                    "Hydroponics for Urban Gardeners",
                    "Growing Herbs in an Apartment",
                    "The Benefits of Urban Gardens for Communities",
                    "How to Attract Bees to Your Urban Garden",
                    "Recycling Water for Urban Gardens",
                    "Seasonal Gardening in the City"
            };

            String[] contents = {
                    "Starting an urban garden on your balcony is easy and accessible for everyone. First, choose a sunny spot that gets at least 6 hours of light daily. Use pots or old buckets to plant vegetables like tomatoes and lettuce. Add compost from kitchen scraps for natural fertilizer. Water regularly but avoid overwatering to prevent root damage. Vertical racks can expand space for more plants. Opt for compact varieties suited for small spaces. Balcony gardening not only provides fresh produce but also enhances your home’s aesthetics. It reduces stress and connects you with nature. With a bit of creativity, your balcony can become a green oasis.",
                    "Vertical gardens are an ideal solution for urban dwellers with limited space. They utilize walls or trellises to grow plants upward. This technique is perfect for herbs, strawberries, or decorative flowers. You can use old wooden pallets or PVC pipes as a base. Install a drip irrigation system to simplify watering. Vertical gardens improve air quality and reduce noise in the city. They also add beauty to gray urban walls. Ensure you use sturdy structures to support the plants’ weight. Regularly check for pests and keep plants healthy. This method is sustainable and easy to maintain.",
                    "Composting in an urban setting is a simple way to reduce waste and enrich your garden. Collect kitchen scraps like vegetable peels, coffee grounds, and eggshells. Use a small composter suitable for apartments or make one from a bucket. Add dry leaves or paper to balance moisture. Stir the mixture every few days to speed up decomposition. After 2–3 months, you’ll have rich compost for your plants. This process reduces landfill waste and saves money on fertilizers. It also teaches responsible resource management. Composting is a small step toward a more sustainable lifestyle. Start today and see the difference!",
                    "Hydroponics is an innovative technique for urban gardening without soil. Plants grow in a nutrient solution that provides all necessary elements. This system is ideal for small spaces like kitchens or balconies. You can grow lettuce, spinach, or herbs with minimal effort. Hydroponics saves up to 90% of water compared to traditional gardening. It also speeds up plant growth by up to 30%. Start with a simple hydroponic system or build your own using PVC pipes. Maintain a balance of nutrients in the solution. Regularly check the water’s pH level. Hydroponics is the future of sustainable urban agriculture.",
                    "Growing herbs in an apartment is an easy way to add freshness to your meals. Basil, mint, and thyme are great for beginners as they grow quickly. Place pots on a windowsill with plenty of sunlight. Water regularly but avoid overwatering to prevent root rot. Use well-drained soil and add compost for better growth. Herbs not only enhance food flavor but also freshen indoor air. They’re easy to maintain and don’t require much space. You can repurpose old jars or cans as pots. This is an eco-friendly way to have fresh spices year-round. Start small and you’ll fall in love with gardening!",
                    "Urban gardens play a vital role in bringing communities together. They unite people of all ages who share knowledge and resources. Collaborative gardening fosters social bonds and reduces isolation. Community gardens often host workshops on sustainable farming. They provide fresh produce to low-income families, improving access to healthy food. Gardens also teach children responsibility and respect for nature. They reduce crime in neighborhoods by creating safe green spaces. Moreover, they attract pollinators, supporting the local ecosystem. Urban gardens are places for learning, sharing, and growth. Join a local garden and be part of the change!",
                    "Attracting bees to your urban garden is essential for pollination and biodiversity. Plant flowers like lavender, sunflowers, and basil that attract bees. Avoid using pesticides that harm pollinators. Leave shallow water with pebbles for bees to drink. Build small ‘bee hotels’ from bamboo or wood for shelter. A variety of plants ensures food throughout the season. Bees help increase yields of fruits and vegetables. They also support the local ecosystem in urban areas. Working with bees teaches patience and respect for nature. With small actions, we can make our gardens a haven for pollinators.",
                    "Recycling water is key to sustainable urban gardening. Collect rainwater in barrels or buckets placed under gutters. Use water from rinsing vegetables to irrigate plants. Install a drip irrigation system to conserve water. Filter household gray water for reuse in the garden. This practice reduces water usage and lowers bills. It also eases the burden on city sewage systems. Avoid using water with chemicals that could harm plants. Recycling water is an easy way to be more eco-friendly. Start today and see how much water you can save!",
                    "Seasonal gardening in the city is a great way to make the most of the climate. Spring is perfect for planting lettuce, spinach, and radishes. In summer, grow tomatoes, cucumbers, and peppers that thrive in heat. Fall is ideal for root vegetables like carrots and beets. Winter can be used for indoor herbs. Planning by season increases yield and reduces the need for chemicals. Use a planting calendar to track the best times. It also teaches you to live in harmony with natural cycles. Seasonal gardening brings joy and fresh produce year-round. Try it and enjoy the results!"
            };

            for (int i = 0; i < titles.length; i++) {
                ArticleGarden article = new ArticleGarden();
                article.setTitle(titles[i]);
                article.setContent(contents[i]);
                articleRepository.save(article);
            }
            logger.info("Articles initialized successfully.");
        }
    }
@Override
public List<ArticleGarden> getAllArticles() {
        return articleRepository.findAll();
    }
    @Override
    public Optional<ArticleGarden> getArticleById(Long id) {
        return articleRepository.findById(id);
    }
    @Override
    public List<ArticleGarden> getPaginatedArticles(int page, int size) {
        int start = (page - 1) * size;
        List<ArticleGarden> allArticles = articleRepository.findAll();
        return allArticles.subList(
                Math.min(start, allArticles.size()),
                Math.min(start + size, allArticles.size())
        );
    }
@Override
    public long getTotalArticles() {
        return articleRepository.count();
    }
}
