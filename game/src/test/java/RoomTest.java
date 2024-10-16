/*import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
    @Test
    public void testRoomCreation() {
        Room room = new Room("A dark room");
        assertEquals("A dark room", room.getDescription());
    }

    @Test
    public void testRoomConnections() {
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");

        room1.setNextRoom(room2);
        room2.setPreviousRoom(room1);

        assertEquals(room2, room1.getNextRoom());
        assertEquals(room1, room2.getPreviousRoom());
    }
}*/