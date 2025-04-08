document.addEventListener('DOMContentLoaded', function () {
    const hamburger = document.querySelector('.hamburger');
    const menu = document.querySelector('.menu');

    // Отваряне/затваряне на основното меню
    hamburger.addEventListener('click', () => {
        hamburger.classList.toggle('active');
        menu.classList.toggle('active');
    });

    // Затваряне на менюто при клик на линк от основното меню
    menu.querySelectorAll('a:not(.name)').forEach(link => {
        link.addEventListener('click', () => {
            hamburger.classList.remove('active');
            menu.classList.remove('active');
        });
    });

    // Отваряне/затваряне на подменютата на малки екрани
    const menuItemsWithDropdown = menu.querySelectorAll('li:has(.dropdown) > a');
    menuItemsWithDropdown.forEach(item => {
        item.addEventListener('click', (e) => {
            if (window.innerWidth <= 768) {
                e.preventDefault();
                const parentLi = item.parentElement;
                const isActive = parentLi.classList.contains('active');
                // Затваряме всички други подменюта
                menu.querySelectorAll('li.active').forEach(li => {
                    if (li !== parentLi) li.classList.remove('active');
                });
                // Отваряме/затваряме текущото подменю
                parentLi.classList.toggle('active', !isActive);
            }
        });
    });
});