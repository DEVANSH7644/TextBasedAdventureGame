package com.user.servlet;

import com.user.dao.PlayerDao;
import com.user.model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/PlayerServlet")
public class PlayerServlet extends HttpServlet {

    private PlayerDao playerDao;

    @Override
    public void init() {
        playerDao = new PlayerDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "save":
                    savePlayer(request, response);
                    break;
                case "update":
                    updatePlayer(request, response);
                    break;
                case "delete":
                    deletePlayer(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "get":
                    getPlayer(request, response);
                    break;
                case "list":
                    listPlayers(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid action");
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void savePlayer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        int health = Integer.parseInt(request.getParameter("health"));
        String location = request.getParameter("location");
        String inventory = request.getParameter("inventory");

        Player player = new Player(name, health, location, inventory);
        playerDao.savePlayer(player);
        response.getWriter().println("Player saved successfully!");
    }

    private void getPlayer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        Player player = playerDao.getPlayer(name);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        if (player != null) {
            out.println("<h1>Player Details</h1>");
            out.println("<p>Name: " + player.getName() + "</p>");
            out.println("<p>Health: " + player.getHealth() + "</p>");
            out.println("<p>Location: " + player.getLocation() + "</p>");
            out.println("<p>Inventory: " + player.getInventory() + "</p>");
        } else {
            out.println("<h1>Player not found</h1>");
        }
    }

    private void listPlayers(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        List<Player> players = playerDao.getAllPlayers();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>All Players</h1>");
        for (Player player : players) {
            out.println("<p>Name: " + player.getName() + ", Health: " + player.getHealth()
                    + ", Location: " + player.getLocation() + ", Inventory: " + player.getInventory() + "</p>");
        }
    }

    private void updatePlayer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        int health = Integer.parseInt(request.getParameter("health"));
        String location = request.getParameter("location");
        String inventory = request.getParameter("inventory");

        Player player = new Player(name, health, location, inventory);
        playerDao.updatePlayer(player);
        response.getWriter().println("Player updated successfully!");
    }

    private void deletePlayer(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        playerDao.deletePlayer(name);
        response.getWriter().println("Player deleted successfully!");
    }
}
