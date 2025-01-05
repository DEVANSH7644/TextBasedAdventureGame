package com.codecrafters.dao;

import com.codecrafters.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerDAOTest {

    private PlayerDAO playerDAO;

    @Mock
    private Connection mockConnection;

    @Mock
    private PreparedStatement mockPreparedStatement;

    @Mock
    private ResultSet mockResultSet;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.openMocks(this); // Initializes mocks
        playerDAO = new PlayerDAO();
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
    }

    @Test
    void testCreatePlayer() throws SQLException {
        Player player = new Player("Test Player", 100, "Test Location", "Sword");

        // Mocking the behavior of the database interaction
        when(mockPreparedStatement.executeUpdate()).thenReturn(1); // Simulating successful insertion

        int result = playerDAO.createPlayer(player);

        assertEquals(1, result);
        verify(mockPreparedStatement).setString(1, player.getName());
        verify(mockPreparedStatement).setInt(2, player.getHealth());
        verify(mockPreparedStatement).setString(3, player.getLocation());
        verify(mockPreparedStatement).setString(4, player.getInventory());
    }

    @Test
    void testGetPlayer() throws SQLException {
        Player expectedPlayer = new Player("Test Player", 100, "Test Location", "Sword");

        // Mocking the behavior of the database interaction
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getString("name")).thenReturn(expectedPlayer.getName());
        when(mockResultSet.getInt("health")).thenReturn(expectedPlayer.getHealth());
        when(mockResultSet.getString("location")).thenReturn(expectedPlayer.getLocation());
        when(mockResultSet.getString("inventory")).thenReturn(expectedPlayer.getInventory());

        Player actualPlayer = playerDAO.getPlayer("Test Player");

        assertNotNull(actualPlayer);
        assertEquals(expectedPlayer.getName(), actualPlayer.getName());
        assertEquals(expectedPlayer.getHealth(), actualPlayer.getHealth());
        assertEquals(expectedPlayer.getLocation(), actualPlayer.getLocation());
        assertEquals(expectedPlayer.getInventory(), actualPlayer.getInventory());
    }

    @Test
    void testUpdatePlayer() throws SQLException {
        Player player = new Player("Test Player", 100, "Test Location", "Sword");

        // Mocking the behavior of the database interaction
        when(mockPreparedStatement.executeUpdate()).thenReturn(1); // Simulating successful update

        int result = playerDAO.updatePlayer(player);

        assertEquals(1, result);
        verify(mockPreparedStatement).setString(1, player.getName());
        verify(mockPreparedStatement).setInt(2, player.getHealth());
        verify(mockPreparedStatement).setString(3, player.getLocation());
        verify(mockPreparedStatement).setString(4, player.getInventory());
    }

    @Test
    void testDeletePlayer() throws SQLException {
        String playerName = "Test Player";

        // Mocking the behavior of the database interaction
        when(mockPreparedStatement.executeUpdate()).thenReturn(1); // Simulating successful delete

        int result = playerDAO.deletePlayer(playerName);

        assertEquals(1, result);
        verify(mockPreparedStatement).setString(1, playerName);
    }
}
