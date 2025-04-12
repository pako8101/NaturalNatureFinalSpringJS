document.addEventListener('DOMContentLoaded', function () {
    // Паралакс ефект за Земята
    const earth = document.querySelector('.earth');
    window.addEventListener('scroll', function () {
        const scrollPosition = window.scrollY;
        earth.style.transform = `translateY(${scrollPosition * 0.3}px) rotate(${scrollPosition * 0.5}deg)`;
    });

    // Анимация при ховър за иконите в mission-section
    const iconCards = document.querySelectorAll('.icon-card');
    iconCards.forEach(card => {
        card.addEventListener('mouseenter', function () {
            const icon = card.querySelector('i');
            icon.style.transform = 'rotate(360deg)';
            icon.style.transition = 'transform 0.5s ease';
        });
        card.addEventListener('mouseleave', function () {
            const icon = card.querySelector('i');
            icon.style.transform = 'rotate(0deg)';
        });
    });
});