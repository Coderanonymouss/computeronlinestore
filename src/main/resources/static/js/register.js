// password-toggle.js
document.addEventListener('DOMContentLoaded', function () {
    const passwordInput = document.getElementById('user_password');
    const confirmPasswordInput = document.getElementById('re_user_password');
    const togglePasswordButton = document.getElementById('toggle-password');

    // Event listener for toggling password visibility
    if (togglePasswordButton) {
        togglePasswordButton.addEventListener('click', function () {
            togglePasswordVisibility(passwordInput);
            togglePasswordVisibility(confirmPasswordInput);
        });
    }

    // Function to toggle password visibility
    function togglePasswordVisibility(inputElement) {
        const type = inputElement.getAttribute('type') === 'password' ? 'text' : 'password';
        inputElement.setAttribute('type', type);
    }
});
