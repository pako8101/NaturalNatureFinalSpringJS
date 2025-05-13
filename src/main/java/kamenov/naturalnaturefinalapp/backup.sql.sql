-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: natural_nature_app
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ai_recipe`
--

DROP TABLE IF EXISTS `ai_recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ai_recipe` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `generated_at` datetime(6) DEFAULT NULL,
  `ingredients` varchar(255) DEFAULT NULL,
  `recipe` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ai_recipe`
--

LOCK TABLES `ai_recipe` WRITE;
/*!40000 ALTER TABLE `ai_recipe` DISABLE KEYS */;
INSERT INTO `ai_recipe` VALUES (1,'2025-04-28 13:47:08.117578','домат,лук,боб,морков','Ти си екологичен готвач. Дай ми еко рецепта с тези продукти: домат,лук,боб,морков. Използвай кратък формат на рецепта и напиши я на български. на тегротели, на по цеползвай кратък ъа на бо, на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формаoreAnd, на български. К готели, на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на рецеползвай кратък формат на'),(2,'2025-04-28 13:48:14.710028','боб,лук,брашно,домат,олио','Ти си екологичен готвач. Дай ми еко рецепта с тези продукти: боб,лук,брашно,домат,олио. Използвай кратък формат на рецепта и напиши я на български. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай терния. Дай тернFound&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found&Found Alliance (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Drafthouse) (Alamo Draf');
/*!40000 ALTER TABLE `ai_recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) NOT NULL,
  `content` text,
  `image_path` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKj7yajdncjb7h7dtf6o3csn1fd` (`title`,`category`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'/images/house-6.jpg','Exploring the latest trends in passive house design.','Passive Houses','The Future of Passive Houses'),(2,'Passive Houses','Practical tips for making your home more sustainable.','/images/home-fit-anime.jpg','How to Retrofit Your Home for Energy Efficiency'),(3,'Passive Houses','Everything you need to know about solar energy in homes.','/images/solar-city-anime.jpeg','Solar Power: The Ultimate Guide'),(4,'Passive Houses','Simple ways to save water in your household.','/images/water-anime.jpg','Water Conservation Techniques for Every Home'),(5,'Passive Houses','A beginner\'s guide to wind energy at home.','/images/wind-1.jpg','Wind Turbines for Residential Use'),(6,'Passive Houses','The best materials for sustainable construction.','/images/101-anime.jpg','Eco-Friendly Materials 101'),(7,'Passive Houses','How Energy Star appliances can reduce your energy bills.','/images/energy-star.jpg','Energy Star Appliances: Why They Matter'),(8,'Passive Houses','Why prefab homes are a smart choice for eco-conscious builders?\nPrefab Homes: The Future of Efficient Housing\n1. What Are Prefab Homes?\nPrefab homes (short for prefabricated homes) are residential structures where major components (walls, roof, interior elements)\nare manufactured off-site in a factory-controlled environment, then transported and assembled on the building site.\nThis method revolutionizes traditional construction by prioritizing speed, precision, and sustainability.\n2. Types of Prefab Homes:\nModular Homes: Built in sections (modules) that are stacked or joined on-site.\nPanelized Homes: Use pre-made wall panels for rapid assembly.\nSteel or Timber Frame Homes: Lightweight yet durable skeletal structures.\nShipping Container Homes: Repurposed steel containers transformed into living spaces.\nTiny Homes: Compact, mobile dwellings (often under 400 sq. ft).\n3. Key Advantages:\nSpeed: 50–70% faster construction than traditional methods (typically 2–6 months).\nCost-Effective: Reduced labor/material waste and predictable pricing.\nEco-Friendly: Minimized construction waste; options for recycled/sustainable materials.\nCustomization: Flexible designs to match modern aesthetics.\nQuality Control: Factory precision reduces defects and weather-related delays.\n4. Challenges to Consider:\nDesign Limits: Complex architectural features may require customization.\nTransport Logistics: Costs vary by location and home size.\nZoning Laws: Some regions have strict permits for prefab structures.\n5. Ideal For:\nHomeowners seeking affordable, fast-tracked housing.\nMinimalists and eco-conscious buyers.\nInvestors in vacation rentals or ADUs (Accessory Dwelling Units).\n6. Prefab vs. Traditional Homes:\nFeature	Prefab Homes	Traditional Homes\nBuild Time	2–6 months	6–18+ months\nCost	Often 10–20% lower	Highly variable\nSustainability	High potential	More waste generated\nWhy It Matters Now:\nWith rising housing costs and climate concerns, prefab homes offer a scalable, efficient, \nand greener alternative—blending innovation with practicality.\nPro Tip: Look for certifications like LEED or Passivhaus for ultra-efficient models.\nThis version keeps your original structure but enhances readability with:\nClearer headings and bullet points.','/images/prefab-house.jpg','Prefab Homes: The Future of Sustainable Living'),(9,'Responsible Fashion','<p class=\"highlight\">Learn how to make informed choices as a conscious consumer in the world of ethical fashion.</p><p class=\"highlight\">Understanding Conscious Consumerism in the Fashion Industry\n</p>Understanding conscious consumerism in the fashion industry involves comprehending the critical role that the fashion industry plays in global ethical practices, sustainability, social impact, and environmental stewardship. Conscious consumerism is a rising trend where informed consumers make purchasing decisions based on knowledge about a company’s ethical practices, sustainable production, and social responsibility. This shift towards conscious consumerism encourages adopting a more sustainable lifestyle through making informed decisions about their purchases, favoring second-hand or sustainably produced attire, and supporting fashion brands that prioritize fair labor practices and minimize environmental impact. \n\nEmbracing conscious consumerism entails becoming a conscious consumer who understands the power of conscious consumerism and its potential to effect positive change. By making informed purchase decisions and choosing eco-friendly, ethically sourced products, consumers can both reduce waste and support fair trade practices in the fashion industry. By looking for brands offering sustainable fashion and meeting ethical standards, they opt for a more sustainable future. \n\nConsider some of the impactful actions that conscious consumers can adopt:\n\nUsing the power of conscious consumerism to favor brands and products that promote sustainable business practices.\nAdvocating for better labor practices and supporting companies that prioritize safe working conditions and fair wages.\nChoosing to buy from local businesses and ethical fashion brands to help contribute to a more sustainable and equitable economy.\nAdopting lifestyle changes such as clothing swaps and buying second-hand to reduce the carbon footprint associated with fashion. \nIt’s important to remember that when it comes to conscious consumerism in the fashion industry, it’s up to us as consumers to make the world a better place. We have the power to create a more sustainable and just fashion industry through our buying decisions, and by sharing our knowledge through social media and other platforms, we send a powerful message that we want to invest in a sustainable future.\n\nThe Rise of the Conscious Consumer in Ethical Fashion\nThe rise of conscious consumerism is undeniably transforming the traditional landscape of the fashion sector, giving birth to a growing movement of ethical fashion. This seismic shift supports a new generation of ethical brands, which prioritize sustainability, fair wages, and transparency in their supply chain. Ethical fashion choices now form an integral part of decisions consumers are making, with an increasing number of individuals selecting items made from sustainable materials and considering the social and environmental impacts of their purchase decisions. Rather than perpetuating the cycle of fast fashion, these new-age consumers are making conscious decisions to support businesses that adopt sustainable practices and operate with a strong sense of corporate social responsibility.\n\nMoreover, the concept of conscious consumerism is not solely limited to the act of making a conscious purchase. Many ethical fashion followers are also leveraging their buying power to effect change in different ways. For instance, before making a purchase, they thoroughly research the company to understand the intricacies of their supply chain, look for certifications proving fair wages and sustainable processes, and gain insight into where their money is actually going.\n\nKey practices such as these, inherent to the rise of conscious consumerism, include:\n\nActively supporting businesses that offer a variety of ethical and sustainable products\nReusing and recycling to reduce impact on the environment\nSharing knowledge about ethical consumption and supporting local communities via social media\nHelping create a better future by promoting sustainable and responsible shopping habits. \nThis approach towards ethical consumption not only helps support small operations with proper wage guidelines but also assists in creating a ripple effect in the ethical fashion industry. It’s all about taking decisive, informed actions as conscientious buyers and understanding the power we hold in making a difference with every purchase we make.\n\nMaking Informed Purchase Decisions As a Mindful Consumer\nIn today’s complex and ever-changing market landscape, making informed purchase decisions as a mindful consumer is becoming progressively important. The notion of conscious consumerism suggests that we, as buyers, must be aware of where our money is going and consider the impact on the environment and society as a whole before buying any product or service. Many brands today are moving towards sustainable and responsible business practices, including transparency about their supply chain and corporate social responsibility initiatives. However, it is crucial for individuals to familiarize themselves with these efforts and to use their buying power to support businesses that prioritize environmental and social impacts.\n\nAdopting sustainable behavior as a consumer not only helps to reduce one’s carbon footprint but also contributes to creating a more sustainable and equitable economy. This could be achieved by opting for sustainable products that are produced in an environmentally friendly manner or promoting fair trade.  Here are a few pointers to facilitate your transition to mindful consumerism:\n\nStay informed: Educate yourself about the various certifications and labels that indicate a product’s sustainability credentials.\nLeverage online resources: Utilize the internet and social media to find reviews and information about a company’s commitment to sustainability.\nShare your knowledge: Educate your peers about conscious consumerism and advocate for sustainable brands.\nBecoming a mindful consumer does demand some effort – it is one of the key decisions we make as consumers. Contrarily, it also makes us more aware and appreciative of the goods we purchase and consume. So, share your knowledge, use social media to advocate for conscious consumer habits, and remember that every purchase you make sends a message about your values and expectations as a consumer.\n\n<p class=\"highlight\"How to Embrace Conscious Consumerism in Your Fashion Choices\n</p>Conscious consumerism has increasingly become an integral part of the fashion industry, fundamentally shaping the way we make decisions as a consumer. This involves an approach to shopping that places a great emphasis on informed decision-making and aligns purchases with our individual moral and ethical values. It’s about understanding the path through which garments reach us, from the extraction of raw materials to the moment they land in our wardrobes. One pivotal aspect of conscious consumerism is acknowledging the environmental and social impacts of each step of this journey. This knowledge allows us to be considerate consumers, helping to foster a more sustainable and equitable fashion industry.\n\nLuckily, with the right insights, embracing conscious consumerism in our fashion choices can be relatively manageable and intuitive. It begins with using our buying power to support brands that are transparent about their production processes, sharing detailed information about their supply chains and their efforts to mitigate detrimental environmental effects. Furthermore, being conscious consumers often necessitates favoring essentials and quality over fast fashion, helping to create a wardrobe that lasts and reduces waste. These steps include:\n\n<p class=\"highlight\"Prioritizing quality over quantity.</p>\nShopping from brands advocating for fair trade and worker rights.\nOpting for second-hand or vintage clothing when possible.\nMortgaging the longevity of clothing when making a purchase.\nThrough our smart and deliberate fashion choices, conscious consumerism allows us not only to look good but also to do good, reflecting a lifestyle that respects both people and the planet. This approach to fashion, centered on ethical considerations and sustainability, enables us to contribute to the industry’s positive transformation. As we continue to embrace conscious consumerism, we actively participate in creating a more responsible and mindful fashion ecosystem, where every purchase is a step towards a more ethical and sustainable future.\n\n<p class=\"highlight\"Conclusion\n</p><p>In conclusion, the evolution of conscious consumerism is reshaping global markets, driving a shift towards sustainable and ethical business practices. This progression constitutes a change in mindset, where consumers no longer focus only on the quality and price of goods, but also on their social and environmental impact. Conscious consumerism encourages businesses to consider the lifecycle of their products, taking into account factors such as sourcing, manufacturing, and end-of-life disposal or recycling. Through informed decisions, consumers can support companies that actively reduce their environmental footprint, stimulate economic growth in disadvantaged areas, and promote fair labor practices. This change in consumption patterns fosters a more equitable and sustainable world.\n\nNonetheless, the transition involves a significant learning curve for both consumers and companies. For it to succeed, accurate and transparent information about the entire production process needs to be readily available. This will allow consumers to make truly conscious decisions and companies to gain credibility in the growing market for sustainable and ethical products. Hence, conscious consumerism, with its focus on sustainability and fairness, will be a cornerstone of the economy of the future. It exemplifies how individual purchasing decisions can collectively drive fundamental changes in businesses and society as a whole, supporting a shift to a more sustainable and just global economy.</p>','/images/conscious-consumerism.jpeg','Conscious Consumerism | Making Informed Choices In Ethical Fashion'),(10,'Responsible Fashion','Discover the benefits of a capsule wardrobe for a more sustainable and minimalist style.Introduction to Capsule Wardrobes: A Step towards Simplifying Your Style\nIntroducing the concept of a capsule wardrobe may possibly herald a pivotal step in simplifying your style and reducing decision fatigue. As opposed to fast fashion where clothing items quickly go out of fashion, a capsule wardrobe is all about owning fewer, higher quality, and timeless pieces that reflect your personal style and can be worn in various combinations under diverse circumstances. The essence of a capsule wardrobe isn’t simply about curating a quaint set of clothes for aesthetic value, it’s also about reducing waste, minimizing your carbon footprint, and streamlining your closet. Notably, the term “capsule wardrobe” suggests quality over quantity, a strategy that aims to counteract the fashion industry’s propensity to churn out trends that go out of style before they even hit the front of your closet.\n\nWith the rise of sustainability in the fashion industry, your capsule wardrobe can help align your stylistic preferences with ethical and sustainable practices. The benefits of a capsule wardrobe extend beyond simplifying your wardrobe, it also serves to promote sustainable fashion. The pieces for your capsule should typically be made from sustainable materials such as organic GOTS-certified organic cotton, or recycled fibers that don’t compromise on quality. Brands that offer sustainable capsule wardrobe brands should prioritize timeless, ethically made garments featuring neutral colors and styles that never quickly go out of style. Moreover, adopting the minimalist mindset inherent in building a capsule wardrobe means making high-quality, versatile choices that work well together and can be mixed and matched to create unique outfits.\n\nFor a start, choose a staple from a sustainable clothing brand, opt for versatile pieces and neutral colors that can be mixed and matched, and ensure they’re built to last, whether in terms of style or durability. The decision to build a sustainable capsule wardrobe not only places the spotlight on quality over quantity but also acknowledges the environmental impact of our clothing choices. As you curate your capsule wardrobe today, remember to include timeless pieces that can be worn across seasons and occasions, a representation of minimalism, and a commitment to lessen our environmental footprint. Investing in a capsule wardrobe will help equip you with a set of timeless wardrobe capsules that not only simplify your life but also advance sustainable and ethical practices.\n\nUnderstanding Sustainability in Fashion: Sabotage of Fast Fashion\nUnderstanding sustainability in fashion necessitates recognizing the detriment caused by fast fashion. Fast fashion, an industry notorious for its unsustainable practices, contributes significantly to environmental degradation and exploitation of labor. It encourages consumers to frequently ‘buy new’, creating a spiral that perpetuates harm to our planet. Thus, it has become essential to pivot toward slow fashion brands and promote an ethical brand culture targeted at reducing this damage. An innovative way to contribute to this change is to create a wardrobe that works on the principles of sustainable fashion.\n\nThe concept of creating a capsule wardrobe serves this purpose efficiently. The term “capsule wardrobe” refers to a minimalist wardrobe composed of essential pieces that ‘never go out of style’. These sustainable wardrobe pieces from sustainable fashion brands are versatile and enduring. When you create a sustainable capsule wardrobe, you select a small number of clothes that can be mixed and matched to form many outfits. Here are the key benefits:\n\nLongevity: High-quality clothes last longer and reduce the need to constantly buy new items.\nReduce Waste: By using every item in your entire capsule in front of your closet, you significantly negate clothing waste.\nVersatility: A capsule wardrobe allows you to create diverse looks from a limited number of items, thereby simplifying your current wardrobe too.\nSustainability: Opting for sustainable fabrics and finishes that are better for the environment boosts your contribution towards a green planet.\nCreating such a wardrobe is a collection of processes that reflects your unique style and color preferences, while simultaneously considering the impact on the environment. It’s about responsible brands that prioritize ethical sourcing and production detailed in their capsule collections. So, as you wear your capsule, know you wear the perfect amalgamation of style, sustainability, and consciousness, creating a ripple effect in curbing the sabotage of fast fashion.\n\nIntegrating Timeless Casual Style into Your Capsule Wardrobe\nIntegrating timeless casual style into your capsule wardrobe is a practice that not only elevates your personal style but also promotes the concept of a sustainable closet. The term “capsule wardrobe” refers to a limited selection of essential clothing items that never go out of style. These pieces serve as the foundation of your wardrobe, providing you with versatile options that are easy to mix and match. Your collection of perfect capsule pieces may include anything from classic blue jeans, tailored blazers, and crisp white shirts, to comfortable sneakers. \n\nDespite being minimalistic in nature, a capsule wardrobe reflects your personal style and is adaptable for virtually any circumstance. Creating many capsule wardrobe pieces further allows individuals to streamline their wardrobe and reduce excessive consumption. This concept leans into conscious consumerism, emphasizing the value of quality over quantity. There’s a certain art in creating a wardrobe that is functional, stylish, and aligned with one’s ethics.\n\nSome tips for integrating a timeless casual style into your capsule wardrobe might include:\n\nOpting for natural fabrics and neutral tones that are easy to pair and layer\nChoosing pieces that you love and feel comfortable in, that reflect your personal style\nBuying from brands that emphasize sustainability and ethical production\nInvesting in well-tailored, durable pieces that can withstand the test of time.\nRemember, the goal is to create a closet full of items that work together seamlessly and never go out of style. Thus, a well-curated capsule wardrobe also reduces decision-making stress, leading to a more peaceful, organized lifestyle.\n\nFrom Casual to Smart: How to Recycle the Clothes in Your Closet for Variety\nRevamping your wardrobe need not always mean purchasing fresh outfits; instead, more and more fashion-conscious individuals are realizing the need to smartly recycle their existing closet collections. This practice not only promotes sustainable fashion but also uncovers a world of mix-and-match possibilities unexplored in the bounds of one’s wardrobe. The term “capsule wardrobe” refers to the concept of a compact set of clothing that meets your everyday needs. By selectively choosing a limited number of versatile garments from your closet, you can transform your casual wear into smart attire with just a few strategic changes and additions, thereby creating a thriving capsule wardrobe.\n\nTo successfully transition from casual to smart wear, consider your existing wardrobe and identify pieces that can be easily dressed up or down. For instance, a basic white T-shirt may seem casual, but when paired with a sleek blazer and statement jewelry, it can shift to a sophisticated ensemble with a professional touch. Alternatively, a simple change like swapping your sneakers for heeled boots can elevate a relaxed jeans-and-top outfit into a classy, smart-casual look. \n\nHere are some key steps:\n\nBegin by organizing your clothing into categories like tops, bottoms, dresses, and accessories.\nIdentify versatile elements that can create various outfit combinations.\nExperiment with pairing different pieces and visualizing potential smart outfits.\nRemember, while trends and styles may change, the fundamental principle of achieving a fluid wardrobe is all about mastering the art of restyling and recycling your clothes to maintain variety.\n\nList of Sustainable and Ethical Fashion Brands for Building Your Capsule Wardrobe\nIn today’s ever-evolving fashion paradigm, the term “capsule wardrobe” has become a prominent fixture, signifying a minimalist collection of high-quality, versatile garments that form the essential backbone of one’s attire. This concept is especially relevant as consumers are becoming more ethically and environmentally conscious, recognizing the necessity for sustainable fashion choices. Building this type of wardrobe embodies a purposeful shift towards investing in quality over quantity, hence, leading a throng of fashion enthusiasts towards exploring sustainable and ethical fashion brands.\n\nThere are a plethora of such brands that seamlessly merge fashion, functionality, and environmental responsibility. For instance, ‘Everlane’, a transparent brand, uses sustainably-sourced materials and ensures fair wages for its workers. ‘Patagonia’, renowned for its outdoor apparel, is deeply committed to environmental activism, using recycled and organic materials, and guaranteeing fair trade products.\n\nAnother remarkable name is ‘People Tree’, a pioneer in sustainable and fair trade fashion. Each of these brands places a strong emphasis on preservative manufacturing processes and ethical sourcing, embodying the essence of sustainability and sartorial elegance. Incorporating these brands into your capsule wardrobe not only fuels an ethical lifestyle but also enriches your style statement with timeless pieces. So, go ahead, delve into these conscious retails, and create a wardrobe that is as kind to the planet as it is to your style.\n\n<p class=\"highlight\"Final Thoughts: Embracing Slow Fashion and Sustainable Brands in a Fast-Paced World\n</p><p>Concluding our discourse, it becomes palpable that embracing slow fashion and sustainable brands is not just an ethical choice, but rather a necessity in our fast-paced world. As we continue to progress as a society, it can be easy to forget the impact that our consumption habits have on the environment. Rapid fashion trends are known for promoting excess waste, but planning a more sustainable approach can drastically reduce this challenge. The idea of curating a mindful, lasting ‘capsule wardrobe’, for instance, presents a solid solution. This refers to a collection of clothes that don’t go out of style and can be mixed or matched to create numerous outfits, reducing the need for constant buying.\n\nHighlighting further, cultivating an awareness and understanding of the term “capsule wardrobe” has begun to create a shift in the consumer mindset from quantity to quality. To further foster this sustainable cultural shift, some well-considered steps could be:\n\nAssessing and critically evaluating our current consumption patterns\nEmphatically advocating for ethical sourcing and production methods\nInvesting in long-lasting, versatile statement pieces rather than transient trend-based clothing\nPrioritizing brands that demonstrate commitment to environmentally friendly practices.\nRemember that taking these conscious measures are baby steps towards a larger, more sustainable future, as slow fashion provides a mindful approach, allowing us to still enjoy the pleasure and expression of fashion, but in a way that respects both the planet and the people involved in the creation of our garments. It’s about choosing quality over quantity, understanding the value of each piece, and recognizing the power of our choices as consumers. By embracing slow fashion and supporting sustainable brands, we contribute to a more ethical and eco-conscious fashion industry, one that values longevity, craftsmanship, and the environment, steering us towards a more thoughtful and sustainable way of living.\n</p>\n<p class=\"highlight\"Conclusion\n</p><p>In conclusion, the concept of a “capsule wardrobe” has garnered significant attention owing to its practicality and user-friendliness. Encompassing a minimalist approach, it comprises pieces that are versatile, timeless, and truly essential, limiting excess and encouraging reuse. Consumers in the modern era seek value for money and sustainability, and the capsule wardrobe encompasses these qualities. It utilizes the notion that one doesn’t need excessive items of clothing, but rather a curated selection that can interchangeably work together to create multiple outfit combinations. Such minimalism and eco-friendliness shatter the citadel of extravagant consumerism and introduce an era where fashion meets sustainability.\n\nIn essence, a capsule wardrobe encourages mindful purchasing. It necessitates buying high-quality, long-lasting items over short-lived, fast-fashion trends. This paradigm shift not only proves beneficial for the individual by reducing clutter, and saving time, and money, but it also commendably contributes towards reducing environmental impact. Embracing a capsule wardrobe is not just a trendy term or a passing fad, it’s a lifestyle change that can significantly boost our personal efficiency, but also has substantial benefits for the environment on a larger scale. Transitioning to a capsule wardrobe may be seen as daunting, but it’s a sustainable and stylish move that holds immense potential in the long run.</p>\n\n','/images/capsule-wardrobe.jpg','Capsule Wardrobes | Simplifying Your Style For A Sustainable Closet'),(11,'Responsible Fashion','<p class=\"highlight\"Understand the hidden costs of fast fashion and its impact on the environment and society.<p><p class=\"highlight\"Fast fashion has a big impact on the environment because it creates a lot of waste.<p><p> When clothes are made quickly and cheaply, they use up a ton of water, release harmful chemicals, and contribute to greenhouse gas emissions. But we can make better choices when shopping by picking clothes from brands that care about the planet. Look for companies that use eco-friendly materials like organic cotton or recycled polyester.\n</p>\n<p class=\"highlight\" Think about what happens to your clothes after you buy them.</p> <p>Fast fashion items are often only meant to be worn a few times before being thrown away, which fills up landfills fast. Instead of buying lots of trendy pieces, consider getting classic wardrobe staples from ethical brands or swapping clothes with friends. Shopping second-hand not only helps reduce waste but also supports an economy where resources are reused rather than wasted.\n</p>\n\n<p>It’s important to learn more about how fast fashion affects people and the environment so we can make smarter decisions as consumers. By understanding the working conditions in clothing factories worldwide and speaking out for fair wages and safe working conditions, we can help bring positive changes to the industry. When our values align with our shopping habits, we become champions for sustainability in fashion.</p>\n\n<p>Changing how we shop isn’t just something individuals do—it’s everyone’s responsibility together! Supporting efforts that promote clear supply chains and encourage companies to adopt sustainable practices will push for bigger changes in making the fashion industry more ethical and environmentally friendly all around the world.</p>','/images/fast-fashion-costs.jpg','The Impact Of Fast Fashion | Understanding The Costs Of Mass Production'),(12,'Responsible Fashion','<p class=\"highlight\"Join the Fashion Revolution movement to advocate for transparency and ethical practices in the industry.</p><p class=\"highlight\"Understanding the Need for Change in the Clothing Industry\n</p><p>For sure, the fashion industry has always made us look our best. It fills our closets with items that reflect individual style, make a statement, or just butter us up. But there’s more to that pretty dress or suave blazer than meets the eye. There’s a hidden side to the clothing industry that may not be so attractive, and it involves the not-so-fashionable practices in production, exploitation of workers, pollution, and waste.\n\nOne could argue the basis for the need for change in this industry is rooted in its current operational model. Fast fashion, which involves copying fashion designs and trends and mass-producing them at a low cost, fuels extreme consumption rates. This approach, as fabulous as it seems for our wallets, comes with high environmental and social costs. \n\nThe rapid production translates to low wages for workers, unsafe working conditions, the use of harmful chemicals, a high rate of water exploitation, and climate-changing emissions. This business-as-usual can’t carry on forever. To secure a sustainable future, we need to revolutionize the clothing industry and the change starts with understanding it.</p>\n\n<p class=\"highlight\"The Power of Consumers in Pushing for Ethical Changes\n</p><p>We live in an era where consumers hold an immense amount of power. Our shopping decisions can spark immense changes, and it’s incredibly important now, more than ever, to know just how strong this power really is. Traditionally, manufacturers held the reins, they set prices and controlled supplies. Customers didn’t have much of a say and were generally bound by the industry. Flash forward to today and the tables have started to turn.\n\nIt all begins with opening our eyes to the ethical issues that are prevalent in the fashion industry. Once we’re aware, we start making conscious choices, choosing brands that align with our values. It could be supporting sustainable practices, or backing up brands with fair trade policies. Together, these small decisions pack a punch. Brands start to take notice when they see changes in their revenue. That’s when they start to reassess their ethical practices and consider making changes for the better. Yes, that’s how powerful we, as consumers, can be!\n</p>\n<p class=\"highlight\"Unveiling the Hidden Processes in the Garment Industry\n</p><p>Often, we don’t spare even a moment to think about the journey our clothes have taken before they end up neatly folded in our wardrobes. This journey is usually long and complex, sourced from myriad corners of the world, passing through countless pairs of hands, and might involve multiple borderline inhumane scenarios. From cotton farms, where pesticides poison the workers, to garment factories, where labor laws barely scrape by, the clothing industry is shrouded in a level of secrecy, hiding unfortunate truths of our everyday wear.\n\nWhat’s more surprising? Estimates state that it takes close to 2700 liters of water just to make a simple cotton t-shirt. This isn’t even adding in the environmental damage from dyes and finishings, the energy consumed to power factories, or the carbon emissions from transportation. Not to forget, this isn’t some high-end luxury item; it’s our basic wardrobe necessity. Yeah, it makes you pause and think, doesn’t it? This chilling truth underlines the extensive and mostly hidden processes in the garment industry that we unknowingly support with our purchases.\n\nHere are some of the hidden processes involved in the garment industry:\n\nCotton Sourcing: The journey of a piece of clothing often starts from cotton farms. These farms, particularly those located in developing countries, use pesticides that have been linked to various health issues among workers.\nTextile Production: Once harvested, the cotton makes its way to textile mills where it is spun into yarn and then woven or knitted into fabric. This process is energy-intensive and contributes significantly to carbon emissions.\nDyeing & Finishing: After being turned into fabric, clothes undergo dyeing and finishing processes which can also be harmful to both the environment and factory workers. Toxic dyes used during these stages may contaminate local water sources.\nGarment Manufacturing: At this stage, labor exploitation becomes a major concern as many factories disregard basic labor laws. Workers often work long hours under poor conditions for low wages without any job security or benefits.\nTransportation & Distribution: Finally, garments are shipped worldwide contributing further to greenhouse gas emissions.\nIt’s crucial that we become more aware of these hidden processes so we can make more informed decisions when buying our clothes. By supporting brands that prioritize ethical sourcing and manufacturing practices, we can help drive positive change within this industry.\n</p>\n<p class=\"highlight\"Promoting Accountability in the Clothing Supply Chain\n</p><p>If we’re going to be honest, there’s something seriously amiss in the fashion world. We don’t mean ill-fitting jeans or clashing prints; the real issue is tucked away behind the shimmering façades of our favorite brands and their supply chains. Right now, truly, it’s less about what you’re wearing and more about who’s making it under what conditions.\n\nMany of us don’t spare a moment to really mull over this and hey, no judgment here, we’re all guilty. However, it’s high time we start taking notice, and more importantly, demand responsibility from brands we adore. This means asking hard questions about where and how our clothes are made, and by whom. It’s about pushing for transparency and ethical practices throughout the clothing supply chain. And trust us, this isn’t just for the sake of a clear conscience. It’s about fashioning an industry that genuinely respects human rights and the environment alike. Now, wouldn’t that be something to strut about?\n\n<p class=\"highlight\"The Importance of Ethical Standards in Manufacturing\n</p><p>We gotta talk about ethics in the manufacturing industry, it’s high time. Here’s the thing: when ethical standards aren’t held high in the manufacturing industry, it leaves a lot of room for things to go wrong. Picture worker exploitation, poor working conditions, even environmental degradation. You see, maintaining a healthy, safe, and fair workspace isn’t just about keeping lawsuits at bay — it’s a fundamental responsibility of every business.\n\nNow, let’s think about the manufacturing realm. It’s often hidden, mysterious, and perhaps even a bit elusive. But let’s break down those walls for a minute and explore reality. It starts with raw materials, swoops into production, dips in distribution, and finally lands in the sale. In each of these stages, ethical standards should play a big part. They are the backbone of securing a just treatment of workers, ensuring fair pricing, and promoting environmental responsibility. A backbone that can’t be ignored, and shouldn’t be compromised. The result? Better products, happier workers, and a healthier planet. You just can’t go wrong with ethical standards folks.\n</p>\n<p class=\"highlight\"Implications of Fast Fashion and its Impact on Workers\n</p><p>Fast fashion is like a sweet that tastes good for a minute but leaves a bad aftertaste when you think about what it’s doing to your body. Or in this case, what it’s doing to the environment and the people making your clothes. Fast fashion means producing clothes at breakneck speeds and selling them at super low prices. But behind the cheap tags are stories untold – stories about exploited workers, poor working conditions and a host of occupational health hazards.\n\nLabor is often outsourced to countries where wages are pitiful, laws are lax and the workplace is anything but safe. It’s not uncommon to find garment workers putting in more than 60 hours a week to assemble clothing for less than minimum wage. They’re working under pressure with no job security, limited breaks and an abundance of hazards like large machinery, harmful dyes, and toxic solvents. It’s grim, to say the least. But as they stitch together that trendy top you found online, it’s their livelihoods unraveling.\n</p>\n<p class=\"highlight\"Sustainable Alternatives to Fast Fashion Practices\n</p><p>So, you’re tired of the relentless cycle of seasonal trends and blink-and-you-miss-it fashion waves, right? You’re not alone! A growing number of consumers and brands are shifting towards more sustainable fashion practices. They look beyond the glitz and glamor of the runway, seeing a colossal carbon footprint and a trail of exploitation and waste. Stepping away from this vortex, many have adopted a more conscious and ethical approach to the way they choose and wear their clothes. This trend involves minimalist wardrobe strategies such as capsule wardrobes, an emphasis on timeless and high-quality garments, and a preference for second-hand or vintage items.\n\nFrom labels prioritizing eco-friendly materials to tech start-ups creating cutting-edge recycling innovations, the fashion world is buzzing with fresh, sustainable ideas. Take, for instance, ethically sourced fabrics like bamboo and hemp that are cropping up more frequently on clothing racks globally. Or innovations like 3D-printed designs and clothes made of recycled polyethylene terephthalate (PET) bottles. You’ve also got companies transforming the very essence of business models, promoting the idea of clothes as a service, via initiatives like rent-a-dress or shirt subscription services. With all these exciting developments, it’s clear that the sustainable revolution in the garment industry is well underway. </p>','/images/fashion-revolution-3.jpg','Fashion Revolution: Advocating for Transparency and Ethical Practices'),(13,'Responsible Fashion','Revive old garments through upcycling and thrifting for a greener, more sustainable wardrobe.Introduction to Upcycling and Thrifting: The Trend Reshaping the Fashion Industry\nThe concept and importance of upcycling in the context of sustainable fashion are essential in today’s environmental landscape, where the fashion industry significantly impacts the environment. Upcycling clothes involves transforming old or discarded garments into new fashion items, allowing brands, designers, and consumers to reuse old garments instead of adding to the growing textile waste in landfills. This approach not only reduces waste but also curbs the demand for new clothing production, thus minimizing the overall environmental impact of the fashion industry. By giving new life to old clothing, upcycling aligns with the principles of slow and circular fashion, indicating a sustainable and ethical approach that is gaining traction in the fashion world.\n\nThe upcycled fashion trend aligns with the global shift towards sustainability. Fashion practices are evolving, with more designers incorporating sustainable materials and reducing reliance on fast fashion. Upcycling techniques can transform an old pair of jeans into a trendy bag or an old t-shirt into a stylish tote, showcasing the potential to extend the life of garments.\n\nHere’s how fashion embraces sustainability:\n\nThrift stores are gaining popularity for donating or buying second-hand clothes, promoting a culture of reuse and repurposing.\nDesigners are reimagining collections using sustainable materials and integrating upcycled clothes\nSustainable fashion communities are emerging, advocating for greener wardrobes and supporting eco-conscious brands.\nEducating new fashion designers on sustainability and upcycling is becoming prevalent, shaping a new wave of ethical fashion that diminishes new product demand and fosters a circular approach within the supply chain. Upcycling is more than a fashion trend; it’s a step towards a sustainable and greener future.\n\nUnderstanding Sustainable Fashion: Upcycling Clothes for a Greener Wardrobe\nUnderstanding the concept and importance of upcycling in the context of sustainable fashion is essential in the current scenario, where the environmental footprint of the fashion industry is of critical concern. The practice of upcycling clothes involves transforming old or discarded pieces of clothing into new fashion items, allowing fashion brands, designers, and even consumers to tap into the potential of old garments instead of contributing to the increasing textile waste that ends up in landfills. By adopting this approach to fashion, we not only reduce waste but also reduce the demand for new clothes, which in turn minimizes the overall environmental impact of the fashion industry. Giving new life to an old piece of clothing resonates with the principles of both slow fashion and circular fashion, reflecting a sustainable and ethical fashion approach that is gaining momentum within the fashion industry.\n\nThe trend of upcycled fashion is in line with the growing global shift towards a more sustainable future. Fashion practices are evolving as more and more fashion houses are recognizing the importance of sustainable materials and reducing their reliance on fast fashion consumption which has long held sway over the fashion landscape. It’s exciting to witness how upcycling techniques can transform an old pair of jeans into a trendy bag, or an old t-shirt into a stylish tote, demonstrating the possibilities that lie within extending the life of any garment.\n\nHere’s how fashion is embracing sustainable practices:\n\nThrift stores are becoming popular places to donate or purchase second-hand clothes, nurturing the culture of reusing and repurposing old clothes.\nFashion designers are reimagining their collections by incorporating sustainable materials and weaving elements of upcycled clothes into their designs.\nSustainable fashion communities are sprouting everywhere, advocating for a greener wardrobe and supporting sustainable fashion brands that take a stand against the adverse impact of fashion on our environment.\nThe importance of upcycling and the role of sustainability in fashion is also emphasized in the education of new fashion designers, with many institutions incorporating sustainability and upcycling into their curriculums. This permeates the new wave of ethical fashion that reduces the demand for new products and promotes a circular approach within the fashion supply chain. The concept of upcycling reflects the larger movement toward sustainable fashion, offering a viable and eco-friendly solution for clothing waste. The world of fashion is recognizing upcycling’s impact and the essential role it plays in fostering an environment-friendly fashion industry. This fresh perspective towards upcycling clothes is not only an emerging fashion trend but a step towards a sustainable and greener future.\n\nThrifting and Upcycling: Innovative Ways to Battle Fast Fashion\nIn the growing world of sustainable fashion, thrifting and upcycling are paving the way as innovative strategies to counter the adverse effects of fast fashion. This new trend stems from the fashion sustainability movement that views the future of fashion through a lens of conscientious consumption and minimal waste. At the heart of this movement is upcycling; the process of transforming old or damaged clothes into new, wearable items. Embracing sustainable fashion consists of several practices such as repurposing old clothes to create a sustainable wardrobe. Key elements of a successful upcycling project include:\n\nSourcing materials from your local thrift store or your own wardrobe\nCombining different pieces to create new clothes and accessories\nBreathing new life into an old t-shirt by transforming it into a tote bag\nThe upcycling fashion movement is gaining ground within the fashion industry, confronting the widely acknowledged issue of the environmental footprint of fashion. The act of giving new life to old clothes demonstrates how upcycling promotes a circular economy where clothes can be recycled, reused, and re-loved. Upcycling not only reduces the volume of discarded materials and waste, but it also diminishes the need for the production of new materials.\n\nMoreover, upcycling is becoming more than just a hobby. Passionate fashion enthusiasts are transforming it into a viable business model, contributing to the sustainable fashion industry. Upcycling is something that everyone – from a new trend follower to a fashion entrepreneur – can participate in with minimal resources. It’s not just about owning a lot of clothes; it’s about what you do with them. If you’re passionate about sustainable fashion, upcycling is likely a practice already on your radar. It’s more than just a part of the fashion movement, it’s about shaping the future for a more sustainable world. \n\nTo sum up, the advantages of upcycling in fashion include:\n\nReducing waste and promoting a circular economy\nExtending the life of clothes by transforming them into valuable pieces\nMaking the fashion industry more sustainable by reducing its environmental impact\nThrough thrifting and upcycling, anyone can join the sustainable fashion movement and bring healthy and much-needed changes to the global fashion industry.\n\nBenefits of Upcycling: Elevating the Sustainability in the Fashion Industry and Personal Wardrobes\nWith the fashion industry becoming ever more expansive, sustainability has been an increasingly central topic of discussion. A primary solution to reduce the industry’s environmental footprint is upcycling, whereby old clothes are transformed into new, trendy pieces. Upcycling, a process that encapsulates ingenuity and innovation, empowers individuals and businesses alike to breathe new life into old garments. These repurposed clothes and accessories often retain their high quality and unique charm, making upcycling a tool for not only promoting sustainability but also for maintaining style.\n\nThe benefits of upcycling are manifold, enriching both the fashion industry and personal wardrobes:\n\nUpcycling old clothes allows for a reduction in waste and prevents unnecessary production of new garments. Instead of discarding a faded old t-shirt, for example, you can rejuvenate it into a practical tote.\nIn contrast to recycling, wherein materials are broken down, upcycling preserves the inherent quality and value of materials. This process of ‘upcycling vs’, or rather, ‘upcycling over’ recycling, retains the integrity and lifespan of the material.\nThe diverse range of projects that upcycling provides fosters creativity and innovation. Existing designs can be metamorphosed into new pieces, transforming the mundane into the extraordinary.\nUpcycling promotes conscious consumption, encouraging consumers to value their purchases and consider their environmental impact. In this way, fashion is growing more ethical, weaving sustainability into its core ethos.\nTherefore, when upcycling becomes more widely adopted and understood, the industry can expect to see a more responsible fashion culture, one enriched by extending the life of clothes. This progressive movement stands as a testament that style, creativity, and sustainability can, indeed, coexist harmoniously.\n\nFurthermore, it paves the way for more sophisticated practices of resource utilization, mirroring a culture that not only values aesthetics but also respects and cherishes the environment. Upcycling in the fashion industry and in personal wardrobes acts as a beacon of responsible innovation, demonstrating that sustainable practices can lead to a wide range of stylish, unique, and environmentally friendly clothing options.\n\nMoreover, upcycling in fashion paves the way for a circular economy, where the lifecycle of materials is extended, reducing the need for new resources and minimizing the impact on the planet. This shift towards a more circular model in the fashion industry is vital in the fight against climate change and resource depletion. It encourages designers, manufacturers, and consumers to think differently about clothing, viewing garments not as disposable items but as valuable resources that can be reinvented and reused.\n\nIn essence, the benefits of upcycling in fashion extend beyond environmental sustainability. They encompass economic advantages, as upcycling can create new market opportunities and jobs. They also promote social sustainability, as upcycling initiatives can support community projects and local artisans. As the fashion industry continues to embrace upcycling, it steps closer to a future where fashion is not only beautiful and stylish but also responsible, ethical, and sustainable.\n\nConclusion\nUpcycling is the process of transforming old materials into useful products, enhancing their value and aesthetics. This sustainable practice played an elemental role in various projects and upcycling activities. Among these projects was upcycling old clothes, a notable practice that involved turning old clothes into new, fashionable items. This not only minimized waste but also created exceptional fashion by extending the life of previously discarded garments.\n\nA standout example was transforming an old t-shirt into a tote, a practice that demonstrated the innovative and practical uses upcycling can offer. Upcycle clothes contribute significantly to environmental conservation, as they reduce the need for new resources and curtail the disposal of usable materials. In the process, upcycled old clothes sparked a new trend that meshed sustainability with fashion and practicality.\n\nA comparison such as upcycling vs conventional waste management vividly underscores the benefits of upcycling. Materials that would have ended up in landfills find a new life, promoting sustainable growth and responsible consumption. Therefore, active participation in upcycle activities such as the conversion of an old t-shirt into a tote not only showcased creativity but also the potential that used items, undeniably used for upcycling, hold in contributing to a more sustainable future.','/images/upcycling-thrifting.jpg','Upcycling And Thrifting | Reviving Old Garments For A Greener Wardrobe'),(14,'Responsible Fashion','<p class=\"highlight\">Explore the role of vegan fashion in creating cruelty-free clothing and accessories.</p><p class=\"highlight\">Introduction to Vegan Fashion\n</p>Vegan fashion is a rapidly growing trend in the fashion industry that aims to promote cruelty-free and sustainable practices. Weaving together innovation and compassion, vegan fashion seeks to disrupt the traditional fashion industry by creating high-quality alternatives to harmful animal products. The concept revolves around the use of plant-based, recyclable materials such as bamboo, hemp, organic cotton, linen, and others to craft stylish, eco-friendly apparel. Precisely, vegan fashion means creating clothing and accessories without exploiting animals, embracing the vegan lifestyle beyond a vegan diet. This innovative fashion statement strongly rejects the cruelty associated with fur farms and animal-derived textiles like angora and mink, challenging the notion of fashion accessories as a by-product of animal harm.\n\nKey players like Stella McCartney, PETA-approved vegan brands, and many fashion brands are leading the charge in the vegan fashion world. These change-makers not just focus on avoiding animal cruelty but also commit to reducing the environmental impact of their supply chain. They incorporate vegan leather, made using a variety of sustainable alternatives to real leather such as cork and recycled plastic, into their products. Their collections comprise vegan shoes, vegan bags, and an array of vegan fashion items, all made with a keen eye for style and ethically sourced vegan materials. Fashion brands are going one step further in demonstrating commitment to animal welfare by ensuring their products are not tested on animals, thereby delivering a truly vegan-friendly experience for consumers. With this commitment, they are acknowledging the importance of integrating environmental and animal rights concerns into their business models.\n\nIndeed, transitioning to a vegan-based model requires a redefinition of fast fashion norms. It values slow fashion and emphasizes less harmful production processes with a lower carbon footprint. This includes the use of less water, fewer toxic chemicals, and more renewable resources. The use of vegan fabrics like faux leather and synthetic materials, when done sustainably, can drastically reduce the industry’s greenhouse gas emissions. Furthermore, vegan fashion supports the recycling paradigm: the use of recycled materials, such as recycled polyester made from recycled plastic bottles, in creating fashion items is essential as we move towards more sustainable practices. This opens avenues to create environmentally friendly and biodegradable products, which can be stylish and have less environmental harm.\n\nIn essence, with vegan fashion, we can make a definitive statement – the future of fashion does not lie in animal-original materials but in cruelty-free clothing. With an upswing in awareness, the day isn’t far when wearing vegan products will be as natural as choosing to follow a vegan diet. Decidedly, vegan fashion is more than just a trend – it’s a movement. Therefore, the next time you’re looking to buy vegan, remember you’re directly contributing to animal rights, a decrease in the meat industry’s damage, and a healthier Earth. Always remember:\n\n<p class=\"highlight\">Choose vegan for a sustainable fashion future.\n</p>Look at vegan alternatives for all your fashion needs.\nUnderstand what vegan fashion means – know the products and the materials used.\nMake a fashion statement that aligns with animal welfare and environmental consciousness.\nAlways strive to buy from brands that support slow fashion and sustainable practices, such as those sourcing ethically and using recycled materials.\nEmbrace a lifestyle that reduces harm and promotes a cruelty-free, respectful co-existence with all earth’s inhabitants.\n<p class=\"highlight\">Understanding Cruelty in the Fashion Industry: Animal Materials Exploitation\n</p>Understanding cruelty in the fashion industry, particularly the exploitation of animals for materials, is an issue that has been gaining traction in recent years, propelled largely by increased social consciousness and activism. Evidence has relentlessly highlighted the harsh realities of the leather industry, where animals are often subjected to inhumane treatment. Major clothing brands have come under scrutiny for their association with such practices. For instance, the production of a single handbag or coat can involve distressing and ultimately lethal harm to wild animals like foxes and chinchillas. Fur, leather, wool, and silk are frequently seen as materials used in fashion items, with production often impacting the welfare of animals directly.\n\nWith growing awareness, driven by organizations such as PETA, consumers are encouraged to make ethical choices that do not encourage or support any form of animal cruelty. A rising trend in ethical fashion is the use of high-quality vegan materials. The best vegan brands like ‘Matt and Nat’ and ‘Stella McCartney’ are at the forefront of this movement, offering alternative options that do not contain any animal materials or are made with animal cruelty. For instance, instead of traditional silk, which requires the boiling of silkworms in their cocoon, these brands opt for peace silk, collected after the moth has naturally emerged. Similarly, artificial leather and fur are used as viable alternatives. The drive for ethical consumption has become a counter-narrative to the non-vegan practices that have dominated fashion, offering hope for a more sustainable industry that respects animal life, and reducing ties between the fashion and meat industry.\n\n<p class=\"highlight\">The Materials Behind Vegan Clothing: Vegan Leather, Fabric, and Alternatives\n</p>Vegan clothing has significantly gained traction in the fashion industry, with many clothing brands making a conscious shift toward high-quality vegan fabric materials and alternatives. At the forefront of these vegan materials is vegan leather, offering a sustainable and cruelty-free alternative to the traditional leather industry. Vegan leather, while mimicking the luxurious look of genuine leather, is not made with animal origin. Instead, it’s derived mostly from interesting and innovative sources like fruit waste, recycled plastic, and cork. This allows fashion brands to engage in ethical practices without compromising on the appeal of their products, be it a stylish handbag or a sophisticated pair of boots.\n\nWhile PETA and other animal rights groups continually challenge designers to explore and experiment with vegan textiles, the fashion community is also learning to embrace unique alternatives to non-vegan fabrics. Many brands like the best vegan fashion houses have found success with materials derived from a variety of surprising sources. These include:\n\nPiñatex, derived from the leftovers of pineapple harvests,\nMuSkin, a type of mushroom that feels like suede,\nVegea, made from the waste products of wine,\nTencel, which is created from the wood pulp of trees,\nECONYL®, a fiber made from regenerated nylon.\nAll of these materials, besides being sustainable, do not harm or contain any animal products or by-products, straying away from practices that harm wild animals such as foxes, chinchillas, or insects (in case of silk cocoon production). This move towards vegan clothing not only signals a response to the meat industry’s ethical objections but also marks a significant step toward environmental sustainability in fashion.\n\n<p class=\"highlight\">Sustainable Fashion and the Role of Veganism\n</p>Sustainable fashion is a significant segment of the broader trend towards sustainability, with the central understanding of minimizing the fashion industry’s impact on the environment and society. One critical move in this direction involves the growing role of veganism in this space. A shift from conventional materials to sustainable alternatives, particularly embracing those that in no way contain any animal components, is evident. This ties in directly with the ethos of veganism, with a lifestyle extending beyond not consuming meat in the harsh meat industry and infiltrating into our broader consumer habits, such as the clothing brands we patronize. Foremost among these changes is the move away from the leather industry, once seen as a pinnacle of luxury, especially for items such as the coveted handbag.\n\nHowever, an increasing number of people, brands like PETA, and consumers are choosing high-quality vegan alternatives that carry the twin advantages of style and sustainability. There is a growing acceptance of the best vegan materials that ideally replace non-vegan components such as fox, cocoon, and chinchilla derivatives used in clothing and accessories. The materials used, free from offenses against wild animals, are made with animal rights and environmental protection in mind. These alternatives are not just ethical, but futuristic in that they align with the planet’s needs, enhancing their desirability in the market.\n\n<p class=\"highlight\">Prominent Vegan Fashion Brands: Stella McCartney, Vegan Brands Spotlight \n</p><p>Stella McCartney is indeed one of the most notable vegan fashion brands on the global platform. Carving out a niche in high-quality vegan wear, McCartney’s name has become synonymous with a conscious shift away from the leather industry and a commitment towards ethical fashion alternatives. PETA has also applauded its approach, reinforcing its worth in the growing vegan fashion market. Stella McCartney’s range includes everything, from chic chinchilla-free coats to faux fox furs and even stylish non-leather handbags, all produced without compromising the welfare of wild animals. Her brands, in many ways, mirror the lifecycle of a cocoon, exhibiting an organic transition from creature-centered fashion to a nature-conscious alternative.</p>\n\n<p>In the spotlight, vegetarian brand Stella McCartney stands exemplary, but there are also other brands like her pushing the envelope of vegan fashion. Delving deeper reveals a trove of the best vegan clothing brands – all offering a unique take on fashion without causing harm to any animals. These brands reject the idea of garments made with animal skins, fur, or feathers, and instead favor materials that do not contain any animal-derived content. By swapping out traditional materials used in the clothing industry with eco-friendly ones, these brands are not only changing the face of fashion but also making a considerable impact on reducing the strain on our environment. Their move is more than just a statement against the meat industry; it is a bold call urging everyone to consider clothing choices that better align with their ethical values.\n\nChoosing Vegan: How to Buy Vegan Apparel, Cruelty-Free Clothing, and Sustainable Alternatives\nThe journey to choosing veganism is not only limited to food consumption but extends into other facets of everyday life, including the clothing and apparel choices one makes. Opting for vegan apparel is a deliberate step towards conscious and ethical living – a stand against animal cruelty and a commitment to sustainable alternatives. Vegan apparel and cruelty-free clothing brands do not use materials derived from animals, they are PETA-endorsed, ensuring that the items you select do not contain any animal ingredients nor are tested on animals. For instance, vegan handbags would not use leather, a product of the cruel leather industry but would opt for high-quality vegan alternatives, designed to offer the same look, feel, and durability without harm.</p>\n\n<p>This lifestyle pivot may seem daunting, especially to non-vegan individuals who are accustomed to materials made with animal products. However, the choice becomes easier as there is an increasing number of brands like Stella McCartney and Miomojo, offering stylish clothing and accessories without the use of animal products. Every item is created without directly impacting wild animals or contributing to the exploitative meat industry. Brands use alternative materials instead of fur from foxes, chinchillas, or other animals. Materials like Piñatex, derived from pineapple leaf fibers, serve as a sustainable alternative to leather. The silkworm’s cocoon is not exploited for silk production but replaced by organic, plant-based materials.</p>\n\n<p>By choosing the best vegan clothing brands, you endorse a compassionate fashion statement, contributing to the reduction of environmental impact and animal exploitation. In addition to Piñatex, materials such as organic cotton, recycled polyester, and Tencel are often used in vegan apparel, offering high-quality and eco-friendly options. These sustainable alternatives not only protect animals but also promote the welfare of our planet by reducing waste and toxic emissions. As a consumer, choosing vegan apparel means embracing a lifestyle that values ethical consumption and environmental responsibility, demonstrating that fashion can be both stylish and humane.\n</p>\n<p class=\"highlight\">Conclusion\n</p><p>In our pursuit of ethical consumption, several clothing brands have established their name by prioritizing high-quality vegan alternatives to conventional fashion staples such as leather handbags. These brands, like PETA-approved best vegan labels, utilize materials that do not contain any animal products nor are made with animal substances, challenging the traditional norms of the leather industry and the meat industry. For instance, innovators include materials derived from seashells, recycled plastic, and even silkworm cocoons, showcasing creativity and responsibility towards the environment and wild animals. These implementations also undeniably affect species like the fox and chinchilla, whose populations have been exploited in the name of non-vegan consumerism.\n</p>\n<p>Ultimately, the rise of vegan clothing brands signifies a significant shift in consumer attitudes towards more humane alternatives, leading to a decrease in products that harm or exploit animals, while also pushing for sustainable and cruelty-free alternatives. It indicates a massive stride towards compassion, not only towards domesticated animals but also wild ones. Final word, thanks to these brands’ commitment, alongside PETA, customers who prioritize ethics have plenty of top-quality options that are free from animal cruelty and uphold the standards of fashion. Now, it’s possible to adorn your outfit with a stylish handbag without worrying about the loss of life it may have triggered. High-quality vegan brands are changing the industry one chic, ethically-produced product at a time.\n</p>\n','/images/vegan-fashion.jpg','The Role Of Vegan Fashion | Cruelty-Free Clothing And Accessories');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article_garden`
--

DROP TABLE IF EXISTS `article_garden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article_garden` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` text,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK5orawf4hhc14m2cr56fxysye6` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article_garden`
--

LOCK TABLES `article_garden` WRITE;
/*!40000 ALTER TABLE `article_garden` DISABLE KEYS */;
INSERT INTO `article_garden` VALUES (1,'Starting an urban garden on your balcony is easy and accessible for everyone. First, choose a sunny spot that gets at least 6 hours of light daily. Use pots or old buckets to plant vegetables like tomatoes and lettuce. Add compost from kitchen scraps for natural fertilizer. Water regularly but avoid overwatering to prevent root damage. Vertical racks can expand space for more plants. Opt for compact varieties suited for small spaces. Balcony gardening not only provides fresh produce but also enhances your home’s aesthetics. It reduces stress and connects you with nature. With a bit of creativity, your balcony can become a green oasis.','How to Start an Urban Garden on Your Balcony'),(2,'Vertical gardens are an ideal solution for urban dwellers with limited space. They utilize walls or trellises to grow plants upward. This technique is perfect for herbs, strawberries, or decorative flowers. You can use old wooden pallets or PVC pipes as a base. Install a drip irrigation system to simplify watering. Vertical gardens improve air quality and reduce noise in the city. They also add beauty to gray urban walls. Ensure you use sturdy structures to support the plants’ weight. Regularly check for pests and keep plants healthy. This method is sustainable and easy to maintain.','Vertical Gardens: A Solution for Small Spaces'),(3,'Composting in an urban setting is a simple way to reduce waste and enrich your garden. Collect kitchen scraps like vegetable peels, coffee grounds, and eggshells. Use a small composter suitable for apartments or make one from a bucket. Add dry leaves or paper to balance moisture. Stir the mixture every few days to speed up decomposition. After 2–3 months, you’ll have rich compost for your plants. This process reduces landfill waste and saves money on fertilizers. It also teaches responsible resource management. Composting is a small step toward a more sustainable lifestyle. Start today and see the difference!','Composting in the City: How to Do It Easily'),(4,'Hydroponics is an innovative technique for urban gardening without soil. Plants grow in a nutrient solution that provides all necessary elements. This system is ideal for small spaces like kitchens or balconies. You can grow lettuce, spinach, or herbs with minimal effort. Hydroponics saves up to 90% of water compared to traditional gardening. It also speeds up plant growth by up to 30%. Start with a simple hydroponic system or build your own using PVC pipes. Maintain a balance of nutrients in the solution. Regularly check the water’s pH level. Hydroponics is the future of sustainable urban agriculture.','Hydroponics for Urban Gardeners'),(5,'Growing herbs in an apartment is an easy way to add freshness to your meals. Basil, mint, and thyme are great for beginners as they grow quickly. Place pots on a windowsill with plenty of sunlight. Water regularly but avoid overwatering to prevent root rot. Use well-drained soil and add compost for better growth. Herbs not only enhance food flavor but also freshen indoor air. They’re easy to maintain and don’t require much space. You can repurpose old jars or cans as pots. This is an eco-friendly way to have fresh spices year-round. Start small and you’ll fall in love with gardening!','Growing Herbs in an Apartment'),(6,'Urban gardens play a vital role in bringing communities together. They unite people of all ages who share knowledge and resources. Collaborative gardening fosters social bonds and reduces isolation. Community gardens often host workshops on sustainable farming. They provide fresh produce to low-income families, improving access to healthy food. Gardens also teach children responsibility and respect for nature. They reduce crime in neighborhoods by creating safe green spaces. Moreover, they attract pollinators, supporting the local ecosystem. Urban gardens are places for learning, sharing, and growth. Join a local garden and be part of the change!','The Benefits of Urban Gardens for Communities'),(7,'Attracting bees to your urban garden is essential for pollination and biodiversity. Plant flowers like lavender, sunflowers, and basil that attract bees. Avoid using pesticides that harm pollinators. Leave shallow water with pebbles for bees to drink. Build small ‘bee hotels’ from bamboo or wood for shelter. A variety of plants ensures food throughout the season. Bees help increase yields of fruits and vegetables. They also support the local ecosystem in urban areas. Working with bees teaches patience and respect for nature. With small actions, we can make our gardens a haven for pollinators.','How to Attract Bees to Your Urban Garden'),(8,'Recycling water is key to sustainable urban gardening. Collect rainwater in barrels or buckets placed under gutters. Use water from rinsing vegetables to irrigate plants. Install a drip irrigation system to conserve water. Filter household gray water for reuse in the garden. This practice reduces water usage and lowers bills. It also eases the burden on city sewage systems. Avoid using water with chemicals that could harm plants. Recycling water is an easy way to be more eco-friendly. Start today and see how much water you can save!','Recycling Water for Urban Gardens'),(9,'Seasonal gardening in the city is a great way to make the most of the climate. Spring is perfect for planting lettuce, spinach, and radishes. In summer, grow tomatoes, cucumbers, and peppers that thrive in heat. Fall is ideal for root vegetables like carrots and beets. Winter can be used for indoor herbs. Planning by season increases yield and reduces the need for chemicals. Use a planting calendar to track the best times. It also teaches you to live in harmony with natural cycles. Seasonal gardening brings joy and fresh produce year-round. Try it and enjoy the results!','Seasonal Gardening in the City');
/*!40000 ALTER TABLE `article_garden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_post`
--

DROP TABLE IF EXISTS `blog_post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_post`
--

LOCK TABLES `blog_post` WRITE;
/*!40000 ALTER TABLE `blog_post` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart_item`
--

DROP TABLE IF EXISTS `cart_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `product_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqkqmvkmbtiaqn2nfqf25ymfs2` (`product_id`),
  KEY `FKka3t831w0aw2vrwgsbhcn5y4m` (`user_id`),
  CONSTRAINT `FKka3t831w0aw2vrwgsbhcn5y4m` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKqkqmvkmbtiaqn2nfqf25ymfs2` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart_item`
--

LOCK TABLES `cart_item` WRITE;
/*!40000 ALTER TABLE `cart_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(255) NOT NULL,
  `content` text,
  `created_at` datetime(6) NOT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `post_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh4c7lvsc298whoyd4w9ta25cr` (`post_id`),
  CONSTRAINT `FKh4c7lvsc298whoyd4w9ta25cr` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contact_messages`
--

DROP TABLE IF EXISTS `contact_messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contact_messages` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `email` varchar(255) NOT NULL,
  `message` text NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_messages`
--

LOCK TABLES `contact_messages` WRITE;
/*!40000 ALTER TABLE `contact_messages` DISABLE KEYS */;
INSERT INTO `contact_messages` VALUES (1,'2025-04-23 06:32:35.618432','alexcheto2013@abv.bg','Garden make papaya','Plamen Kamenov'),(2,'2025-04-23 07:02:27.386522','alexcheto2013@abv.bg','Nice','Plamen Kamenov'),(3,'2025-04-23 07:12:49.854701','alexcheto2013@abv.bg','Fuck off','Plamen Kamenov'),(4,'2025-04-23 07:14:29.902093','alexcheto2013@abv.bg','Miles','Plamen Kamenov'),(5,'2025-04-23 07:19:03.500512','alexcheto2013@abv.bg','please','Plamen Kamenov'),(6,'2025-04-23 07:22:32.646326','alexcheto2013@abv.bg','goo goo guyes','Plamen Kamenov'),(7,'2025-04-23 07:26:16.866551','alexcheto2013@abv.bg','fine ooo','Plamen Kamenov'),(8,'2025-04-23 12:13:10.155330','alexcheto2013@abv.bg','go goo mo','Plamen Kamenov'),(9,'2025-04-23 12:23:01.496273','alexcheto2013@abv.bg','maked pls\r\n','Plamen Kamenov'),(10,'2025-04-23 12:24:32.451436','alexcheto2013@abv.bg','gooooooooooooooo','Plamen Kamenov'),(11,'2025-04-23 12:25:22.796607','alexcheto2013@abv.bmk','mkiooooooooooooooooo','Plamen Kamenov'),(12,'2025-04-23 12:26:35.655709','alexcheto2013@abv.bg','mioooooo','Plamen Kamenov'),(13,'2025-04-23 12:31:49.254737','alexcheto2013@abv.bg','miuiiiiii','Plamen Kamenov'),(14,'2025-04-23 12:37:44.942901','alexcheto2013@abv.bg','viral noiuuooiwiorjojftoieqjriqejroiqjroijqw','Plamen Kamenov'),(15,'2025-04-23 12:42:13.294149','alexcheto2013@abv.bg','maked pls go','Plamen Kamenov'),(16,'2025-04-23 12:45:49.175055','alexcheto2013@abv.bg','фуцк гоо мъ бро','Plamen Kamenov'),(17,'2025-04-23 12:53:20.425937','alexcheto2013@abv.bg','jiuuruurturuturt','Plamen K'),(18,'2025-04-23 13:21:15.418970','alexcheto2013@abv.bg','maked','Plamen Kamenov'),(19,'2025-04-23 13:26:14.422466','alexcheto2013@abv.bg','maked','Plamen Kamenov'),(20,'2025-04-23 13:26:24.910734','alexcheto2013@abv.bg','maked','Plamen Kamenov'),(21,'2025-04-23 13:26:39.307819','alexcheto2013@abv.bg','maked','Plamen Kamenov'),(22,'2025-04-23 13:28:59.969956','alexcheto2013@abv.bg','freeeeeeeeeeeeeeeee','Plamen Kamenov'),(23,'2025-04-23 13:37:25.986384','alexcheto2013@abv.bg','greeeeeeeeee','Plamen Kamenov'),(24,'2025-04-23 13:39:40.232259','alexcheto2013@abv.bg','pppppppppppppppppppppppppppppppppp','Plamen Kamenov'),(25,'2025-04-23 13:41:36.668664','alexcheto2013@abv.bg','kiiiiiiiiiiiiiiiiiiiiiiiii','Plamen Kamenov'),(26,'2025-04-23 13:44:20.625798','alexcheto2013@abv.bg','greeeeeeeeeeeeee','Plamen Kamenov'),(27,'2025-04-23 13:47:56.502712','alexcheto2013@abv.bg','fefsfsf','Plamen Kamenov'),(28,'2025-04-23 13:49:03.442167','alexcheto2013@abv.bg','freeeeeeee','Plamen Kamenov');
/*!40000 ALTER TABLE `contact_messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `daily_visitor_count`
--

DROP TABLE IF EXISTS `daily_visitor_count`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `daily_visitor_count` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `unique_visitors` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKq5dltf9iqow74kmu2v7fcwdem` (`date`),
  KEY `idx_date` (`date`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily_visitor_count`
--

LOCK TABLES `daily_visitor_count` WRITE;
/*!40000 ALTER TABLE `daily_visitor_count` DISABLE KEYS */;
INSERT INTO `daily_visitor_count` VALUES (1,'2025-04-11',2),(2,'2025-04-12',7),(3,'2025-04-14',1),(4,'2025-04-18',1),(5,'2025-04-19',2),(6,'2025-04-23',7),(7,'2025-04-24',7),(8,'2025-04-25',4),(9,'2025-04-28',5),(10,'2025-04-29',6),(11,'2025-04-30',5),(12,'2025-05-02',6),(13,'2025-05-05',10),(14,'2025-05-07',6),(15,'2025-05-08',5),(16,'2025-05-09',4),(17,'2025-05-12',1);
/*!40000 ALTER TABLE `daily_visitor_count` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gardening_tips`
--

DROP TABLE IF EXISTS `gardening_tips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gardening_tips` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gardening_tips`
--

LOCK TABLES `gardening_tips` WRITE;
/*!40000 ALTER TABLE `gardening_tips` DISABLE KEYS */;
/*!40000 ALTER TABLE `gardening_tips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `herbal_remedy`
--

DROP TABLE IF EXISTS `herbal_remedy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `herbal_remedy` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `benefits` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `usage_instructions` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `herbal_remedy`
--

LOCK TABLES `herbal_remedy` WRITE;
/*!40000 ALTER TABLE `herbal_remedy` DISABLE KEYS */;
INSERT INTO `herbal_remedy` VALUES (1,'Reduces stress, promotes sleep, soothes stomach issues.','A soothing herbal tea made from chamomile flowers.','/images/chamomile-tea.jpg','Chamomile Tea','Steep 1-2 teaspoons of dried chamomile in hot water for 5-10 minutes.'),(2,'Relieves headaches, improves digestion, reduces nausea.','An essential oil extracted from peppermint leaves.','/images/peppermint-oil.jpg','Peppermint Oil','Apply diluted oil to temples or inhale for relief.'),(3,'Boosts immune system, fights colds and infections.','A tincture made from the echinacea plant.','/images/echinacea-tincture.jpg','Echinacea Tincture','Take 1-2 droppers full in water daily during cold season.'),(4,'Soothes burns, heals skin irritations, promotes relaxation.','A healing salve made with lavender essential oil.','/images/lavender-salve.jpg','Lavender Salve','Apply a small amount to affected areas as needed.');
/*!40000 ALTER TABLE `herbal_remedy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journey`
--

DROP TABLE IF EXISTS `journey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `journey` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journey`
--

LOCK TABLES `journey` WRITE;
/*!40000 ALTER TABLE `journey` DISABLE KEYS */;
/*!40000 ALTER TABLE `journey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `customer_address` varchar(255) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `recipe_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK3d8p7x0tqs7f0nr55cntv1wui` (`customer_address`),
  UNIQUE KEY `UKpeh3cnly20b3wjggvyr2hvi8j` (`customer_name`),
  KEY `FKmghnocqkn72j5tnotckc3jo60` (`recipe_id`),
  CONSTRAINT `FKmghnocqkn72j5tnotckc3jo60` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_products`
--

DROP TABLE IF EXISTS `orders_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_products` (
  `order_id` bigint NOT NULL,
  `products_id` bigint NOT NULL,
  UNIQUE KEY `UKqmviv5y7625wak8tjq4nirybh` (`products_id`),
  KEY `FKe4y1sseio787e4o5hrml7omt5` (`order_id`),
  CONSTRAINT `FKe4y1sseio787e4o5hrml7omt5` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKqgxvu9mvqx0bv2ew776laoqvv` FOREIGN KEY (`products_id`) REFERENCES `products` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_products`
--

LOCK TABLES `orders_products` WRITE;
/*!40000 ALTER TABLE `orders_products` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passive_houses`
--

DROP TABLE IF EXISTS `passive_houses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passive_houses` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `description` text,
  `image_url` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passive_houses`
--

LOCK TABLES `passive_houses` WRITE;
/*!40000 ALTER TABLE `passive_houses` DISABLE KEYS */;
INSERT INTO `passive_houses` VALUES (1,'Energy Efficiency','Eco-friendly homes are designed to minimize environmental impact through energy efficiency, sustainable materials, and renewable energy sources. Learn the basics of passive house design.','/images/house-5.jpg','Understanding Eco-Friendly Homes: A Comprehensive Guide','https://www.youtube.com/embed/eRBNnfXXF4w'),(2,'Energy Efficiency','Sustainable home design focuses on reducing energy consumption, using natural light, and incorporating eco-friendly materials. Discover key principles to apply in your next project.','/images/home-design.jpg','Principles of Sustainable Home Design for Your Next Home Improvement','https://www.youtube.com/embed/oIddRKVH6H0'),(3,'Energy Efficiency','Building a passive house involves careful planning, from site selection to insulation. Follow these steps to create an energy-efficient home.','/images/passive-house-build.jpg','Building the Passive House: Steps to Achieve an Eco-Friendly House','https://www.youtube.com/embed/passive-house-build-video'),(4,'Solar Power Systems','Solar power systems are a cornerstone of green homes. Learn how to integrate solar panels into your home for sustainable energy.','/images/solar-city-anime.jpeg','An Insight into Green Home: Environmentally Friendly Approaches in House Construction','https://www.youtube.com/embed/Fezmkc9X3eE'),(5,'Solar Power Systems','Solar energy can be used for heating and cooling. Explore advanced techniques to maximize energy efficiency in your eco-home.','/images/solar-city-2.jpeg','Going Beyond the Basics: Insulation, Energy Efficiency, and Ways to Heat and Cool Your Eco-Home','https://www.youtube.com/embed/Bx0aDeru_Xw'),(6,'/images/water-anime.jpg','Rainwater collection systems can significantly reduce water usage. Learn how to implement them in your home.','Water Conservation','Popular Sustainable Living Techniques: Energy Efficient Appliances, Rainwater Collection, and Renewable Energy Use in Homes','https://www.youtube.com/embed/N6wJa4j5dO4'),(7,'Water Conservation','Water-saving fixtures and Energy Star-rated appliances can transform your home into a sustainable haven. Discover the best options.','/images/water-anime-2.jpg','Transition into an Eco-Friendly Building: Make Your Home More Sustainable with Energy Star-rated Appliances and Fixtures','https://www.youtube.com/embed/V9ODb6YAeFc'),(8,'Wind Turbines','Wind turbines can provide renewable energy for prefab homes. Learn how to integrate them into your eco-friendly design.','/images/wind-1.jpg','Making the Smart Choice: Leverage Prefab Homes and Eco-Friendly Building Materials for Reduced Energy Use','https://www.youtube.com/embed/itd5kg7GsfA'),(9,'Wind Turbines','Retrofitting your home with wind turbines and other renewable energy sources can make it more sustainable. Get practical ideas here.','/images/wind-2.jpg','Reconfiguring Existing Homes: Ideas to Transform Your Home into an Energy-Efficient One','https://www.youtube.com/embed/nPvTH7Siclg'),(10,'Wind Turbines','Using natural materials alongside wind energy can create a truly eco-friendly home. Explore the best materials to use.','/images/wind-anime.jpg','Earth-friendly Materials for Friendly Homes: Natural Materials in the Construction of Environmentally Friendly Homes','https://www.youtube.com/embed/Fezmkc9X3eE');
/*!40000 ALTER TABLE `passive_houses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plastic_tips`
--

DROP TABLE IF EXISTS `plastic_tips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plastic_tips` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` text,
  `image_path` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKin2rmgywkcf7t5rm45kmc7un` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=373 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plastic_tips`
--

LOCK TABLES `plastic_tips` WRITE;
/*!40000 ALTER TABLE `plastic_tips` DISABLE KEYS */;
INSERT INTO `plastic_tips` VALUES (370,'Store food in glass or stainless steel containers instead of plastic ones.Using reusable containers is one of the simplest and most impactful ways to reduce everyday waste. Instead of relying on single-use plastic boxes, switching to glass or stainless steel containers offers a safer, more sustainable alternative. These containers are durable, don\'t leach harmful chemicals, and help keep food fresh for longer. They’re perfect for meal prep, leftovers, or carrying lunch to work or school. By reusing containers, we reduce the need for constant packaging production and decrease greenhouse gas emissions. Modern designs make them lightweight, microwave- and dishwasher-safe, and easy to carry. Over time, this switch saves money and supports a zero-waste lifestyle. Choosing reusable options sends a strong message about caring for our planet. You can even get stylish or stackable versions to better organize your fridge or pantry. Pairing reusable containers with cloth bags and metal cutlery creates a fully eco-friendly eating experience. This small lifestyle change can lead to significant environmental benefits. Teaching children to use fun, colorful containers also helps build sustainable habits early. Every container reused is one less piece of plastic polluting nature. Embrace reusability – it’s good for your health, your wallet, and the Earth.','/images/greentips/reusable-container.jpg','Use Reusable Containers'),(371,'Replace liquid soap in plastic bottles with bar soap to reduce waste.Switching to bar soap is a small yet powerful move toward reducing plastic waste. Liquid soap often comes in bulky plastic bottles, many of which are not recycled properly. In contrast, bar soap can be purchased with zero or minimal packaging. It typically lasts longer than liquid soap and uses fewer ingredients and resources to produce. Many bar soaps are made with natural, skin-friendly ingredients like essential oils, herbs, or shea butter. You can find a variety of options to suit every skin type and scent preference. Bar soaps are also great for travel—no liquid restrictions and no risk of spills. Nowadays, even shampoo and conditioner come in solid bar forms. This change reduces clutter in your bathroom and your environmental footprint. By choosing bars over bottles, you directly cut down on plastic waste in landfills and oceans. It\'s a cost-effective, practical step with real ecological benefits. Many eco-conscious brands also offer refillable tins or compostable wrappers. Even small changes like this help normalize sustainability in daily routines. Switching to bar soap isn\'t just a trend—it\'s a smarter, cleaner way forward.','/images/greentips/bar-soap.jpg','Switch to Bar Soap'),(372,'Use beeswax wraps or silicone lids to cover food instead of plastic wrap.Plastic wrap is convenient, but it\'s one of the most wasteful and non-recyclable kitchen products. Every day, millions of households use it once and throw it away—adding to the global plastic crisis. Fortunately, there are much better alternatives. Beeswax wraps, made from organic cotton and beeswax, can be reused dozens of times and molded around food or containers. Silicone stretch lids are flexible, durable, and fit snugly over bowls, jars, or even cut fruits. Glass containers with lids offer the easiest and most effective food storage method without plastic. Avoiding plastic wrap helps protect your health by reducing exposure to microplastics in food. It also prevents pollution in rivers, oceans, and ecosystems. Reusable options are often more cost-effective over time and can be cleaned with just warm water and soap. Adopting plastic-free habits encourages others and contributes to a broader culture of sustainability. Even small changes in your kitchen can lead to a more conscious and responsible lifestyle. Making your kitchen zero-waste is easier than ever with so many stylish and functional alternatives. Choose wisely—your future self and the planet will thank you.','/images/greentips/beeswax-wrap.jpg','Avoid Plastic Wrap');
/*!40000 ALTER TABLE `plastic_tips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `posts` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `author` varchar(255) NOT NULL,
  `content` text,
  `created_at` datetime(6) NOT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `premium_content`
--

DROP TABLE IF EXISTS `premium_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `premium_content` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `thumbnail_path` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `premium_content`
--

LOCK TABLES `premium_content` WRITE;
/*!40000 ALTER TABLE `premium_content` DISABLE KEYS */;
/*!40000 ALTER TABLE `premium_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` text,
  `image_url` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKo61fmio5yukmmiqgnxf8pnavn` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` text,
  `image_url` varchar(255) NOT NULL,
  `ingredients` varchar(255) NOT NULL,
  `instructions` text,
  `title` varchar(255) NOT NULL,
  `video_url` varchar(255) NOT NULL,
  `created_by_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKi7in1pi28xh54d0s0mx0pphhk` (`title`),
  KEY `FKs49scty8q9ctcsmtog06ur95f` (`created_by_id`),
  CONSTRAINT `FKs49scty8q9ctcsmtog06ur95f` FOREIGN KEY (`created_by_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recycling_center`
--

DROP TABLE IF EXISTS `recycling_center`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recycling_center` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKteqwleiw4jk7cmlddrdvp9r2k` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recycling_center`
--

LOCK TABLES `recycling_center` WRITE;
/*!40000 ALTER TABLE `recycling_center` DISABLE KEYS */;
/*!40000 ALTER TABLE `recycling_center` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsible_fashion`
--

DROP TABLE IF EXISTS `responsible_fashion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `responsible_fashion` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `description` text,
  `image_url` varchar(255) NOT NULL,
  `title` varchar(300) NOT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsible_fashion`
--

LOCK TABLES `responsible_fashion` WRITE;
/*!40000 ALTER TABLE `responsible_fashion` DISABLE KEYS */;
INSERT INTO `responsible_fashion` VALUES (1,'Introduction','Ethical fashion is more than a trend — it\'s a movement towards sustainability and responsibility. Learn how to embrace eco-friendly living through your fashion choices.When you think about ethical fashion, the clothes we choose to wear can really make a big difference for our planet. When we pick brands that care about using eco-friendly materials and treating workers fairly, we are making a positive impact on how things are done. It’s important to realize that each item of clothing has its own story – from the fabric it’s made of, to the hands that carefully put it together.\n\nethical fashionIn today’s world where fast fashion is everywhere, going for ethical fashion is like picking quality over quantity; it means investing in style and sustainability at the same time. Choosing classic pieces made from organic cotton, bamboo, or recycled materials not only helps reduce our environmental impact but also supports companies that value fairness and transparency in their work practices. We need to shift our focus from trendy throwaway items to lasting favorites that will stay stylish for years.\n\n\nImagine your closet as a garden full of clothes grown with care for the earth. Just like you nurture your plants with love and attention, choosing sustainable clothing is like planting seeds for a greener future ahead. Each purchase becomes a way to show support for positive change in an industry often marked by unfairness and waste – it’s dressing consciously without giving up on looking good.\n\nLet’s move towards living more sustainably through our choices in ethical fashion – because being fashionable doesn’t mean ignoring how our clothes are produced or what impact they have on nature. Let’s plant seeds of change by backing brands committed to making beautiful apparel while respecting both people and the environment equally. Remember: even small actions can lead to big changes when we all come together with purpose and passion!','/images/fashion.jpg','Introduction: Embracing Ethical Fashion for Eco-friendly Living','https://www.youtube.com/embed/HMwdb1hqCz4'),(2,'Sustainable Brands','Explore brands that prioritize ethical practices and use eco-friendly materials like organic cotton, recycled polyester, and hemp.Sustainable clothing brands are like rare treasures among the abundance of fast fashion options. They focus on ethical practices and eco-friendly materials, leading the way for a more mindful approach to style. By supporting these brands, you’re not just purchasing clothes; you’re championing a movement towards a greener future.\n\nIt’s crucial to delve deeper when exploring sustainable brands. Investigate their transparency in the supply chain, labor practices, and assessments of environmental impact to truly grasp their dedication to sustainability. Remember, it’s not only about what catches your eye at first glance but also about understanding what goes on behind the scenes that holds utmost importance.\n\n\nWhen considering eco-friendly fabrics, think bamboo, organic cotton, hemp, Tencel – materials that not only feel great against your skin but also have a lower impact on our planet. These fabrics are nature’s present wrapped in sustainability – breathable, long-lasting options that decompose naturally and bring joy both to your wardrobe and Mother Earth.\n\nEmbracing sustainable fashion isn’t synonymous with sacrificing style; it is about redefining it with intention and integrity. From sleek minimalist designs to bold statement pieces created thoughtfully with regard for people and the environment – there is something for everyone seeking conscious choices in their closet.\n\nSo next time you go shopping or browse through online stores searching for your next favorite outfit – pause! Take a moment to explore what sustainable clothing brands offer; allow them to narrate stories of craftsmanship blended seamlessly with consciousness into every piece they produce. Your decision today shapes tomorrow’s path towards an environmentally friendly future where style speaks volumes without uttering a word.','/images/sustainable-brands.jpg','Discover Sustainable Clothing Brands: Ethical Practices and Eco-friendly Materials','https://www.youtube.com/embed/E8NXx4IA40U'),(3,'Fast Fashion Impact','Fast fashion has a massive environmental footprint. Understand its impact and learn how to make smarter shopping decisions.Fast fashion has a big impact on the environment because it creates a lot of waste. When clothes are made quickly and cheaply, they use up a ton of water, release harmful chemicals, and contribute to greenhouse gas emissions. But we can make better choices when shopping by picking clothes from brands that care about the planet. Look for companies that use eco-friendly materials like organic cotton or recycled polyester.\n\nThink about what happens to your clothes after you buy them. Fast fashion items are often only meant to be worn a few times before being thrown away, which fills up landfills fast. Instead of buying lots of trendy pieces, consider getting classic wardrobe staples from ethical brands or swapping clothes with friends. Shopping second-hand not only helps reduce waste but also supports an economy where resources are reused rather than wasted.\n\n\nIt’s important to learn more about how fast fashion affects people and the environment so we can make smarter decisions as consumers. By understanding the working conditions in clothing factories worldwide and speaking out for fair wages and safe working conditions, we can help bring positive changes to the industry. When our values align with our shopping habits, we become champions for sustainability in fashion.\n\nChanging how we shop isn’t just something individuals do—it’s everyone’s responsibility together! Supporting efforts that promote clear supply chains and encourage companies to adopt sustainable practices will push for bigger changes in making the fashion industry more ethical and environmentally friendly all around the world.','/images/fast-fashion-costs-2.jpg','The Environmental Impact of Fast Fashion: Making Smarter Shopping Decisions','https://www.youtube.com/embed/fv=H2bxO-PgcT0'),(4,'Practical Tips','Incorporate ethical fashion into your wardrobe with these practical tips, from choosing quality over quantity to supporting local artisans.When you want to include ethical fashion in your everyday wardrobe, start by focusing on quality rather than quantity. Instead of buying into the fast fashion trends, choose well-made and durable pieces that stand the test of time. By investing in high-quality clothing, you not only shop less frequently but also help build a more sustainable closet.\n\n<p><strong>Explore eco-friendly materials like organic cotton, hemp, bamboo, and Tencel when picking out clothes.</strong></p> These fabrics are kinder to the environment and offer superior comfort and breathability. Opt for natural fibers that have been made with minimal impact on our planet’s resources. Selecting sustainable materials is a big step towards reducing your carbon footprint through mindful shopping habits.\n\nMake second-hand shopping part of your style journey by checking out thrift stores, vintage shops, online marketplaces or clothing swaps for unique finds at great prices while supporting circular fashion practices. Giving pre-loved items a new life helps cut down on waste and promotes a more sustainable economy within the fashion world.\n\nLastly – pay attention to transparency when choosing which brands to endorse. Look into companies’ values related to sustainability efforts,fair labor practices,and supply chain transparency before making purchases.Taking the time to learn about where your clothes come from allows you to make informed decisions that match your ethical beliefs while enhancing your daily style choices with purposeful selections','/images/ethical-fashion-tips-2.jpg','Practical Tips for Integrating Ethical Fashion Into Your Daily Style Choices','https://www.youtube.com/embed/v=Y9sGX7DwkaQ'),(5,'Conclusion','<p class=\"highlight\">By choosing ethical fashion, you’re supporting a greener future. </p>Take action today for a more sustainable tomorrow.Choosing eco-friendly clothing is not just a passing fad; it’s part of a bigger movement towards sustainability and responsibility. When you opt for clothes made from organic cotton, hemp, or Tencel, you’re not only cutting down your carbon footprint but also supporting brands that care about the health of our planet. Preferring slow fashion to fast fashion lets us admire the creativity and skill put into each piece while reducing waste in the industry.\n\nIt’s simple to bring ethical fashion into your daily routine – shop at sustainable brands, repurpose old clothes, or swap outfits with friends. Being aware of where and how our clothes are made can help create a more open and fair supply chain. Keep in mind that every little decision we make has an impact on the environment – so why not choose options that match your values and contribute to making the world better for future generations?','/images/ethical-fashion-tips.jpeg','Conclusion: Supporting a Greener Future Through Ethical Fashion','https://www.youtube.com/embed/9mk_92iV9t8&t');
/*!40000 ALTER TABLE `responsible_fashion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `role` enum('ADMIN','USER') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'USER'),(2,'ADMIN');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `section` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `journey_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhbqjsrwlkdktbpwhm49fayf01` (`journey_id`),
  CONSTRAINT `FKhbqjsrwlkdktbpwhm49fayf01` FOREIGN KEY (`journey_id`) REFERENCES `journey` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `section`
--

LOCK TABLES `section` WRITE;
/*!40000 ALTER TABLE `section` DISABLE KEYS */;
/*!40000 ALTER TABLE `section` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscription`
--

DROP TABLE IF EXISTS `subscription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscription` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `stripe_session_id` varchar(255) DEFAULT NULL,
  `subscription_date` datetime(6) DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqwd9pkhbsmapx9poug5wnnpkc` (`user_id`),
  CONSTRAINT `FKqwd9pkhbsmapx9poug5wnnpkc` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscription`
--

LOCK TABLES `subscription` WRITE;
/*!40000 ALTER TABLE `subscription` DISABLE KEYS */;
/*!40000 ALTER TABLE `subscription` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport_tips`
--

DROP TABLE IF EXISTS `transport_tips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transport_tips` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` text,
  `image_path` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK1umof15amak7sab5q1388gyyg` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport_tips`
--

LOCK TABLES `transport_tips` WRITE;
/*!40000 ALTER TABLE `transport_tips` DISABLE KEYS */;
INSERT INTO `transport_tips` VALUES (1,'Combine to reduce the number of car trips.','/images/plan-trips.jpg','Plan Your Trips'),(2,'Cycle to nearby places instead of driving.','/images/bike-short.jpg','Use a Bike for Short Distances'),(3,'Share rides to work or events to cut emissions.','/images/carpool.jpg','Carpool with Friends'),(4,'Choose walking for short distances to reduce emissions.','/images/walk-more.jpg','Walk More Often');
/*!40000 ALTER TABLE `transport_tips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin@example.com','Admin','$2a$10$xy0AKOfzHMdSGkqJ7dum.eAlYgqnX16v4Aj9YIBLZfbU2BZFH.jBu','admin'),(2,'user@example.com','User','$2a$10$IffXpaQ.KidVukY9fsjo5OI8oWkJedY7GvzyghlbvxL8z6OWLJJHG','user'),(3,'alexcheto2013@abv.bg','pakoti mui','$2a$10$.OqiX1ZUqZzCUGHxiCgdleRz7L91BYuGKDjkU/EK0o3rrdwCzwD6y','pako81');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_entity_id` bigint NOT NULL,
  `roles_id` bigint NOT NULL,
  KEY `FKa62j07k5mhgifpp955h37ponj` (`roles_id`),
  KEY `FK7v417qhe0i2m9h8njggvciv00` (`user_entity_id`),
  CONSTRAINT `FK7v417qhe0i2m9h8njggvciv00` FOREIGN KEY (`user_entity_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKa62j07k5mhgifpp955h37ponj` FOREIGN KEY (`roles_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,2),(2,1),(3,1);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video_course`
--

DROP TABLE IF EXISTS `video_course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `video_course` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `video_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video_course`
--

LOCK TABLES `video_course` WRITE;
/*!40000 ALTER TABLE `video_course` DISABLE KEYS */;
/*!40000 ALTER TABLE `video_course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `waste_tips`
--

DROP TABLE IF EXISTS `waste_tips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `waste_tips` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `category` varchar(255) NOT NULL,
  `description` text,
  `priority` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKcgdv08b66lv67p7kxijrsdesc` (`category`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `waste_tips`
--

LOCK TABLES `waste_tips` WRITE;
/*!40000 ALTER TABLE `waste_tips` DISABLE KEYS */;
/*!40000 ALTER TABLE `waste_tips` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-12 10:28:23
