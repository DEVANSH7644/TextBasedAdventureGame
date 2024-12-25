import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

public class PlayerServlet extends HttpServlet {

    private PlayerService playerService;

    public PlayerServlet() {
        this.playerService = new PlayerService(new PlayerDAO()); // Default constructor; inject DAO and other services
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null || action.isEmpty()) {
            List<Player> players = playerService.getAllPlayers();
            request.setAttribute("players", players);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewPlayers.jsp");
            dispatcher.forward(request, response);
        } else if ("view".equals(action)) {
            String name = request.getParameter("name");
            Player player = playerService.getPlayerByName(name);
            request.setAttribute("player", player);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/viewPlayer.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("update".equals(action)) {
            String name = request.getParameter("name");
            int health = Integer.parseInt(request.getParameter("health"));
            String location = request.getParameter("location");
            String inventory = request.getParameter("inventory");

            Player player = new Player(name, health, location, inventory);
            playerService.updatePlayer(player);

            response.sendRedirect("PlayerServlet?action=view&name=" + name);
        } else if ("create".equals(action)) {
            String name = request.getParameter("name");
            int health = Integer.parseInt(request.getParameter("health"));
            String location = request.getParameter("location");
            String inventory = request.getParameter("inventory");

            Player player = new Player(name, health, location, inventory);
            playerService.createPlayer(player);

            response.sendRedirect("PlayerServlet");
        }
    }
}
