document.addEventListener('DOMContentLoaded', () => {
    // Анимация при скрол
    const sections = document.querySelectorAll('.chapter, .articles-section');
    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.style.opacity = '1';
                entry.target.style.transform = 'translateY(0)';
            }
        });
    }, { threshold: 0.1 });

    sections.forEach(section => {
        section.style.opacity = '0';
        section.style.transform = 'translateY(50px)';
        section.style.transition = 'all 1s ease-in-out';
        observer.observe(section);
    });

    // Интерактивност за снимките
    const images = document.querySelectorAll('.content-image');
    images.forEach(image => {
        image.addEventListener('click', () => {
            image.classList.toggle('enlarged');
        });
    });

    // Анимация за таблицата
    const tableRows = document.querySelectorAll('.techniques-table tr');
    tableRows.forEach(row => {
        row.addEventListener('mouseover', () => {
            row.style.transform = 'scale(1.02)';
            row.style.transition = 'transform 0.3s ease';
        });
        row.addEventListener('mouseout', () => {
            row.style.transform = 'scale(1)';
        });
    });
});