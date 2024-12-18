<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Player</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Update Player</h1>
        <form action="PlayerServlet" method="post">
            <input type="hidden" name="action" value="update">
            <div class="form-group">
                <label for="name">Player Name</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="health">Health</label>
                <input type="number" class="form-control" id="health" name="health" required>
            </div>
            <div class="form-group">
                <label for="location">Location</label>
                <input type="text" class="form-control" id="location" name="location" required>
            </div>
            <div class="form-group">
                <label for="inventory">Inventory</label>
                <input type="text" class="form-control" id="inventory" name="inventory" required>
            </div>
            <button type="submit" class="btn btn-warning">Update Player</button>
        </form>
    </div>
</body>
</html>
