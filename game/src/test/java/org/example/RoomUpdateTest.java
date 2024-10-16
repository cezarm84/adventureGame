package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoomUpdateTest {
    @Test
    public void testRoomExits() {
        RoomUpdate room1 = new RoomUpdate("Room 1");
        RoomUpdate room2 = new RoomUpdate("Room 2");

        room1.setExit(Directions.NORTH, room2);
        assertEquals(room2, room1.getExit(Directions.NORTH));
    }

    @Test
    public void testRoomItems() {
        RoomUpdate room = new RoomUpdate("Test Room");
        Item item = new Item("Key", "A golden key");

        room.addItem(item);
        assertTrue(room.getItems().contains(item));

        room.removeItem(item);
        assertFalse(room.getItems().contains(item));
    }

    @Test
    public void testRoomNPCs() {
        RoomUpdate room = new RoomUpdate("Test Room");
        NPC npc = new NPC("Bob");

        room.addNPC(npc);
        assertTrue(room.getNPCs().contains(npc));
    }
}