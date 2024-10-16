package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerUpdateTest {
    @Test
    public void testPlayerInventory() {
        RoomUpdate room = new RoomUpdate("Test Room");
        PlayerUpdate player = new PlayerUpdate(room);
        Item item = new Item("Coin", "A gold coin");

        room.addItem(item);
        player.pickUpItem(item);

        assertTrue(player.getInventory().contains(item));
        assertFalse(room.getItems().contains(item));

        player.dropItem(item);

        assertFalse(player.getInventory().contains(item));
        assertTrue(room.getItems().contains(item));
    }
}