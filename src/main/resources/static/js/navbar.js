document.addEventListener("DOMContentLoaded", function () {
    var currentPageUrl = window.location.pathname;
    var navLinks = document.querySelectorAll('.navbar-nav .nav-link');

    navLinks.forEach(function(link) {
        if (link.getAttribute('href') === currentPageUrl) {
            link.classList.add('active');
        }
    });

    var anchorLinks = document.querySelectorAll('.navbar-nav .nav-link[href^="#"]');

    anchorLinks.forEach(function(link) {
        link.addEventListener('click', function(e) {
            e.preventDefault();

            var targetId = this.getAttribute('href').substring(1);
            var targetElement = document.getElementById(targetId);

            if (targetElement) {
                window.scrollTo({
                    top: targetElement.offsetTop - 50,
                    behavior: 'smooth'
                });
            }
        });
    });
});
