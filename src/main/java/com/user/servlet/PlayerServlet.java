package com.user.servlet;

import com.user.model.Player;
import com.user.util.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/PlayerServlet")
public class PlayerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handling POST requests (Create, Update, Delete)
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        switch (action) {
            case "save":
                createPlayer(request, response);
                break;
            case "update":
                updatePlayer(request, response);
                break;
            case "delete":
                deletePlayer(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
                break;
        }
    }

    // Handling GET requests (Get Player details)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if ("get".equals(action)) {
            getPlayer(request, response);
        }
    }

    // Method to create a new player
    private void createPlayer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        int health = Integer.parseInt(request.getParameter("health"));
        String location = request.getParameter("location");
        String inventory = request.getParameter("inventory");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO players (name, health, location, inventory) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setInt(2, health);
                statement.setString(3, location);
                statement.setString(4, inventory);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
            return;
        }
        response.sendRedirect("index.jsp");
    }

    // Method to update an existing player
    private void updatePlayer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        int health = Integer.parseInt(request.getParameter("health"));
        String location = request.getParameter("location");
        String inventory = request.getParameter("inventory");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE players SET health = ?, location = ?, inventory = ? WHERE name = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, health);
                statement.setString(2, location);
                statement.setString(3, inventory);
                statement.setString(4, name);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
            return;
        }
        response.sendRedirect("viewPlayers.jsp");
    }

    // Method to delete a player
    private void deletePlayer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM players WHERE name = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
            return;
        }
        response.sendRedirect("viewPlayers.jsp");
    }

    // Method to get player details and display on the page
    private void getPlayer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        Player player = null;

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM players WHERE name = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                ResultSet resultSet = statement.executeQuery();
                
                if (resultSet.next()) {
                    player = new Player(resultSet.getString("name"),
                                        resultSet.getInt("health"),
                                        resultSet.getString("location"),
                                        resultSet.getString("inventory"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
            return;
        }

        if (player != null) {
            request.setAttribute("player", player);
            request.getRequestDispatcher("viewPlayer.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Player not found");
        }
    }
}
