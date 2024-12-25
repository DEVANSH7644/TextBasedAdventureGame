<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Get Player</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Player Details</h1>

        <c:if test="${empty player}">
            <div class="alert alert-warning">Player not found!</div>
        </c:if>

        <c:if test="${not empty player}">
            <p><strong>Name:</strong> ${player.name}</p>
            <p><strong>Health:</strong> ${player.health}</p>
            <p><strong>Location:</strong> ${player.location}</p>
            <p><strong>Inventory:</strong> ${player.inventory}</p>
        </c:if>
    </div>
</body>
</html>
