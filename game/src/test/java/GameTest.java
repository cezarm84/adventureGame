import org.junit.jupiter.api.BeforeEach;
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
        room3 = new Room("You are in yourself in a wonderful library.");

        room1.setNextRoom(room2);
        room2.setPreviousRoom(room1);
        room2.setNextRoom(room3);
        room3.setPreviousRoom(room2);

        player = new Player(room2);
        game = new Game(player);
    }

    @Test
    public void testMoveForward() {
        assertEquals("You move forward to the next room.", game.executeCommand("go forward"));
        assertEquals(room3, player.getCurrentRoom());
    }

    @Test
    public void testMoveBack() {
        assertEquals("You move back to the previous room.", game.executeCommand("go back"));
        assertEquals(room1, player.getCurrentRoom());
    }

    @Test
    public void testLookAround() {
        assertEquals("You enter a bright, spacious hall.", game.executeCommand("look around"));
    }

    @Test
    public void testInvalidCommand() {
        assertEquals("I don't understand that command.", game.executeCommand("jump"));
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