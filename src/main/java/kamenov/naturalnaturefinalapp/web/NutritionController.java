package kamenov.naturalnaturefinalapp.web;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class NutritionController {

    private static final Map<Long, Map<String, String>> articles = new HashMap<>();

    static {
        articles.put(1L, Map.of(
                "title", "The Benefits Of A Whole Foods Diet For Overall Health",
                "content", "<p>A whole foods diet focuses on consuming unprocessed or minimally processed foods, such as fruits," +
                        " vegetables, whole grains, nuts, seeds, and legumes. " +
                        "This approach provides a wide range of nutrients that support overall health," +
                        " including improved digestion, better heart health, and enhanced energy levels..." +
                        "The Whole Foods Approach: Principles and Fundamentals\n" +
                        "The Whole Foods Diet centers on consuming foods in their most natural, unrefined state. This nutritional philosophy prioritizes minimally processed ingredients while avoiding heavily refined products and fast food. True to its name, this way of eating focuses on foods that retain their original nutritional integrity – including fresh produce, whole grains, lean proteins, dairy in its simple forms, and beneficial fats. Nutrient powerhouses like avocados exemplify this approach, delivering concentrated nourishment. By building meals around these foundational elements, individuals can achieve dietary balance while supporting both physical and mental wellness.\n" +
                        "\n" +
                        "The Transformative Power of Whole Foods\n" +
                        "Scientific evidence consistently demonstrates the advantages of a whole foods regimen, particularly plant-forward variations. Such dietary patterns correlate with decreased incidence of cardiovascular conditions and metabolic disorders like type 2 diabetes. The benefits extend to digestive health, as ultra-processed foods often disrupt gut microbiota, while their unprocessed counterparts promote microbial diversity. Research indicates these eating habits may offer protection against various health concerns ranging from weight management challenges to certain malignancies.\n" +
                        "\n" +
                        "This \"clean eating\" paradigm serves as an antidote to modern dietary pitfalls dominated by nutritionally depleted, artificially enhanced products. Choosing whole foods satisfies the body's authentic nutritional requirements without relying on processed shortcuts. Beyond health metrics, this approach elevates the eating experience itself – turning nourishment into both a sensory pleasure and a wellness strategy.\n" +
                        "\n" +
                        "Documented Advantages of a Whole Foods Regimen\n" +
                        "Transitioning to a whole foods diet yields measurable improvements in health outcomes. These unadulterated foods, free from synthetic additives prevalent in processed alternatives, deliver concentrated nutrition – abundant vitamins, minerals, and fiber that synergistically enhance wellbeing. Clinical observations associate such diets with improved weight management, stabilized glucose metabolism, and enhanced cardiovascular function.\n" +
                        "\n" +
                        "Constructing a whole foods pantry involves emphasizing plant-based staples – vibrant produce, intact grains, legumes, nuts, and seeds – while minimizing processed items. While some minimally processed foods like yogurt have their place, fast food and similar products are best avoided. Those who participate in food cultivation often develop deeper nutritional awareness and stronger commitments to clean eating principles.\n" +
                        "\n" +
                        "This approach transcends temporary diet trends, representing instead an enduring lifestyle centered on consuming foods closest to their natural form. It requires understanding food preparation methods and developing eating patterns that actively support health maintenance and disease prevention.\n" +
                        "\n" +
                        "Nutritional Powerhouses: Core Components of the Diet\n" +
                        "The clean eating philosophy celebrates nature's bounty – wholesome, nutrient-dense foods that contrast sharply with processed substitutes. From colorful vegetables and fruits to quality proteins and beneficial lipids, these foods provide essential micronutrients, fiber, and antioxidants that collectively support optimal functioning.\n" +
                        "\n" +
                        "Unlike their processed counterparts that undergo extensive refinement and artificial enhancement, whole foods maintain their innate nutritional profiles. This distinction translates to tangible health benefits, with research showing reduced chronic disease incidence among those consuming diets rich in unprocessed foods, particularly those containing healthy fats and proteins. Interestingly, individuals engaged in food production often demonstrate stronger adherence to nutritious eating patterns.\n" +
                        "\n" +
                        "Essential plant-based whole foods include:\n" +
                        "\n" +
                        "Crisp apples\n" +
                        "\n" +
                        "Nutrient-packed leafy greens\n" +
                        "\n" +
                        "Protein-rich quinoa\n" +
                        "\n" +
                        "Fiber-filled lentils\n" +
                        "\n" +
                        "Vitamin E-rich almonds\n" +
                        "\n" +
                        "By prioritizing these foods and minimizing processed items, individuals can significantly enhance their physical health and metabolic stability. The whole foods philosophy naturally excludes heavily processed products while revealing the hidden benefits of nature's offerings. As the adage goes, \"You are what you eat\" – making conscious food selections allows the advantages of whole foods to manifest while avoiding the drawbacks of processed alternatives.\n" +
                        "\n" +
                        "The Essential Role of Beneficial Fats\n" +
                        "High-quality fats constitute a critical element of the whole foods paradigm, delivering numerous health advantages that support comprehensive wellbeing. Contrary to outdated notions that equate healthy eating with fat avoidance, the right kinds of fats – those found in whole foods like avocados, nuts, seeds, and olives – play vital roles in metabolic processes, cognitive function, and satiety regulation.\n" +
                        "\n" +
                        "Unlike the harmful fats prevalent in processed foods, these natural lipid sources may help prevent cardiovascular disease and other chronic conditions. In the context of whole foods nutrition, \"diet\" represents a sustainable lifestyle rather than a temporary regimen. Meals center on ingredients that have undergone minimal alteration, free from artificial additives. Epidemiological studies consistently associate such eating patterns with reduced chronic disease risk, sustained energy levels, and improved emotional balance.\n" +
                        "\n" +
                        "Excellent sources of healthful fats include:\n" +
                        "\n" +
                        "Creamy avocados\n" +
                        "\n" +
                        "Omega-3 rich chia and flaxseeds\n" +
                        "\n" +
                        "Brain-boosting walnuts and almonds\n" +
                        "\n" +
                        "Heart-healthy extra virgin olive oil\n" +
                        "\n" +
                        "Nutrient-dense fatty fish like salmon\n" +
                        "\n" +
                        "Incorporating these fat sources promotes cardiovascular health, cognitive performance, " +
                        "and nutritional balance – key components of holistic wellness.\n" +
                        "\n" +
                        "Final Considerations\n" +
                        "Adopting a clean eating approach anchored in whole foods yields significant, measurable health benefits. " +
                        "This nutritional strategy emphasizes a diverse array of unprocessed foods – vibrant produce, quality proteins, " +
                        "and intact grains – while reducing refined products, added sugars, and unhealthy fats. " +
                        "The resulting benefits include decreased obesity rates, improved cardiovascular markers, and reduced cancer risk, " +
                        "alongside enhanced overall vitality.\n" +
                        "\n" +
                        "Beyond physiological advantages, this approach cultivates nutritional literacy and mindful eating practices that support " +
                        "lasting wellness. By making clean eating a consistent lifestyle rather than a temporary measure," +
                        " individuals can significantly reduce diet-related disease risk while promoting sustainable health across the lifespan. " +
                        "The evidence is clear: what we choose to eat fundamentally shapes our health trajectory," +
                        " making whole foods one of our most powerful wellness tools.</p>",
                "image", "/images/whole-foods-diet.jpg"
        ));
        articles.put(2L, Map.of(
                "title", "Superfoods | What They Are And How To Incorporate Them Into Your Diet",
                "content", "<p>Superfoods are nutrient-dense foods that offer significant health benefits." +
                        " Examples include quinoa, kale, chia seeds, and berries. " +
                        "To incorporate them into your diet, try adding chia seeds to smoothies, using quinoa as a base for salads," +
                        " or snacking on fresh berries..." +
                        "The Power of Superfoods: Nature’s Nutritional Champions\n" +
                        "What Makes a Food \"Super\"?\n" +
                        "Superfoods have earned their elite status by delivering exceptional health benefits in every bite. These nutritional powerhouses are packed with vitamins, minerals, antioxidants, and healthy fats—all while being naturally low in calories and unhealthy fats. From leafy greens like spinach and kale to antioxidant-rich berries and heart-healthy avocados, superfoods offer a delicious way to boost wellness. Even fatty fish like salmon and probiotic-rich yogurt make the list, proving that superfoods come in many forms.\n" +
                        "\n" +
                        "By incorporating these nutrient-dense foods into your diet, you can help reduce the risk of chronic diseases like heart disease and type 2 diabetes, support digestion, and even enhance brain function. Whether you're blending berries into a smoothie or drizzling avocado on toast, every superfood choice brings you closer to optimal health.\n" +
                        "\n" +
                        "Top Superfoods to Transform Your Health\n" +
                        "1. Salmon: The Omega-3 Powerhouse\n" +
                        "Salmon isn’t just delicious—it’s one of the best sources of omega-3 fatty acids, essential for heart and brain health. Regular consumption may lower inflammation, improve cholesterol levels, and even support mental well-being. Plus, it’s rich in high-quality protein, vitamin D, and selenium.\n" +
                        "\n" +
                        "2. Avocados: Creamy, Heart-Healthy Goodness\n" +
                        "With nearly 75% of their fats being the heart-friendly monounsaturated kind, avocados are a superstar for cardiovascular health. They also aid in nutrient absorption, support weight management, and provide a hefty dose of fiber, potassium, and vitamins E and B.\n" +
                        "\n" +
                        "3. Berries: Antioxidant-Rich Gems\n" +
                        "Blueberries, strawberries, raspberries, and blackberries are bursting with antioxidants that combat free radicals, reduce inflammation, and may even slow brain aging. Their natural sweetness makes them an easy (and guilt-free) addition to meals and snacks.\n" +
                        "\n" +
                        "4. Sweet Potatoes: The Vibrant Superfood\n" +
                        "Packed with beta-carotene, fiber, and vitamins A and C, sweet potatoes promote healthy vision, digestion, and immunity. Their slow-digesting carbs provide steady energy, making them a perfect fuel source.\n" +
                        "\n" +
                        "5. Leafy Greens: Nutrient Powerhouses\n" +
                        "Spinach, kale, and Swiss chard are loaded with vitamins A, C, and K, along with iron, calcium, and fiber. These greens support everything from bone strength to blood pressure regulation.\n" +
                        "\n" +
                        "6. Green Tea: The Ultimate Wellness Elixir\n" +
                        "Beyond being a soothing drink, green tea is rich in antioxidants called catechins, which may boost metabolism, enhance brain function, and even lower cancer risk.\n" +
                        "\n" +
                        "7. Yogurt: Gut-Friendly Probiotics\n" +
                        "A great source of probiotics, yogurt supports digestive health, strengthens immunity, and provides calcium for strong bones. Opt for plain, unsweetened varieties for maximum benefits.\n" +
                        "\n" +
                        "8. Nuts & Seeds: Tiny but Mighty\n" +
                        "Almonds, walnuts, chia seeds, and flaxseeds deliver healthy fats, protein, and fiber. They help reduce bad cholesterol, support brain health, and keep you full longer.\n" +
                        "\n" +
                        "Simple Ways to Eat More Superfoods\n" +
                        "Upgrade breakfast – Add chia seeds to oatmeal or blend spinach into a smoothie.\n" +
                        "\n" +
                        "Supercharge salads – Toss in avocado, walnuts, and berries for extra nutrients.\n" +
                        "\n" +
                        "Snack smarter – Swap chips for kale chips or a handful of almonds.\n" +
                        "\n" +
                        "Power up meals – Use quinoa instead of white rice or roast sweet potatoes as a side.\n" +
                        "\n" +
                        "Sip wisely – Replace sugary drinks with green tea or antioxidant-rich berry-infused water.\n" +
                        "\n" +
                        "Final Thoughts: Small Changes, Big Benefits\n" +
                        "Superfoods aren’t a magic cure, but they’re a powerful tool for long-term health. By making mindful additions to your diet—like choosing salmon over processed meats or snacking on nuts instead of candy—you can enhance energy, immunity, and overall vitality.\n" +
                        "\n" +
                        "The best part? You don’t need a complete diet overhaul. Start small, experiment with flavors, and enjoy the journey toward a healthier, more vibrant you—one superfood at a time.</p>",
                "image", "/images/superfoods.jpeg"
        ));
        articles.put(3L, Map.of(
                "title", "The Importance Of Organic And Non-Gmo Foods In A Healthy Diet",
                "content", "<p>Organic and non-GMO foods are free from harmful pesticides and genetic modifications, " +
                        "making them a safer choice for your health. " +
                        "They also support sustainable farming practices and biodiversity..." +
                        "Why Organic and Non-GMO Matter in Modern Nutrition\n" +
                        "The growing global interest in organic and non-GMO foods reflects our increasing awareness of how dietary choices impact both personal health and environmental sustainability. Organic farming represents more than just an agricultural method—it's a comprehensive approach to food production that prioritizes ecological balance, biodiversity, and natural processes. Unlike conventional farming that relies heavily on synthetic pesticides and fertilizers, organic agriculture uses natural alternatives that protect soil health and water quality while minimizing chemical residues in our food.\n" +
                        "\n" +
                        "The nutritional advantages of organic foods are becoming increasingly evident. Research suggests they often contain higher levels of certain antioxidants and beneficial nutrients compared to their conventionally grown counterparts. Organic dairy products, for instance, have been shown to contain more omega-3 fatty acids, while organic produce typically has lower pesticide residues. However, it's important to note that \"organic\" doesn't automatically mean \"healthy\"—organic processed foods can still be high in sugar or unhealthy fats.\n" +
                        "\n" +
                        "Decoding Food Labels: Organic vs. Non-GMO\n" +
                        "Understanding food labeling is crucial for making informed choices:\n" +
                        "\n" +
                        "Organic Certification requires adherence to strict standards prohibiting synthetic pesticides, GMOs, and artificial additives\n" +
                        "\n" +
                        "Non-GMO Verification means the product contains no genetically modified ingredients but doesn't address farming practices\n" +
                        "\n" +
                        "Conventional Foods may use synthetic inputs and GMOs unless otherwise specified\n" +
                        "\n" +
                        "While organic foods often come at a premium price, this reflects the more labor-intensive farming methods and certification processes involved. For budget-conscious consumers, strategic choices—like prioritizing organic versions of the \"Dirty Dozen\" (produce with highest pesticide residues)—can maximize benefits while managing costs.\n" +
                        "\n" +
                        "The Health and Environmental Advantages\n" +
                        "Choosing organic offers multiple benefits:\n" +
                        "\n" +
                        "Reduced Chemical Exposure: Organic farming eliminates synthetic pesticide use\n" +
                        "\n" +
                        "Enhanced Nutrition: Some studies show higher nutrient levels in organic crops\n" +
                        "\n" +
                        "Environmental Protection: Organic methods promote soil health and biodiversity\n" +
                        "\n" +
                        "Animal Welfare: Organic livestock standards require better living conditions\n" +
                        "\n" +
                        "However, conventional foods still play an important role in global food security, particularly in regions where organic options are scarce or unaffordable. The key is making informed choices based on personal circumstances and priorities.\n" +
                        "\n" +
                        "Practical Tips for Incorporating Organic Foods\n" +
                        "Start by switching to organic versions of foods you consume most frequently\n" +
                        "\n" +
                        "Shop at farmers' markets for locally grown organic produce\n" +
                        "\n" +
                        "Look for store-brand organic items which often cost less\n" +
                        "\n" +
                        "Consider joining a CSA (Community Supported Agriculture) program\n" +
                        "\n" +
                        "Grow your own herbs and vegetables using organic methods\n" +
                        "\n" +
                        "Making Balanced Choices\n" +
                        "While organic and non-GMO foods offer clear benefits, they represent just one aspect of a healthy diet. The most important factors remain:\n" +
                        "\n" +
                        "Eating a variety of whole, minimally processed foods\n" +
                        "\n" +
                        "Consuming plenty of fruits and vegetables regardless of farming method\n" +
                        "\n" +
                        "Maintaining balanced nutrition that meets your individual needs\n" +
                        "\n" +
                        "As consumer demand grows, organic options are becoming more accessible in mainstream markets. " +
                        "By making conscious food choices, we can support our personal" +
                        " health while encouraging more sustainable agricultural practices—creating benefits that extend from our plates to the planet.</p>",
                "image", "/images/organic-food.png"
        ));
        articles.put(4L, Map.of(
                "title", "Hydration And Whole Foods | The Connection Between Water And Health",
                "content", "<p>Whole foods like fruits and vegetables are naturally high in water content, helping you stay hydrated." +
                        " Proper hydration supports digestion, skin health, and cognitive function..." +
                        "The Vital Role of Hydration in Maintaining Optimal Health\n" +
                        "Understanding Hydration Fundamentals\n" +
                        "Proper fluid balance is crucial for sustaining life and supporting all bodily functions. As the primary component of human physiology, water constitutes about 60% of our body composition, varying slightly based on individual characteristics. This essential nutrient facilitates numerous critical processes including nutrient transport, temperature regulation, waste removal, and cellular function. Maintaining adequate hydration supports cognitive performance, physical endurance, digestive health, and metabolic efficiency.\n" +
                        "\n" +
                        "Daily Hydration Requirements\n" +
                        "While individual needs vary, general guidelines suggest:\n" +
                        "\n" +
                        "Adult men: Approximately 3.7 liters daily (including fluids from food)\n" +
                        "\n" +
                        "Adult women: Roughly 2.7 liters daily (including food sources)\n" +
                        "Key factors influencing requirements:\n" +
                        "✔ Physical activity levels\n" +
                        "✔ Climate and environmental conditions\n" +
                        "✔ Health status and special physiological needs\n" +
                        "\n" +
                        "Hydration Beyond Plain Water\n" +
                        "Many foods contribute significantly to daily fluid intake:\n" +
                        "\n" +
                        "Fruits: Watermelon (92% water), strawberries (91%), oranges (88%)\n" +
                        "\n" +
                        "Vegetables: Cucumber (96% water), lettuce (95%), zucchini (94%)\n" +
                        "\n" +
                        "Other sources: Soups, herbal teas, and dairy products\n" +
                        "\n" +
                        "Recognizing Dehydration Risks\n" +
                        "Early warning signs include:\n" +
                        "• Fatigue and reduced energy\n" +
                        "• Headaches and dizziness\n" +
                        "• Dark-colored urine\n" +
                        "• Dry mouth and skin\n" +
                        "• Impaired concentration\n" +
                        "\n" +
                        "Chronic dehydration may contribute to more serious health complications including kidney stones, urinary tract infections, and impaired cognitive function.\n" +
                        "\n" +
                        "Water Intoxication: The Overhydration Hazard\n" +
                        "While rare, excessive water consumption can disrupt electrolyte balance, potentially causing:\n" +
                        "\n" +
                        "Hyponatremia (dangerously low sodium levels)\n" +
                        "\n" +
                        "Nausea and vomiting\n" +
                        "\n" +
                        "Confusion or disorientation\n" +
                        "\n" +
                        "Muscle weakness\n" +
                        "\n" +
                        "Practical Hydration Strategies\n" +
                        "Morning routine: Begin each day with 1-2 glasses of water\n" +
                        "\n" +
                        "Mealtime hydration: Consume fluids with each meal\n" +
                        "\n" +
                        "Activity adjustment: Increase intake before, during, and after exercise\n" +
                        "\n" +
                        "Visual reminders: Keep a water bottle accessible throughout the day\n" +
                        "\n" +
                        "Monitor indicators: Use urine color (pale yellow = optimal) as a guide\n" +
                        "\n" +
                        "Special Considerations\n" +
                        "Athletes: Require additional electrolytes during prolonged activity\n" +
                        "\n" +
                        "Older adults: Often experience diminished thirst sensation\n" +
                        "\n" +
                        "Pregnancy/breastfeeding: Increased fluid needs for maternal and fetal health\n" +
                        "\n" +
                        "Hydration and Whole Body Health\n" +
                        "Adequate fluid intake supports:\n" +
                        "✅ Cardiovascular function\n" +
                        "✅ Joint lubrication\n" +
                        "✅ Skin health and elasticity\n" +
                        "✅ Digestive regularity\n" +
                        "✅ Detoxification processes\n" +
                        "\n" +
                        "Conclusion\n" +
                        "Maintaining proper hydration is one of the simplest yet most powerful ways to support overall health. " +
                        "By combining conscious water consumption with water-rich foods and paying attention to your body's signals," +
                        " you can optimize hydration status. Remember that individual needs vary—adjust your intake based on activity level, " +
                        "environment, and personal health factors. " +
                        "Making hydration a daily priority contributes significantly to both immediate wellbeing and long-term health outcomes.</p>",
                "image", "/images/hydration.jpg"
        ));
        articles.put(5L, Map.of(
                "title", "Cooking Techniques For Preserving Nutrients In Whole Foods",
                "content", "<p>Steaming, sautéing, and roasting are great techniques for preserving nutrients in whole foods. " +
                        "Avoid overcooking vegetables to retain their vitamins and minerals..." +
                        "Maximizing Nutritional Value in Whole Foods Through Proper Preparation\n" +
                        "The Science of Nutrient Preservation\n" +
                        "The way we prepare whole foods significantly impacts their nutritional profile. Cooking methods can either enhance or diminish the availability of essential vitamins, minerals, and antioxidants. Research shows that gentle cooking techniques help preserve heat-sensitive nutrients like vitamin C and B vitamins, which are crucial for immune function and energy metabolism.\n" +
                        "\n" +
                        "Optimal Cooking Methods for Nutrient Retention\n" +
                        "Steaming\n" +
                        "\n" +
                        "Preserves up to 90% of water-soluble vitamins\n" +
                        "\n" +
                        "Ideal for delicate vegetables (broccoli, spinach, asparagus)\n" +
                        "\n" +
                        "Cooks food quickly without water immersion\n" +
                        "\n" +
                        "Roasting/Baking\n" +
                        "\n" +
                        "Enhances flavor through caramelization\n" +
                        "\n" +
                        "Best for root vegetables and lean proteins\n" +
                        "\n" +
                        "Maintains mineral content when done at moderate temperatures\n" +
                        "\n" +
                        "Sautéing/Stir-frying\n" +
                        "\n" +
                        "Quick cooking preserves texture and nutrients\n" +
                        "\n" +
                        "Uses minimal oil at high heat\n" +
                        "\n" +
                        "Excellent for colorful vegetables\n" +
                        "\n" +
                        "Raw Preparation\n" +
                        "\n" +
                        "Retains all heat-sensitive nutrients\n" +
                        "\n" +
                        "Perfect for salads and fresh fruits\n" +
                        "\n" +
                        "Increases enzyme activity beneficial for digestion\n" +
                        "\n" +
                        "Key Factors Affecting Nutrient Retention\n" +
                        "✔ Temperature Control: Lower temperatures (below 100°C) preserve delicate nutrients\n" +
                        "✔ Cooking Duration: Shorter cooking times minimize nutrient breakdown\n" +
                        "✔ Food Preparation: Leaving skins on and cutting into larger pieces reduces surface area exposure\n" +
                        "✔ Liquid Utilization: Reusing cooking water in soups or sauces recaptures leached nutrients\n" +
                        "\n" +
                        "Special Considerations for Frozen Foods\n" +
                        "Steam directly from frozen to prevent nutrient loss from thawing\n" +
                        "\n" +
                        "Quick-cook methods like stir-frying work well for frozen vegetables\n" +
                        "\n" +
                        "Avoid overcooking - frozen foods often cook faster than fresh\n" +
                        "\n" +
                        "Practical Tips for Nutrient-Dense Meals\n" +
                        "Combine raw and cooked vegetables for balanced nutrient intake\n" +
                        "\n" +
                        "Use cooking liquids (like vegetable steaming water) in sauces or soups\n" +
                        "\n" +
                        "Pair fat-soluble vitamins (A,D,E,K) with healthy fats for better absorption\n" +
                        "\n" +
                        "Store produce properly to maintain pre-cooking nutrient levels\n" +
                        "\n" +
                        "Common Mistakes to Avoid\n" +
                        "✖ Boiling vegetables excessively (can lose up to 50% of vitamin C)\n" +
                        "✖ Peeling nutrient-rich skins from fruits and vegetables\n" +
                        "✖ Using high heat for delicate oils (can create harmful compounds)\n" +
                        "✖ Overcooking proteins (reduces digestibility and nutrient availability)\n" +
                        "\n" +
                        "The Balanced Approach\n" +
                        "While cooking can reduce certain nutrients, it also:\n" +
                        "\n" +
                        "Enhances bioavailability of some antioxidants (lycopene in tomatoes)\n" +
                        "\n" +
                        "Improves digestibility of proteins and complex carbohydrates\n" +
                        "\n" +
                        "Kills potential foodborne pathogens\n" +
                        "\n" +
                        "Aim for variety in preparation methods - include raw, lightly cooked, " +
                        "and fermented foods in your diet to maximize nutritional benefits.</p>",
                "image", "/images/cooking-techniques-2.jpg"
        ));
        articles.put(6L, Map.of(
                "title", "Family Nutrition | Tips For Raising Healthy Eaters With Whole Foods",
                "content", "<p>Involve kids in meal prep, offer a variety of whole foods, " +
                        "and make healthy eating fun to encourage lifelong healthy habits..." +
                        "25 Practical Tips for Raising Healthy Eaters with Whole Foods\n" +
                        "\n" +
                        "Lead by Example – Children mimic eating habits; enjoy whole foods together as a family.\n" +
                        "\n" +
                        "Start Early – Introduce diverse fruits, vegetables, and whole grains during infancy.\n" +
                        "\n" +
                        "Make Meals Colorful – Use vibrant produce to make plates visually appealing and nutrient-rich.\n" +
                        "\n" +
                        "Involve Kids in Cooking – Let them wash veggies or stir ingredients to build interest.\n" +
                        "\n" +
                        "Grow a Kitchen Garden – Teach kids where food comes from by planting herbs or veggies.\n" +
                        "\n" +
                        "Offer Choices – Let them pick between two healthy options (e.g., carrots or cucumbers).\n" +
                        "\n" +
                        "Limit Processed Snacks – Replace chips with whole-food alternatives like apple slices or nuts.\n" +
                        "\n" +
                        "Use Creative Names – Call broccoli \"dinosaur trees\" or smoothies \"magic potions.\"\n" +
                        "\n" +
                        "Family Mealtime – Eat together without screens to encourage mindful eating.\n" +
                        "\n" +
                        "Batch Prep Healthy Snacks – Keep cut veggies, hummus, or yogurt cups ready to grab.\n" +
                        "\n" +
                        "Sneak in Nutrients – Blend spinach into smoothies or add grated zucchini to muffins.\n" +
                        "\n" +
                        "Educate Playfully – Use books or games to teach about nutrition (e.g., \"Eating the Alphabet\").\n" +
                        "\n" +
                        "Avoid Food Battles – Pressuring kids backfires; reintroduce rejected foods later.\n" +
                        "\n" +
                        "Shop Together – Let kids select a new whole food to try each week.\n" +
                        "\n" +
                        "Make Whole Foods Convenient – Keep washed fruit on the counter for easy access.\n" +
                        "\n" +
                        "Celebrate Food Diversity – Explore global cuisines with natural ingredients.\n" +
                        "\n" +
                        "Hydrate Wisely – Offer water or infused fruit instead of sugary drinks.\n" +
                        "\n" +
                        "DIY Versions – Make homemade pizza or oatmeal bars with whole ingredients.\n" +
                        "\n" +
                        "Teach Portion Awareness – Use hand measurements (e.g., palm-sized protein portions).\n" +
                        "\n" +
                        "Limit Added Sugars – Sweeten foods naturally with dates, bananas, or cinnamon.\n" +
                        "\n" +
                        "Pack Nutrient-Dense Lunches – Include whole-grain wraps, veggies, and lean proteins.\n" +
                        "\n" +
                        "Respect Appetites – Let kids stop eating when full to avoid overeating habits.\n" +
                        "\n" +
                        "Farmers’ Market Trips – Turn local, seasonal produce into a fun outing.\n" +
                        "\n" +
                        "Cookbooks for Kids – Pick age-appropriate recipes to spark kitchen curiosity.\n" +
                        "\n" +
                        "Celebrate Progress – Praise adventurous eating without using food as a reward.\n" +
                        "\n" +
                        "Why It Works:\n" +
                        "Whole foods provide essential vitamins, fiber, and minerals for growing bodies while establishing lifelong healthy habits. " +
                        "By making nutrition interactive and positive," +
                        " families can reduce picky eating and foster a love for real, unprocessed foods.</p>",
                "image", "/images/family-nutrition.jpg"
        ));
        articles.put(7L, Map.of(
                "title", "Plant-Based Nutrition | A Comprehensive Guide To A Vegan Diet",
                "content", "<p>A plant-based diet focuses on whole foods like vegetables, fruits, grains, and legumes. " +
                        "It’s rich in fiber, vitamins, and antioxidants, and can reduce the risk of chronic diseases..." +
                        "The Essentials of Plant-Powered Eating: A Guide to Vegan Nutrition\n" +
                        "Adopting a plant-based approach to eating centers on consuming wholesome, minimally processed foods from the earth while avoiding animal-derived products. This dietary pattern emphasizes an abundance of legumes, whole grains, nuts, seeds, fruits, and vegetables—all rich in fiber, vitamins, and antioxidants. Research consistently links plant-based diets to reduced risks of heart disease, diabetes, and certain cancers, thanks to their high nutrient density and absence of harmful saturated fats.\n" +
                        "\n" +
                        "While some worry about protein intake, plant-based sources like lentils, quinoa, tofu, and tempeh provide ample protein while also delivering beneficial phytonutrients. For optimal nutrition, incorporating fortified plant milks (with B12 and calcium) ensures no essential nutrients are missed. Transitioning to plant-based eating doesn’t have to be overwhelming—start by gradually replacing animal proteins with plant alternatives and exploring diverse, flavorful recipes.\n" +
                        "\n" +
                        "Why Choose Plant-Based? Key Health and Wellness Benefits\n" +
                        "Switching to a whole-food, plant-based (WFPB) diet offers profound health advantages:\n" +
                        "\n" +
                        "✔ Heart Health – Lower cholesterol and blood pressure due to reduced saturated fat intake\n" +
                        "✔ Weight Management – Higher fiber content promotes satiety and healthy weight\n" +
                        "✔ Disease Prevention – Antioxidant-rich foods combat inflammation and oxidative stress\n" +
                        "✔ Digestive Wellness – Increased fiber supports gut health and regularity\n" +
                        "\n" +
                        "A well-planned vegan diet can meet all nutritional needs, but it’s important to focus on:\n" +
                        "\n" +
                        "Protein diversity (beans, lentils, edamame, seitan)\n" +
                        "\n" +
                        "Iron absorption (pair iron-rich foods like spinach with vitamin C sources)\n" +
                        "\n" +
                        "Omega-3s (flaxseeds, chia seeds, walnuts)\n" +
                        "\n" +
                        "Vitamin B12 (supplementation or fortified foods)\n" +
                        "\n" +
                        "For beginners, a gradual shift—such as starting with Meatless Mondays—can make the transition smoother.\n" +
                        "\n" +
                        "Making the Switch: How to Transition to a Plant-Based Diet\n" +
                        "Moving toward plant-based eating is easier with these steps:\n" +
                        "\n" +
                        "Educate Yourself – Learn about plant protein sources and balanced meal planning.\n" +
                        "\n" +
                        "Experiment with Substitutes – Try tofu scrambles, lentil Bolognese, or chickpea curries.\n" +
                        "\n" +
                        "Meal Prep for Success – Batch-cook grains, beans, and roasted veggies for easy meals.\n" +
                        "\n" +
                        "Explore Global Cuisines – Mediterranean, Indian, and Asian diets offer delicious plant-based dishes.\n" +
                        "\n" +
                        "Listen to Your Body – Adjust fiber intake gradually to avoid digestive discomfort.\n" +
                        "\n" +
                        "Studies show that those who follow plant-based diets tend to have lower BMI and reduced chronic disease risk compared to meat-eaters. However, balance is key—processed vegan foods (like mock meats) should be enjoyed in moderation.\n" +
                        "\n" +
                        "Meal Planning Made Simple: Delicious & Nutritious Plant-Based Recipes\n" +
                        "A well-structured vegan meal plan ensures nutrient adequacy and keeps meals exciting. Here’s a sample day:\n" +
                        "\n" +
                        "\uD83C\uDF31 Breakfast: Overnight oats with almond butter, chia seeds, and berries\n" +
                        "\uD83C\uDF31 Lunch: Quinoa salad with chickpeas, roasted veggies, and tahini dressing\n" +
                        "\uD83C\uDF31 Snack: Hummus with carrot sticks and whole-grain crackers\n" +
                        "\uD83C\uDF31 Dinner: Lentil curry with brown rice and steamed broccoli\n" +
                        "\uD83C\uDF31 Dessert: Dark chocolate-covered almonds\n" +
                        "\n" +
                        "Pro Tips:\n" +
                        "\n" +
                        "Use nutritional yeast for a cheesy, B12-boosting flavor\n" +
                        "\n" +
                        "Blend silken tofu into creamy sauces and desserts\n" +
                        "\n" +
                        "Soak nuts and seeds to enhance digestibility\n" +
                        "\n" +
                        "The Bigger Picture: Health for You and the Planet\n" +
                        "Beyond personal wellness, plant-based eating supports environmental sustainability. Livestock farming contributes significantly to greenhouse gas emissions, deforestation, and water waste. By choosing plant foods, individuals can:\n" +
                        "\n" +
                        "✅ Reduce their carbon footprint\n" +
                        "✅ Conserve water resources\n" +
                        "✅ Promote ethical food systems\n" +
                        "\n" +
                        "Final Thoughts: A Sustainable, Nutrient-Packed Lifestyle\n" +
                        "A plant-based diet isn’t just about removing animal products—it’s about embracing a diverse," +
                        " colorful array of whole foods that nourish the body and protect long-term health." +
                        " Whether motivated by wellness, ethics, or environmental concerns, " +
                        "transitioning to plant-based eating can be a fulfilling and impactful choice.\n" +
                        "\n" +
                        "Start small, stay curious, and enjoy the journey toward vibrant health!</p>",
                "image", "/images/plant-based.jpg"
        ));
        articles.put(8L, Map.of(
                "title", "The Role Of Antioxidants In Whole Food Nutrition",
                "content", "<p>Antioxidants in whole foods, such as berries, nuts, and leafy greens, " +
                        "protect your cells from damage and reduce inflammation..." +
                        "The Power of Antioxidants: Nature's Defense Against Cellular Damage\n" +
                        "What Are Antioxidants and Why Do We Need Them?\n" +
                        "Antioxidants are protective compounds that neutralize harmful molecules called free radicals, which are produced naturally during metabolism and through exposure to environmental stressors like pollution and UV radiation. These unstable molecules can damage cells through oxidative stress, contributing to aging and various chronic conditions.\n" +
                        "\n" +
                        "Our bodies produce some antioxidants naturally, but we primarily obtain them through whole plant foods like fruits, vegetables, nuts, and spices. Key antioxidant compounds include:\n" +
                        "\n" +
                        "Vitamin C (citrus fruits, bell peppers)\n" +
                        "\n" +
                        "Vitamin E (nuts, seeds, leafy greens)\n" +
                        "\n" +
                        "Carotenoids (carrots, tomatoes, sweet potatoes)\n" +
                        "\n" +
                        "Flavonoids (berries, tea, dark chocolate)\n" +
                        "\n" +
                        "Polyphenols (olives, coffee, herbs)\n" +
                        "\n" +
                        "Top Antioxidant-Rich Foods to Include in Your Diet\n" +
                        "Berries – Blueberries, strawberries, and raspberries contain anthocyanins\n" +
                        "\n" +
                        "Dark Leafy Greens – Spinach and kale provide lutein and zeaxanthin\n" +
                        "\n" +
                        "Nuts and Seeds – Almonds and sunflower seeds offer vitamin E\n" +
                        "\n" +
                        "Colorful Vegetables – Bell peppers and beets are packed with diverse antioxidants\n" +
                        "\n" +
                        "Herbs and Spices – Turmeric, cinnamon, and oregano have exceptionally high ORAC values\n" +
                        "\n" +
                        "Whole Foods vs. Supplements: What Research Shows\n" +
                        "While antioxidant supplements are widely available, studies suggest they may not provide the same benefits as whole food sources:\n" +
                        "\n" +
                        "✔ Synergistic Effects – Whole foods contain complementary nutrients that enhance absorption\n" +
                        "✔ Safety – High-dose supplements may cause imbalances (e.g., excess beta-carotene in smokers)\n" +
                        "✔ Bioavailability – Food matrices improve antioxidant utilization compared to isolated compounds\n" +
                        "\n" +
                        "The National Institutes of Health recommends obtaining antioxidants primarily through a varied diet rather than supplements.\n" +
                        "\n" +
                        "Practical Tips for Maximizing Antioxidant Intake\n" +
                        "Eat the Rainbow – Consume fruits/vegetables of different colors daily\n" +
                        "\n" +
                        "Choose Whole Over Processed – Opt for fresh or frozen produce instead of juices\n" +
                        "\n" +
                        "Smart Cooking Methods – Light steaming preserves more nutrients than boiling\n" +
                        "\n" +
                        "Pair Strategically – Combine vitamin C-rich foods with iron sources to boost absorption\n" +
                        "\n" +
                        "Special Considerations\n" +
                        "Athletes – May have higher antioxidant needs due to increased oxidative stress\n" +
                        "\n" +
                        "Aging Populations – Antioxidant-rich diets may support cognitive function\n" +
                        "\n" +
                        "Chronic Conditions – Those with diabetes or heart disease may particularly benefit\n" +
                        "\n" +
                        "The Bottom Line\n" +
                        "A diet abundant in colorful plant foods provides a spectrum of antioxidants that work synergistically to combat oxidative stress." +
                        " While supplements may help in specific cases, they cannot replicate the complex nutritional matrix of whole foods. " +
                        "For optimal health, " +
                        "focus on consuming at least 5-9 servings of varied fruits and vegetables daily, along with nuts, seeds, and herbs.</p>",
                "image", "/images/antioxidants.jpg"
        ));
        articles.put(9L, Map.of(
                "title", "The Gut-Brain Connection | How Whole Foods Impact Mental Health",
                "content", "<p>The gut-brain connection highlights how whole foods rich in fiber, probiotics, and omega-3s can improve mood," +
                        " reduce anxiety, and support mental clarity..." +
                        "The Gut-Brain Axis: How Your Digestive Health Shapes Mental Wellbeing\n" +
                        "The Vital Communication Network Between Gut and Brain\n" +
                        "Emerging research reveals a profound bidirectional relationship between our digestive system and cognitive function, known as the gut-brain axis. This complex communication network involves:\n" +
                        "\n" +
                        "The vagus nerve – A direct neural pathway transmitting signals between gut and brain\n" +
                        "\n" +
                        "Neurotransmitter production – 90% of serotonin (the \"feel-good\" chemical) originates in the gut\n" +
                        "\n" +
                        "Microbial influence – Trillions of gut bacteria produce compounds affecting mood and cognition\n" +
                        "\n" +
                        "Nutritional Strategies for Optimal Gut-Brain Health\n" +
                        "1. Feed Your Microbiome\n" +
                        "\n" +
                        "Prebiotic foods: Garlic, onions, bananas (fuel beneficial bacteria growth)\n" +
                        "\n" +
                        "Probiotic foods: Yogurt, kefir, sauerkraut (introduce helpful microbes)\n" +
                        "\n" +
                        "Polyphenol-rich foods: Berries, dark chocolate, green tea (support microbial diversity)\n" +
                        "\n" +
                        "2. Reduce Inflammatory Triggers\n" +
                        "\n" +
                        "Limit processed foods, refined sugars, and artificial additives\n" +
                        "\n" +
                        "Identify and manage food sensitivities\n" +
                        "\n" +
                        "Choose anti-inflammatory fats (omega-3s from fish, walnuts, flaxseeds)\n" +
                        "\n" +
                        "3. Support Gut Barrier Function\n" +
                        "\n" +
                        "Bone broth (rich in gut-healing collagen)\n" +
                        "\n" +
                        "Fiber-rich vegetables (promote mucus production)\n" +
                        "\n" +
                        "Fermented foods (enhance gut lining integrity)\n" +
                        "\n" +
                        "The Mental Health Connection\n" +
                        "Clinical studies demonstrate:\n" +
                        "✔ Mediterranean diet adherents show 35% lower depression risk\n" +
                        "✔ Probiotic supplementation can reduce anxiety symptoms\n" +
                        "✔ Gut dysbiosis is linked to higher rates of ADHD and autism spectrum disorders\n" +
                        "\n" +
                        "Practical Dietary Adjustments\n" +
                        "Morning routine: Start with warm lemon water + flaxseed\n" +
                        "\n" +
                        "Meal composition: 50% colorful vegetables, 25% quality protein, 25% whole grains\n" +
                        "\n" +
                        "Snack smart: Raw nuts, sliced veggies with hummus\n" +
                        "\n" +
                        "Hydration: Herbal teas (chamomile, ginger) support digestion\n" +
                        "\n" +
                        "When to Seek Professional Guidance\n" +
                        "Consult a functional medicine practitioner if experiencing:\n" +
                        "\n" +
                        "Persistent digestive issues with mood changes\n" +
                        "\n" +
                        "Unexplained anxiety or brain fog\n" +
                        "\n" +
                        "Food sensitivities impacting quality of life\n" +
                        "\n" +
                        "The Bottom Line\n" +
                        "Nourishing your gut microbiome through targeted nutrition offers a powerful avenue for enhancing mental wellbeing." +
                        " By prioritizing whole, fiber-rich foods and minimizing processed items," +
                        " we cultivate an internal ecosystem that supports both cognitive function and emotional resilience.</p>",
                "image", "/images/gut-brain.jpg"
        ));
    }

    @GetMapping("/nutrition")
    public String nutrition(Model model) {
        model.addAttribute("pageTitle", "Nutrition and Whole Foods");
        return "nutrition";
    }

    @GetMapping("/nutrition-article-details")
    public String articleDetails(@RequestParam("id") Long id, Model model) {
        Map<String, String> article = articles.get(id);
        if (article == null) {
            return "redirect:/nutrition"; // Ако статията не съществува, връщаме към основната страница
        }
        model.addAttribute("article", article);
        return "nutrition-article-details";
    }
}
