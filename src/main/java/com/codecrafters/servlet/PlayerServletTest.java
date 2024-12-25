import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class PlayerServletTest {

    @Mock
    private PlayerService playerServiceMock;  // Mocked PlayerService

    @Mock
    private HttpServletRequest requestMock;  // Mocked HttpServletRequest

    @Mock
    private HttpServletResponse responseMock;  // Mocked HttpServletResponse

    @Mock
    private RequestDispatcher dispatcherMock;  // Mocked RequestDispatcher

    private PlayerServlet playerServlet;

    @Before
    public void setUp() {
        // Initialize mocks and the servlet
        MockitoAnnotations.initMocks(this);
        playerServlet = new PlayerServlet();
        playerServlet.playerService = playerServiceMock;  // Inject mock service
    }

    @Test
    public void testDoGetWithoutAction() throws Exception {
        // Mock the behavior of the request and response
        when(requestMock.getParameter("action")).thenReturn(null);
        List<Player> players = new ArrayList<>();
        players.add(new Player("John", 100, "Forest", "Sword"));
        players.add(new Player("Jane", 80, "Village", "Bow"));
        when(playerServiceMock.getAllPlayers()).thenReturn(players);

        when(requestMock.getRequestDispatcher("/viewPlayers.jsp")).thenReturn(dispatcherMock);

        // Call the doGet method
        playerServlet.doGet(requestMock, responseMock);

        // Verify the correct methods were called
        verify(playerServiceMock, times(1)).getAllPlayers();
        verify(requestMock, times(1)).setAttribute("players", players);
        verify(dispatcherMock, times(1)).forward(requestMock, responseMock);
    }

    @Test
    public void testDoGetWithViewAction() throws Exception {
        // Mock the behavior of the request and response
        when(requestMock.getParameter("action")).thenReturn("view");
        when(requestMock.getParameter("name")).thenReturn("John");

        Player player = new Player("John", 100, "Forest", "Sword");
        when(playerServiceMock.getPlayerByName("John")).thenReturn(player);

        when(requestMock.getRequestDispatcher("/viewPlayer.jsp")).thenReturn(dispatcherMock);

        // Call the doGet method
        playerServlet.doGet(requestMock, responseMock);

        // Verify the correct methods were called
        verify(playerServiceMock, times(1)).getPlayerByName("John");
        verify(requestMock, times(1)).setAttribute("player", player);
        verify(dispatcherMock, times(1)).forward(requestMock, responseMock);
    }

    @Test
    public void testDoPostCreatePlayer() throws Exception {
        // Mock the behavior of the request and response
        when(requestMock.getParameter("action")).thenReturn("create");
        when(requestMock.getParameter("name")).thenReturn("John");
        when(requestMock.getParameter("health")).thenReturn("100");
        when(requestMock.getParameter("location")).thenReturn("Forest");
        when(requestMock.getParameter("inventory")).thenReturn("Sword");

        Player player = new Player("John", 100, "Forest", "Sword");

        // Call the doPost method
        playerServlet.doPost(requestMock, responseMock);

        // Verify that the player was created and redirect occurred
        verify(playerServiceMock, times(1)).createPlayer(player);
        verify(responseMock, times(1)).sendRedirect("PlayerServlet");
    }

    @Test
    public void testDoPostUpdatePlayer() throws Exception {
        // Mock the behavior of the request and response
        when(requestMock.getParameter("action")).thenReturn("update");
        when(requestMock.getParameter("name")).thenReturn("John");
        when(requestMock.getParameter("health")).thenReturn("90");
        when(requestMock.getParameter("location")).thenReturn("Mountain");
        when(requestMock.getParameter("inventory")).thenReturn("Bow");

        Player player = new Player("John", 90, "Mountain", "Bow");

        // Call the doPost method
        playerServlet.doPost(requestMock, responseMock);

        // Verify that the player was updated and the redirect occurred
        verify(playerServiceMock, times(1)).updatePlayer(player);
        verify(responseMock, times(1)).sendRedirect("PlayerServlet?action=view&name=John");
    }
}
