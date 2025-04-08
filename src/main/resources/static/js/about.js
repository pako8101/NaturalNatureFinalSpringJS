document.addEventListener('DOMContentLoaded', function () {
    // Анимация при скрол за картите
    const cards = document.querySelectorAll('.mission-card, .future-card, .think-card');

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('visible');
                observer.unobserve(entry.target);
            }
        });
    }, {
        threshold: 0.1
    });

    cards.forEach(card => {
        observer.observe(card);
    });

    // Функция за показване/скриване на допълнителна информация
    window.toggleLearnMore = function(id, button) {
        const element = document.getElementById(id);
        const isExpanded = element.classList.contains('expanded');

        if (isExpanded) {
            element.style.maxHeight = null;
            element.style.opacity = '0';
            element.classList.remove('expanded');
            button.textContent = 'More';
        } else {
            element.style.maxHeight = element.scrollHeight + 'px';
            element.style.opacity = '1';
            element.classList.add('expanded');
            button.textContent = 'Less';
        }
    };
});