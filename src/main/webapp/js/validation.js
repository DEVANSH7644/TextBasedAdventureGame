function validateForm() {
    let isValid = true;

    // Clear previous error messages
    document.getElementById("nameError").innerHTML = "";
    document.getElementById("healthError").innerHTML = "";
    document.getElementById("locationError").innerHTML = "";
    document.getElementById("inventoryError").innerHTML = "";

    // Validate player name
    const name = document.getElementById("name").value;
    if (name.trim() === "") {
        document.getElementById("nameError").innerHTML = "Player name is required!";
        isValid = false;
    }

    // Validate health
    const health = document.getElementById("health").value;
    if (health <= 0 || isNaN(health)) {
        document.getElementById("healthError").innerHTML = "Please enter a valid health value greater than 0!";
        isValid = false;
    }

    // Validate location
    const location = document.getElementById("location").value;
    if (location.trim() === "") {
        document.getElementById("locationError").innerHTML = "Location is required!";
        isValid = false;
    }

    // Validate inventory
    const inventory = document.getElementById("inventory").value;
    if (inventory.trim() === "") {
        document.getElementById("inventoryError").innerHTML = "Inventory is required!";
        isValid = false;
    }

    return isValid;
}
