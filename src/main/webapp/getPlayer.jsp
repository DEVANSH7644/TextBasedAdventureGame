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
        <h1 class="mt-5">Get Player</h1>
        <form action="PlayerServlet" method="get">
            <input type="hidden" name="action" value="get">
            <div class="form-group">
                <label for="name">Player Name</label>
                <input type="text" class="form-control" id="name" name="name" value="${player.name}" required>
            </div>
            <button type="submit" class="btn btn-primary">Get Player</button>
        </form>

        <c:if test="${not empty player}">
            <div class="mt-4">
                <h3>Player Details:</h3>
                <p>Name: ${player.name}</p>
                <p>Health: ${player.health}</p>
                <p>Location: ${player.location}</p>
                <p>Inventory: ${player.inventory}</p>
            </div>
        </c:if>

        <c:if test="${empty player}">
            <p>No player found. Please check the name and try again.</p>
        </c:if>
    </div>
</body>
</html>
