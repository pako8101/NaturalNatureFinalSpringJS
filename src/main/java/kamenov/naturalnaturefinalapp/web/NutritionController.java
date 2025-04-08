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
                "content", "<p>Whole foods like fruits and vegetables are naturally high in water content, helping you stay hydrated. Proper hydration supports digestion, skin health, and cognitive function...</p>",
                "image", "/images/hydration.jpg"
        ));
        articles.put(5L, Map.of(
                "title", "Cooking Techniques For Preserving Nutrients In Whole Foods",
                "content", "<p>Steaming, sautéing, and roasting are great techniques for preserving nutrients in whole foods. Avoid overcooking vegetables to retain their vitamins and minerals...</p>",
                "image", "/images/cooking-techniques.jpg"
        ));
        articles.put(6L, Map.of(
                "title", "Family Nutrition | Tips For Raising Healthy Eaters With Whole Foods",
                "content", "<p>Involve kids in meal prep, offer a variety of whole foods, and make healthy eating fun to encourage lifelong healthy habits...</p>",
                "image", "/images/family-nutrition.jpg"
        ));
        articles.put(7L, Map.of(
                "title", "Plant-Based Nutrition | A Comprehensive Guide To A Vegan Diet",
                "content", "<p>A plant-based diet focuses on whole foods like vegetables, fruits, grains, and legumes. It’s rich in fiber, vitamins, and antioxidants, and can reduce the risk of chronic diseases...</p>",
                "image", "/images/plant-based.jpg"
        ));
        articles.put(8L, Map.of(
                "title", "The Role Of Antioxidants In Whole Food Nutrition",
                "content", "<p>Antioxidants in whole foods, such as berries, nuts, and leafy greens, protect your cells from damage and reduce inflammation...</p>",
                "image", "/images/antioxidants.jpg"
        ));
        articles.put(9L, Map.of(
                "title", "The Gut-Brain Connection | How Whole Foods Impact Mental Health",
                "content", "<p>The gut-brain connection highlights how whole foods rich in fiber, probiotics, and omega-3s can improve mood, reduce anxiety, and support mental clarity...</p>",
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
