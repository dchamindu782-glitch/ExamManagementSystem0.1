(function () {
    const themeKey = 'school-sis-theme';
    const savedTheme = localStorage.getItem(themeKey);
    const initialTheme = savedTheme === 'dark' ? 'dark' : 'light';

    function applyTheme(theme) {
        const isDark = theme === 'dark';
        document.documentElement.classList.toggle('dark', isDark);
        document.querySelectorAll('[data-theme-toggle]').forEach(button => {
            const icon = button.querySelector('[data-theme-icon]');
            const label = button.querySelector('[data-theme-label]');
            const nextMode = isDark ? 'light' : 'dark';

            button.setAttribute('aria-label', `Switch to ${nextMode} mode`);
            button.setAttribute('aria-pressed', String(isDark));
            button.setAttribute('title', `Switch to ${nextMode} mode`);
            if (icon) {
                icon.className = `fa-solid ${isDark ? 'fa-sun' : 'fa-moon'}`;
            }
            if (label) {
                label.textContent = isDark ? 'Light mode' : 'Dark mode';
            }
        });
    }

    applyTheme(initialTheme);

    document.addEventListener('DOMContentLoaded', function () {
        document.querySelectorAll('[data-theme-toggle]').forEach(button => {
            button.addEventListener('click', function () {
                const nextTheme = document.documentElement.classList.contains('dark') ? 'light' : 'dark';
                localStorage.setItem(themeKey, nextTheme);
                applyTheme(nextTheme);
            });
        });
        applyTheme(document.documentElement.classList.contains('dark') ? 'dark' : 'light');
    });
})();
