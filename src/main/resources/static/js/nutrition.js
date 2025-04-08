document.addEventListener('DOMContentLoaded', function () {
    const articles = [
        { id: 1, title: "The Benefits Of A Whole Foods Diet For Overall Health", summary: "Discover how a whole foods diet can improve your overall health and well-being.", content: "<p>A whole foods diet focuses on consuming unprocessed or minimally processed foods, such as fruits, vegetables, whole grains, nuts, seeds, and legumes. This approach provides a wide range of nutrients that support overall health, including improved digestion, better heart health, and enhanced energy levels...</p>", image: "/images/whole-foods-diet.jpg" },
        { id: 2, title: "Superfoods | What They Are And How To Incorporate Them Into Your Diet", summary: "Learn about superfoods and how to add them to your daily meals.", content: "<p>Superfoods are nutrient-dense foods that offer significant health benefits. Examples include quinoa, kale, chia seeds, and berries. To incorporate them into your diet, try adding chia seeds to smoothies, using quinoa as a base for salads, or snacking on fresh berries...</p>", image: "/images/superfoods.jpg" },
        { id: 3, title: "The Importance Of Organic And Non-Gmo Foods In A Healthy Diet", summary: "Understand why organic and non-GMO foods are essential for a healthy diet.", content: "<p>Organic and non-GMO foods are free from harmful pesticides and genetic modifications, making them a safer choice for your health. They also support sustainable farming practices and biodiversity...</p>", image: "/images/organic-foods.jpg" },
        { id: 4, title: "Hydration And Whole Foods | The Connection Between Water And Health", summary: "Explore the link between hydration, whole foods, and overall health.", content: "<p>Whole foods like fruits and vegetables are naturally high in water content, helping you stay hydrated. Proper hydration supports digestion, skin health, and cognitive function...</p>", image: "/images/hydration.jpg" },
        { id: 5, title: "Cooking Techniques For Preserving Nutrients In Whole Foods", summary: "Learn cooking methods to retain the nutrients in whole foods.", content: "<p>Steaming, sautéing, and roasting are great techniques for preserving nutrients in whole foods. Avoid overcooking vegetables to retain their vitamins and minerals...</p>", image: "/images/cooking-techniques.jpg" },
        { id: 6, title: "Family Nutrition | Tips For Raising Healthy Eaters With Whole Foods", summary: "Get tips on encouraging your family to eat whole foods.", content: "<p>Involve kids in meal prep, offer a variety of whole foods, and make healthy eating fun to encourage lifelong healthy habits...</p>", image: "/images/family-nutrition.jpg" },
        { id: 7, title: "Plant-Based Nutrition | A Comprehensive Guide To A Vegan Diet", summary: "A guide to adopting a plant-based diet with whole foods.", content: "<p>A plant-based diet focuses on whole foods like vegetables, fruits, grains, and legumes. It’s rich in fiber, vitamins, and antioxidants, and can reduce the risk of chronic diseases...</p>", image: "/images/plant-based.jpg" },
        { id: 8, title: "The Role Of Antioxidants In Whole Food Nutrition", summary: "Discover how antioxidants in whole foods benefit your health.", content: "<p>Antioxidants in whole foods, such as berries, nuts, and leafy greens, protect your cells from damage and reduce inflammation...</p>", image: "/images/antioxidants.jpg" },
        { id: 9, title: "The Gut-Brain Connection | How Whole Foods Impact Mental Health", summary: "Learn how whole foods can improve your mental health through the gut-brain connection.", content: "<p>The gut-brain connection highlights how whole foods rich in fiber, probiotics, and omega-3s can improve mood, reduce anxiety, and support mental clarity...</p>", image: "/images/gut-brain.jpg" }
    ];

    const articlesPerPage = 3;
    let currentPage = 1;
    const totalPages = Math.ceil(articles.length / articlesPerPage);

    const articlesList = document.getElementById('articles-list');
    const prevButton = document.getElementById('prev-page');
    const nextButton = document.getElementById('next-page');
    const pageInfo = document.getElementById('page-info');

    function displayArticles(page) {
        articlesList.innerHTML = '';
        const start = (page - 1) * articlesPerPage;
        const end = start + articlesPerPage;
        const paginatedArticles = articles.slice(start, end);

        paginatedArticles.forEach(article => {
            const articleCard = document.createElement('div');
            articleCard.classList.add('article-card');
            const articleLink = document.createElement('a');
            articleLink.href = `/nutrition-article-details?id=${article.id}`;
            articleLink.textContent = article.title;
            const articleTitle = document.createElement('h3');
            articleTitle.appendChild(articleLink);
            const articleSummary = document.createElement('p');
            articleSummary.textContent = article.summary;
            articleCard.appendChild(articleTitle);
            articleCard.appendChild(articleSummary);
            articlesList.appendChild(articleCard);
        });

        pageInfo.textContent = `Page ${page} of ${totalPages}`;
        prevButton.disabled = page === 1;
        nextButton.disabled = page === totalPages;
    }

    prevButton.addEventListener('click', () => {
        if (currentPage > 1) {
            currentPage--;
            displayArticles(currentPage);
        }
    });

    nextButton.addEventListener('click', () => {
        if (currentPage < totalPages) {
            currentPage++;
            displayArticles(currentPage);
        }
    });

    // Първоначално зареждане на статиите
    displayArticles(currentPage);
});