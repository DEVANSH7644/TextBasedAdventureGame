import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import java.util.*;

public class PlayerServiceTest {

    @Mock
    private PlayerDAO playerDAOMock;  // Mocked PlayerDAO

    private PlayerService playerService;

    @Before
    public void setUp() {
        // Initialize mocks and create PlayerService instance
        MockitoAnnotations.initMocks(this);
        playerService = new PlayerService(playerDAOMock);
    }

    @Test
    public void testCreatePlayer() {
        // Create a sample player
        Player player = new Player("John", 100, "Forest", "Sword, Shield");

        // Call the method to create a player
        playerService.createPlayer(player);

        // Verify that the PlayerDAO's save method was called once with the same player
        verify(playerDAOMock, times(1)).save(player);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatePlayerWithInvalidHealth() {
        // Create a player with invalid health (<= 0)
        Player player = new Player("John", 0, "Forest", "Sword, Shield");

        // This should throw an IllegalArgumentException
        playerService.createPlayer(player);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreatePlayerWithEmptyName() {
        // Create a player with an empty name
        Player player = new Player("", 100, "Forest", "Sword, Shield");

        // This should throw an IllegalArgumentException
        playerService.createPlayer(player);
    }

    @Test
    public void testGetPlayerByName() {
        // Create a sample player
        Player player = new Player("John", 100, "Forest", "Sword, Shield");

        // Mock the DAO call to return the player
        when(playerDAOMock.getByName("John")).thenReturn(player);

        // Call the service method to get the player
        Player fetchedPlayer = playerService.getPlayerByName("John");

        // Verify that the fetched player matches the mock player
        assertNotNull(fetchedPlayer);
        assertEquals("John", fetchedPlayer.getName());
        assertEquals(100, fetchedPlayer.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetPlayerByNameNotFound() {
        // Mock the DAO call to return null (player not found)
        when(playerDAOMock.getByName("John")).thenReturn(null);

        // This should throw an IllegalArgumentException as player is not found
        playerService.getPlayerByName("John");
    }

    @Test
    public void testGetAllPlayers() {
        // Create a list of players
        List<Player> players = new ArrayList<>();
        players.add(new Player("John", 100, "Forest", "Sword"));
        players.add(new Player("Jane", 80, "Village", "Bow"));

        // Mock the DAO call to return the list of players
        when(playerDAOMock.getAll()).thenReturn(players);

        // Call the service method to get all players
        List<Player> fetchedPlayers = playerService.getAllPlayers();

        // Verify that the fetched players match the mocked list
        assertNotNull(fetchedPlayers);
        assertEquals(2, fetchedPlayers.size());
        assertEquals("John", fetchedPlayers.get(0).getName());
        assertEquals("Jane", fetchedPlayers.get(1).getName());
    }

    @Test
    public void testUpdatePlayer() {
        // Create a sample player
        Player player = new Player("John", 100, "Forest", "Sword, Shield");

        // Mock the DAO call to return the player when fetching by name
        when(playerDAOMock.getByName("John")).thenReturn(player);

        // Update player details
        player.setHealth(90);
        player.setLocation("Mountain");

        // Call the service method to update the player
        playerService.updatePlayer(player);

        // Verify that the DAO's update method was called once with the updated player
        verify(playerDAOMock, times(1)).update(player);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdatePlayerNotFound() {
        // Create a player with updated details
        Player player = new Player("John", 100, "Forest", "Sword, Shield");

        // Mock the DAO call to return null (player not found)
        when(playerDAOMock.getByName("John")).thenReturn(null);

        // This should throw an IllegalArgumentException as player does not exist
        playerService.updatePlayer(player);
    }

    @Test
    public void testDeletePlayer() {
        // Create a sample player
        Player player = new Player("John", 100, "Forest", "Sword, Shield");

        // Mock the DAO call to return the player when fetching by name
        when(playerDAOMock.getByName("John")).thenReturn(player);

        // Call the service method to delete the player
        playerService.deletePlayer("John");

        // Verify that the DAO's delete method was called once with the player's name
        verify(playerDAOMock, times(1)).delete("John");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeletePlayerNotFound() {
        // Mock the DAO call to return null (player not found)
        when(playerDAOMock.getByName("John")).thenReturn(null);

        // This should throw an IllegalArgumentException as player does not exist
        playerService.deletePlayer("John");
    }
}
