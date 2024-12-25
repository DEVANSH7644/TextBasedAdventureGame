import java.util.List;

public class PlayerService {

    private PlayerDAO playerDAO;

    // Constructor to initialize PlayerDAO
    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    // Method to create a new player
    public void createPlayer(Player player) {
        // Business logic for creating a player, validation, etc.
        if (player.getHealth() <= 0) {
            throw new IllegalArgumentException("Player health must be positive");
        }
        if (player.getName() == null || player.getName().isEmpty()) {
            throw new IllegalArgumentException("Player name cannot be empty");
        }
        playerDAO.save(player);  // Save player to the database
    }

    // Method to get a player by their name
    public Player getPlayerByName(String name) {
        Player player = playerDAO.getByName(name);
        if (player == null) {
            throw new IllegalArgumentException("Player with name " + name + " not found");
        }
        return player;
    }

    // Method to get all players
    public List<Player> getAllPlayers() {
        return playerDAO.getAll();  // Get all players from the database
    }

    // Method to update an existing player's details
    public void updatePlayer(Player player) {
        // Validate if the player exists before updating
        Player existingPlayer = playerDAO.getByName(player.getName());
        if (existingPlayer == null) {
            throw new IllegalArgumentException("Player with name " + player.getName() + " not found");
        }
        playerDAO.update(player);  // Update player details in the database
    }

    // Method to delete a player by their name
    public void deletePlayer(String name) {
        Player player = playerDAO.getByName(name);
        if (player == null) {
            throw new IllegalArgumentException("Player with name " + name + " not found");
        }
        playerDAO.delete(name);  // Delete player from the database
    }
}
