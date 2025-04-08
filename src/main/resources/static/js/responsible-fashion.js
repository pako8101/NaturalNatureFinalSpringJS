// Плавно скролиране към секциите
document.addEventListener('DOMContentLoaded', () => {
    // Намираме всички линкове в навигацията
    const navLinks = document.querySelectorAll('.navbar-links a');

    navLinks.forEach(link => {
        link.addEventListener('click', (e) => {
            e.preventDefault(); // Предотвратяваме стандартното поведение на линка
            const targetId = link.getAttribute('href').substring(1); // Вземаме ID-то на секцията (напр. "introduction")
            const targetSection = document.getElementById(targetId);

            if (targetSection) {
                window.scrollTo({
                    top: targetSection.offsetTop - 70, // Отчитаме височината на навигацията
                    behavior: 'smooth' // Плавно скролиране
                });
            }
        });
    });

    // Анимация при скрол за .content-item и .article-card
    const elementsToAnimate = document.querySelectorAll('.content-item, .article-card');

    const observer = new IntersectionObserver((entries, observer) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('visible'); // Добавяме клас за анимация
                observer.unobserve(entry.target); // Спираме да наблюдаваме елемента
            }
        });
    }, {
        threshold: 0.1 // Елементът става видим, когато 10% от него влезе в полезрението
    });

    elementsToAnimate.forEach(element => {
        observer.observe(element); // Наблюдаваме всеки елемент
    });

    // Hover ефект за .content-item и .article-card
    const hoverElements = document.querySelectorAll('.content-item, .article-card');

    hoverElements.forEach(element => {
        element.addEventListener('mouseenter', () => {
            element.style.transition = 'transform 0.3s ease, box-shadow 0.3s ease';
            element.style.transform = 'scale(1.02)';
            element.style.boxShadow = '0 5px 15px rgba(0, 0, 0, 0.3)';
        });

        element.addEventListener('mouseleave', () => {
            element.style.transform = 'scale(1)';
            element.style.boxShadow = '0 3px 10px rgba(0, 0, 0, 0.1)';
        });
    });
});