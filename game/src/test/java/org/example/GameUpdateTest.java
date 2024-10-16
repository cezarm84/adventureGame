package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class GameUpdateTest {
    private GameUpdate game;
    private PlayerUpdate player;
    private RoomUpdate startRoom;
    private RoomUpdate northRoom;
    private Item key;

    @BeforeEach
    public void setUp() {
        // Create rooms
        startRoom = new RoomUpdate("You are in the starting room.");
        northRoom = new RoomUpdate("You are in the north room.");
        RoomUpdate eastRoom = new RoomUpdate("You are in the east room.");


        // Set up room connections
        startRoom.setExit(Directions.NORTH, northRoom);
        startRoom.setExit(Directions.EAST, eastRoom);
        northRoom.setExit(Directions.SOUTH, startRoom);
        eastRoom.setExit(Directions.WEST, startRoom);

        // Create player and game
        player = new PlayerUpdate(startRoom);
        game = new GameUpdate(player);

        // Add items
        key = new Item("Key", "A golden key");
        startRoom.addItem(key);

        // Add NPCs
        NPC guard = new NPC("Guard");
        guard.addDialogue("default", "Hello, traveler!");
        startRoom.addNPC(guard);
    }

    @Test
    public void testInvalidCommand() {
        String result = game.executeCommand("invalid");
        assertEquals("I don't understand that command.", result);
    }

    @Test
    public void testMovement() {
        // Test valid movement
        String result = game.executeCommand("go north");
        String expected = "You move north\nYou are in the north room.\n";
        assertEquals(expected, result);


        // Test invalid direction
        result = game.executeCommand("go invalid");
        assertEquals("That's not a valid direction.", result);

        // Test movement to blocked direction
        result = game.executeCommand("go west");
        assertEquals("You can't go that way.", result);
    }

    @Test
    public void testLookAround() {
        String result = game.executeCommand("look");
        assertTrue(result.contains("You are in the starting room."));
        assertTrue(result.contains("You see: Key"));
        assertTrue(result.contains("There are some people here: Guard"));
    }

    @Test
    public void testLookAroundEmptyRoom() {
        RoomUpdate emptyRoom = new RoomUpdate("An empty room");
        player.setCurrentRoom(emptyRoom);
        String result = game.executeCommand("look");
        assertEquals("An empty room\n", result);
    }

    @Test
    public void testTakeItem() {
        // Test taking exist item
        String result = game.executeCommand("take Key");
        assertEquals("You pick up the key.", result);
        assertTrue(player.getInventory().contains(key));
        assertFalse(startRoom.getItems().contains(key));

        // Test taking non-exist item
        result = game.executeCommand("take sword");
        assertEquals("There's no sword here.", result);
    }

    @Test
    public void testDropItem() {
        // First take an item
        game.executeCommand("take key");

        // Test dropping  item
        String result = game.executeCommand("drop key");
        assertEquals("You drop the key.", result);
        assertFalse(player.getInventory().contains(key));
        assertTrue(startRoom.getItems().contains(key));

        // Test dropping non-exist item
        result = game.executeCommand("drop sword");
        assertEquals("You don't have a sword.", result);
    }

    @Test
    public void testCheckInventory() {
        // Test empty inventory
        String result = game.executeCommand("inventory");
        assertEquals("Your inventory is empty.", result);

        // Test inventory with items
        game.executeCommand("take Key");
        result = game.executeCommand("inventory");
        assertEquals("You are carrying: Key", result);
    }

    @Test
    public void testTalkToNPC() {
        // Test talking to existing NPC
        String result = game.executeCommand("talk Guard");
        assertEquals("You talk to Guard. They say: Hello, traveler!", result);

        // Test talking to non-existent NPC
        result = game.executeCommand("talk merchant");
        assertEquals("There's no one named merchant here.", result);
    }

    @Test
    public void testComplexScenario() {
        // Test a sequence of commands
        game.executeCommand("take Key");
        game.executeCommand("go north");
        game.executeCommand("drop Key");

        // Verify final state
        assertTrue(northRoom.getItems().contains(key));
        assertFalse(player.getInventory().contains(key));
        assertEquals(northRoom, player.getCurrentRoom());
    }
}