// JavaScript (login.js)
document.addEventListener("DOMContentLoaded", function () {
    var loginForm = document.getElementById("loginForm");

    if (loginForm) {
        loginForm.addEventListener("submit", function (event) {
            var userEmail = document.getElementById("user_email").value;
            var userPassword = document.getElementById("user_password").value;

            // Clear any previous error messages
            clearErrorMessage();

            if (!userEmail || !userPassword) {
                event.preventDefault(); // Prevent form submission
                displayErrorMessage("Please fill in both username and password.");
            } else {
                // You can make an AJAX request to handle authentication on the server
                // For demonstration purposes, let's simulate an authentication error
                if (simulateAuthenticationError()) {
                    event.preventDefault(); // Prevent form submission
                    displayErrorMessage("Invalid username or password.");
                }
            }
        });
    }
});

function simulateAuthenticationError() {
    // Simulate an authentication error (return true to simulate an error)
    // In a real application, this would be handled by your server logic
    return false;
}

function displayErrorMessage(message) {
    var errorMessageContainer = document.getElementById("error-message");

    if (errorMessageContainer) {
        errorMessageContainer.innerText = message;
        errorMessageContainer.style.display = "block";
    }
}

function clearErrorMessage() {
    var errorMessageContainer = document.getElementById("error-message");

    if (errorMessageContainer) {
        errorMessageContainer.innerText = "";
        errorMessageContainer.style.display = "none";
    }
}

function togglePasswordVisibility() {
    var passwordInput = document.getElementById("user_password");

    if (passwordInput.type === "password") {
        passwordInput.type = "text";
    } else {
        passwordInput.type = "password";
    }
}
