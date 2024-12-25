<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Text-Based Adventure Game</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="styles/style.css" rel="stylesheet">
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Text-Based Adventure Game</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="createPlayer.jsp">Create Player</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="viewPlayers.jsp">View Players</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="startGame.jsp">Start Game</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Main Content Section -->
    <div class="container mt-5">
        <h1 class="text-center">Welcome to the Text-Based Adventure Game</h1>
        <p class="text-center">Create your player and start your adventure!</p>
        
        <!-- Display List of Existing Players -->
        <c:if test="${not empty players}">
            <h3 class="text-center">Existing Players:</h3>
            <ul class="list-group">
                <c:forEach var="player" items="${players}">
                    <li class="list-group-item">
                        ${player.name} - ${player.health} Health, ${player.location} Location
                    </li>
                </c:forEach>
            </ul>
        </c:if>

        <c:if test="${empty players}">
            <p class="text-center">No players available. Please create a new player!</p>
        </c:if>

        <!-- Link to Create New Player -->
        <div class="row justify-content-center mt-4">
            <div class="col-lg-6 col-md-8">
                <a href="createPlayer.jsp" class="btn btn-success btn-block">Create New Player</a>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <footer class="bg-dark text-white text-center py-3">
        <p>&copy; 2024 Text-Based Adventure Game</p>
    </footer>

    <!-- Optional JavaScript -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
