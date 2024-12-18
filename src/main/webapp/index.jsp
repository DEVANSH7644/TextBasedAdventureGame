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
        
        <div class="row justify-content-center">
            <div class="col-lg-6 col-md-8">
                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title text-center">Create a New Player</h3>
                        <form id="createPlayerForm" action="createPlayer" method="POST" onsubmit="return validateForm()">
                            <div class="form-group">
                                <label for="name">Player Name</label>
                                <input type="text" class="form-control" id="name" name="name" required placeholder="Enter Player Name">
                                <small id="nameError" class="form-text text-danger"></small>
                            </div>
                            <div class="form-group">
                                <label for="health">Health</label>
                                <input type="number" class="form-control" id="health" name="health" required placeholder="Enter Player Health" min="1">
                                <small id="healthError" class="form-text text-danger"></small>
                            </div>
                            <div class="form-group">
                                <label for="location">Location</label>
                                <input type="text" class="form-control" id="location" name="location" required placeholder="Enter Player Location">
                                <small id="locationError" class="form-text text-danger"></small>
                            </div>
                            <div class="form-group">
                                <label for="inventory">Inventory</label>
                                <input type="text" class="form-control" id="inventory" name="inventory" required placeholder="Enter Player Inventory">
                                <small id="inventoryError" class="form-text text-danger"></small>
                            </div>
                            <button type="submit" class="btn btn-success btn-block">Create Player</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="row justify-content-center mt-4">
            <div class="col-lg-6 col-md-8">
                <a href="viewPlayers.jsp" class="btn btn-info btn-block">View Existing Players</a>
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

    <!-- Custom JS for Form Validation -->
    <script src="js/validation.js"></script>
</body>
</html>

