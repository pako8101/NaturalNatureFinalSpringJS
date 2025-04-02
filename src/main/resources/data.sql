INSERT INTO article (title, content, image_path, category) VALUES
                                                               ('The Rise of Electric Vehicles', 'Electric vehicles (EVs) are transforming the transportation industry.', '/images/electric-vehicles.jpg', 'Sustainable Transport'),
                                                               ('Why Biking is the Future of Urban Mobility', 'Biking is not only eco-friendly but also improves health.', '/images/biking-future.jpg', 'Sustainable Transport'),
                                                               ('Public Transport: A Sustainable Choice', 'Public transport systems can lower your carbon footprint.', '/images/public-transport.jpg', 'Sustainable Transport'),
                                                               ('Walking: The Simplest Way to Go Green', 'Walking is a zero-emission way to travel.', '/images/walking-green.jpg', 'Sustainable Transport'),
                                                               ('Hybrid Cars: Bridging the Gap', 'Hybrid cars offer a balance between fuel efficiency and performance.', '/images/hybrid-cars.jpg', 'Sustainable Transport'),
                                                               ('The Impact of Carpooling on the Environment', 'Carpooling reduces the number of vehicles on the road.', '/images/carpooling-impact.jpg', 'Sustainable Transport'),
                                                               ('Sustainable Transportation Policies', 'Governments are implementing policies to promote sustainable transportation.', '/images/transport-policies.jpg', 'Sustainable Transport'),
                                                               ('The Role of Technology in Green Transport', 'Technology is making transportation more sustainable.', '/images/tech-transport.jpg', 'Sustainable Transport'),
                                                               ('E-Scooters: A New Trend in Urban Travel', 'Electric scooters are gaining popularity in cities.', '/images/e-scooters.jpg', 'Sustainable Transport');
DELETE FROM article;
-- Добавяне на статии за Passive Houses
INSERT INTO article (title, content, category, image_path) VALUES
                                                               ('The Future of Passive Houses',
                                                                'Exploring the latest trends in passive house design.',
                                                                'Passive Houses', '/images/house-6.jpg'),
                                                               ('How to Retrofit Your Home for Energy Efficiency',
                                                                'Practical tips for making your home more sustainable.',
                                                                'Passive Houses', '/images/home-fit-anime.jpg'),
                                                               ('Solar Power: The Ultimate Guide', 'Everything you need to know about solar energy in homes.',
                                                                'Passive Houses', '/images/solar-city-anime.jpeg'),
                                                               ('Water Conservation Techniques for Every Home', 'Simple ways to save water in your household.',
                                                                'Passive Houses', '/images/water-anime.jpg'),
                                                               ('Wind Turbines for Residential Use', 'A beginner''s guide to wind energy at home.',
                                                                'Passive Houses', '/images/wind-1.jpg'),
                                                               ('Eco-Friendly Materials 101', 'The best materials for sustainable construction.',
                                                                'Passive Houses', '/images/101-anime.jpg'),
                                                               ('Energy Star Appliances: Why They Matter', 'How Energy Star appliances can reduce your energy bills.',
                                                                'Passive Houses', '/images/energy-star.jpg'),
                                                               ('Prefab Homes: The Future of Sustainable Living',
                                                                'Why prefab homes are a smart choice for eco-conscious builders.
Prefab Homes: The Future of Efficient Housing
1. What Are Prefab Homes?
Prefab homes (short for prefabricated homes) are residential structures where major components (walls, roof, interior elements)
are manufactured off-site in a factory-controlled environment, then transported and assembled on the building site.
This method revolutionizes traditional construction by prioritizing speed, precision, and sustainability.
2. Types of Prefab Homes:
Modular Homes: Built in sections (modules) that are stacked or joined on-site.
Panelized Homes: Use pre-made wall panels for rapid assembly.
Steel or Timber Frame Homes: Lightweight yet durable skeletal structures.
Shipping Container Homes: Repurposed steel containers transformed into living spaces.
Tiny Homes: Compact, mobile dwellings (often under 400 sq. ft).
3. Key Advantages:
Speed: 50–70% faster construction than traditional methods (typically 2–6 months).
Cost-Effective: Reduced labor/material waste and predictable pricing.
Eco-Friendly: Minimized construction waste; options for recycled/sustainable materials.
Customization: Flexible designs to match modern aesthetics.
Quality Control: Factory precision reduces defects and weather-related delays.
4. Challenges to Consider:
Design Limits: Complex architectural features may require customization.
Transport Logistics: Costs vary by location and home size.
Zoning Laws: Some regions have strict permits for prefab structures.
5. Ideal For:
Homeowners seeking affordable, fast-tracked housing.
Minimalists and eco-conscious buyers.
Investors in vacation rentals or ADUs (Accessory Dwelling Units).
6. Prefab vs. Traditional Homes:
Feature	Prefab Homes	Traditional Homes
Build Time	2–6 months	6–18+ months
Cost	Often 10–20% lower	Highly variable
Sustainability	High potential	More waste generated
Why It Matters Now:
With rising housing costs and climate concerns, prefab homes offer a scalable, efficient,
and greener alternative—blending innovation with practicality.
Pro Tip: Look for certifications like LEED or Passivhaus for ultra-efficient models.
This version keeps your original structure but enhances readability with:
Clearer headings and bullet points.
Concise comparisons.
Actionable insights (e.g., certifications to consider).
Let me know if you''d like to emphasize specific aspects (e.g., cost examples, regional trends)! 🚀
New chat
',
                                                                'Passive Houses', '/images/prefab-house.jpg');



INSERT INTO passive_houses (title, description, category, image_url, video_url) VALUES
-- Energy Efficiency
('Understanding Eco-Friendly Homes: A Comprehensive Guide',
 'Eco-friendly homes are designed to minimize environmental impact through energy efficiency, sustainable materials,
and renewable energy sources. Learn the basics of passive house design.', 'Energy Efficiency',
 '/images/house-5.jpg', 'https://www.youtube.com/embed/eRBNnfXXF4w'),
('Principles of Sustainable Home Design for Your Next Home Improvement',
 'Sustainable home design focuses on reducing energy consumption, using natural light, and incorporating eco-friendly materials.
Discover key principles to apply in your next project.', 'Energy Efficiency', '/images/home-design.jpg',
 'https://www.youtube.com/embed/oIddRKVH6H0'),
('Building the Passive House: Steps to Achieve an Eco-Friendly House',
 'Building a passive house involves careful planning, from site selection to insulation.
Follow these steps to create an energy-efficient home.', 'Energy Efficiency',
 '/images/passive-house-build.jpg', 'https://www.youtube.com/embed/Fezmkc9X3eE'),

-- Solar Power Systems
('An Insight into Green Home: Environmentally Friendly Approaches in House Construction',
 'Solar power systems are a cornerstone of green homes. Learn how to integrate solar panels into your home for sustainable energy.',
 'Solar Power Systems', '/images/solar-city-2.jpeg', 'https://www.youtube.com/embed/Bx0aDeru_Xw'),
('Going Beyond the Basics: Insulation, Energy Efficiency, and Ways to Heat and Cool Your Eco-Home',
 'Solar energy can be used for heating and cooling. Explore advanced techniques to maximize energy efficiency in your eco-home.',
 'Solar Power Systems', '/images/solar-heating.jpg', 'https://www.youtube.com/embed/Qq-3cZ0cbws'),

-- Water Conservation
('Popular Sustainable Living Techniques: Energy Efficient Appliances, Rainwater Collection, and Renewable Energy Use in Homes',
 'Rainwater collection systems can significantly reduce water usage. Learn how to implement them in your home.',
 'Water Conservation', '/images/water-anime.jpg', 'https://www.youtube.com/embed/N6wJa4j5dO4'),
('Transition into an Eco-Friendly Building: Make Your Home More Sustainable with Energy Star-rated Appliances and Fixtures',
 'Water-saving fixtures and Energy Star-rated appliances can transform your home into a sustainable haven.
Discover the best options.', 'Water Conservation', '/images/water-anime-2.jpg',
 'https://www.youtube.com/embed/V9ODb6YAeFc'),

-- Wind Turbines
('Making the Smart Choice: Leverage Prefab Homes and Eco-Friendly Building Materials for Reduced Energy Use',
 'Wind turbines can provide renewable energy for prefab homes. Learn how to integrate them into your eco-friendly design.',
 'Wind Turbines', '/images/wind-1.jpg',
 'https://www.youtube.com/embed/itd5kg7GsfA'),
('Reconfiguring Existing Homes: Ideas to Transform Your Home into an Energy-Efficient One',
 'Retrofitting your home with wind turbines and other renewable energy sources can make it more sustainable.
Get practical ideas here.', 'Wind Turbines', '/images/wind-2.jpg', 'https://www.youtube.com/embed/nPvTH7Siclg'),
('Earth-friendly Materials for Friendly Homes: Natural Materials in the Construction of Environmentally Friendly Homes',
 'Using natural materials alongside wind energy can create a truly eco-friendly home. Explore the best materials to use.',
 'Wind Turbines', '/images/wind-anime.jpg', 'https://www.youtube.com/embed/Fezmkc9X3eE');



-- Вмъкване на данни за ResponsibleFashion
INSERT INTO responsible_fashion (title, description, category, image_url, video_url) VALUES
                                                                                         ('Introduction: Embracing Ethical Fashion for Eco-friendly Living',
                                                                                          'Ethical fashion is more than a trend—it''s a movement towards sustainability and responsibility. Learn how to embrace eco-friendly living through your fashion choices.',
                                                                                          'Introduction',
                                                                                          '/images/fashion.jpg',
                                                                                          'https://www.youtube.com/embed/HMwdb1hqCz4'),
                                                                                         ('Discover Sustainable Clothing Brands: Ethical Practices and Eco-friendly Materials',
                                                                                          'Explore brands that prioritize ethical practices and use eco-friendly materials like organic cotton, recycled polyester, and hemp.',
                                                                                          'Sustainable Brands',
                                                                                          '/images/sustainable-brands.jpg',
                                                                                          NULL),
                                                                                         ('The Environmental Impact of Fast Fashion: Making Smarter Shopping Decisions',
                                                                                          'Fast fashion has a massive environmental footprint. Understand its impact and learn how to make smarter shopping decisions.',
                                                                                          'Fast Fashion Impact',
                                                                                          '/images/fast-fashion-impact.jpg',
                                                                                          'https://www.youtube.com/embed/fast-fashion-impact-video'),
                                                                                         ('Practical Tips for Integrating Ethical Fashion Into Your Daily Style Choices',
                                                                                          'Incorporate ethical fashion into your wardrobe with these practical tips, from choosing quality over quantity to supporting local artisans.',
                                                                                          'Practical Tips',
                                                                                          '/images/ethical-fashion-tips.jpg',
                                                                                          NULL),
                                                                                         ('Conclusion: Supporting a Greener Future Through Ethical Fashion',
                                                                                          'By choosing ethical fashion, you’re supporting a greener future. Take action today for a more sustainable tomorrow.',
                                                                                          'Conclusion',
                                                                                          '/images/ethical-fashion-conclusion.jpg',
                                                                                          'https://www.youtube.com/embed/ethical-fashion-conclusion-video');

-- Вмъкване на данни за Article (категория Responsible Fashion)
INSERT INTO article (title, content, category, image_path) VALUES
                                                               ('Conscious Consumerism | Making Informed Choices In Ethical Fashion',
                                                                'Learn how to make informed choices as a conscious consumer in the world of ethical fashion.',
                                                                'Responsible Fashion',
                                                                '/images/conscious-consumerism.jpg'),
                                                               ('Capsule Wardrobes | Simplifying Your Style For A Sustainable Closet',
                                                                'Discover the benefits of a capsule wardrobe for a more sustainable and minimalist style.',
                                                                'Responsible Fashion',
                                                                '/images/capsule-wardrobe.jpg'),
                                                               ('The Impact Of Fast Fashion | Understanding The Costs Of Mass Production',
                                                                'Understand the hidden costs of fast fashion and its impact on the environment and society.',
                                                                'Responsible Fashion',
                                                                '/images/fast-fashion-costs.jpg'),
                                                               ('Fashion Revolution: Advocating for Transparency and Ethical Practices',
                                                                'Join the Fashion Revolution movement to advocate for transparency and ethical practices in the industry.',
                                                                'Responsible Fashion',
                                                                '/images/fashion-revolution.jpg'),
                                                               ('Upcycling And Thrifting | Reviving Old Garments For A Greener Wardrobe',
                                                                'Revive old garments through upcycling and thrifting for a greener, more sustainable wardrobe.',
                                                                'Responsible Fashion',
                                                                '/images/upcycling-thrifting.jpg'),
                                                               ('The Role Of Vegan Fashion | Cruelty-Free Clothing And Accessories',
                                                                'Explore the role of vegan fashion in creating cruelty-free clothing and accessories.',
                                                                'Responsible Fashion',
                                                                '/images/vegan-fashion.jpg');