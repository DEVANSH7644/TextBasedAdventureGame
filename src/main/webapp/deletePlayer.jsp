<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Player</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Delete Player</h1>
        <form action="PlayerServlet" method="post">
            <input type="hidden" name="action" value="delete">
            <div class="form-group">
                <label for="name">Player Name</label>
                <input type="text" class="form-control" id="name" name="name" required>
            </div>
            <button type="submit" class="btn btn-danger">Delete Player</button>
        </form>
    </div>
</body>
</html>
