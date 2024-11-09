package com.user.dao;

import com.user.model.Player;
import com.user.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDao {

    // Save a new player to the database
    public void savePlayer(Player player) throws SQLException {
        String query = "INSERT INTO players (name, health, location, inventory) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, player.getName());
            stmt.setInt(2, player.getHealth());
            stmt.setString(3, player.getLocation());
            stmt.setString(4, player.getInventory());

            stmt.executeUpdate();
            System.out.println("Player saved successfully!");
        }
    }

    // Retrieve a player by name
    public Player getPlayer(String playerName) throws SQLException {
        String query = "SELECT * FROM players WHERE name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, playerName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Player(
                        rs.getString("name"),
                        rs.getInt("health"),
                        rs.getString("location"),
                        rs.getString("inventory")
                );
            }
        }
        return null;
    }

    // Update player details in the database
    public void updatePlayer(Player player) throws SQLException {
        String query = "UPDATE players SET health = ?, location = ?, inventory = ? WHERE name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, player.getHealth());
            stmt.setString(2, player.getLocation());
            stmt.setString(3, player.getInventory());
            stmt.setString(4, player.getName());

            stmt.executeUpdate();
            System.out.println("Player updated successfully!");
        }
    }

    // Delete a player by name
    public void deletePlayer(String playerName) throws SQLException {
        String query = "DELETE FROM players WHERE name = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, playerName);
            stmt.executeUpdate();
            System.out.println("Player deleted successfully!");
        }
    }

    // Retrieve all players
    public List<Player> getAllPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM players";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Player player = new Player(
                        rs.getString("name"),
                        rs.getInt("health"),
                        rs.getString("location"),
                        rs.getString("inventory")
                );
                players.add(player);
            }
        }
        return players;
    }
}
