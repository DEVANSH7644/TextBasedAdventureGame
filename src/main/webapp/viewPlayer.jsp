<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Player Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h1 class="mt-5">Player Details</h1>

        <!-- Check if player attribute is available -->
        <c:if test="${not empty player}">
            <div class="card mt-3">
                <div class="card-body">
                    <h3 class="card-title">${player.name}</h3>
                    <p><strong>Health:</strong> ${player.health}</p>
                    <p><strong>Location:</strong> ${player.location}</p>
                    <p><strong>Inventory:</strong> ${player.inventory}</p>
                </div>
            </div>
        </c:if>
        
        <!-- If no player is found, show an error message -->
        <c:if test="${empty player}">
            <div class="alert alert-danger mt-3">
                <strong>Error!</strong> Player not found.
            </div>
        </c:if>

        <!-- Back button to return to the player list or homepage -->
        <a href="viewPlayers.jsp" class="btn btn-info mt-3">Back to Players</a>
    </div>
</body>
</html>
