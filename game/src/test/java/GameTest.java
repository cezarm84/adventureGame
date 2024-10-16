import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {

    @Mock
    private Game game;

    @Mock
    private Player player;
    private Room room1, room2, room3;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        room1 = new Room("You are in a dark room.");
        room2 = new Room("You enter a bright, large hall.");
        room3 = new Room("You are in a wonderful library.");

        room1.setNextRoom(room2);
        room2.setPreviousRoom(room1);
        room2.setNextRoom(room3);
        room3.setPreviousRoom(room2);

        when(player.getCurrentRoom()).thenReturn(room1);
    }

    @Test
    public void testMoveForward() {
        when(game.executeCommand("go forward")).thenReturn("You move forward to the next room.");

        String result = game.executeCommand("go forward");
        assertEquals("You move forward to the next room.", result);

        // Additional verification if necessary
        verify(game).executeCommand("go forward");
    }

    @Test
    public void testMoveBack() {
        when(player.getCurrentRoom()).thenReturn(room2);
        when(game.executeCommand("go back")).thenReturn("You move back to the previous room.");

        String result = game.executeCommand("go back");
        assertEquals("You move back to the previous room.", result);

        // Additional verification if necessary
        verify(game).executeCommand("go back");
    }

    @Test
    public void testLookAround() {
        assertEquals("You enter a bright, large hall.", game.executeCommand("look around"));
    }

    @Test
    public void testInvalidCommand() {
        assertEquals("I don't understand .", game.executeCommand("jump"));
    }

    @Test
    public void testMoveForwardNoNextRoom() {
        player.setCurrentRoom(room3);
        assertEquals("There is no room ahead.", game.executeCommand("go forward"));
    }

    @Test
    public void testMoveBackNoPreviousRoom() {
        player.setCurrentRoom(room1);
        assertEquals("There is no room behind you.", game.executeCommand("go back"));
    }
}