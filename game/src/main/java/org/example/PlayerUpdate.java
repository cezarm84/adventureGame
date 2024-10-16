package org.example;

import java.util.ArrayList;
import java.util.List;

public class PlayerUpdate {
    private RoomUpdate currentRoom;
    private List<Item> inventory;

    public PlayerUpdate(RoomUpdate startingRoom) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
    }

    public void pickUpItem(Item item) {
        currentRoom.removeItem(item);
        inventory.add(item);
    }

    public void dropItem(Item item) {
        inventory.remove(item);
        currentRoom.addItem(item);
    }

    public List<Item> getInventory() {
        return new ArrayList<>(inventory);
    }

    public RoomUpdate getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(RoomUpdate nextRoom) {
        this.currentRoom = nextRoom;
    }
}