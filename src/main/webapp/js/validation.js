document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("loginForm");
    const registerForm = document.getElementById("registerForm");

    const validateEmail = (email) => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);

    if (loginForm) {
        loginForm.addEventListener("submit", (e) => {
            const email = document.getElementById("email").value;
            const password = document.getElementById("password").value;

            if (!validateEmail(email)) {
                alert("Invalid email address!");
                e.preventDefault();
            } else if (password.length < 6) {
                alert("Password must be at least 6 characters!");
                e.preventDefault();
            }
        });
    }

    if (registerForm) {
        registerForm.addEventListener("submit", (e) => {
            const name = document.getElementById("name").value;
            const email = document.getElementById("email").value;
            const password = document.getElementById("password").value;

            if (name.trim().length < 3) {
                alert("Name must be at least 3 characters!");
                e.preventDefault();
            } else if (!validateEmail(email)) {
                alert("Invalid email address!");
                e.preventDefault();
            } else if (password.length < 6) {
                alert("Password must be at least 6 characters!");
                e.preventDefault();
            }
        });
    }
});
