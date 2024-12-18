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
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <button type="submit" class="btn btn-primary">Get Player</button>
        </form>

        <div class="mt-4">
            <h3>Player Details:</h3>
            <p id="playerDetails"></p>
        </div>
    </div>
</body>
</html>
