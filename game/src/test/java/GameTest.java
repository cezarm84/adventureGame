/*import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;
    private Player player;
    private Room room1, room2, room3;

    @BeforeEach
    public void setUp() {
        room1 = new Room("You are in a dark room.");
        room2 = new Room("You enter a bright, large hall.");
        room3 = new Room("You are in a wonderful library.");

        room1.setNextRoom(room2);
        room2.setPreviousRoom(room1);
        room2.setNextRoom(room3);
        room3.setPreviousRoom(room2);

        player = new Player(room2);
        game = new Game(player);
    }

    @Test
    public void testMoveForward() {
        // Assuming player starts in room1 and moves to room2, and then to room3
        player.setCurrentRoom(room1); // Set  room

        // Move forward to room2
        assertEquals("You enter a bright, large hall.", game.executeCommand("go forward"));

        // Move forward to room3
        assertEquals("You are in a wonderful library.", game.executeCommand("go forward"));

        // Check if the player's current room is now room3
        assertEquals(room3.getDescription(), player.getCurrentRoom().getDescription());
    }

    @Test
    public void testMoveBack() {
        // Move forward to ensure we're in room2 first
        player.setCurrentRoom(room2);

        // Now, test moving back to room1
        assertEquals("You move back to the previous room.", game.executeCommand("go back"));

        // Assert that the current room is room1
        assertEquals(room1.getDescription(), player.getCurrentRoom().getDescription());
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
}*/