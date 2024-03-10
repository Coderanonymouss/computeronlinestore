// Updated JavaScript (main.js)
document.addEventListener("DOMContentLoaded", function () {
    // Example: Enhance login form with interactive features
    var loginForm = document.querySelector("form");
    if (loginForm) {
        loginForm.addEventListener("submit", function (event) {
            event.preventDefault(); // Prevent the form from submitting for demonstration purposes

            // Simulate a loading state
            var loginButton = document.querySelector(".btn-success");
            if (loginButton) {
                loginButton.innerHTML = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Logging in...';
                loginButton.setAttribute("disabled", true);

                // Simulate a delay (you can replace this with an actual AJAX request)
                setTimeout(function () {
                    // Reset the button after the delay
                    loginButton.innerHTML = 'Sign In';
                    loginButton.removeAttribute("disabled");

                    // Show a success message (you can replace this with your actual logic)
                    alert("Login successful!");
                }, 2000); // 2 seconds delay for demonstration
            }
        });
    }
});
