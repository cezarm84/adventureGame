package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomUpdate{
    private String description;
    private final Map<Directions, RoomUpdate> exits;
    private List<Item> items;
    private List<NPC> npcs;

    public RoomUpdate(String description) {
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
        this.npcs = new ArrayList<>();
    }
    public void setExit(Directions direction, RoomUpdate room) {
        exits.put(direction, room);
    }
    public RoomUpdate getExit(Directions directions) {
        return exits.get(directions);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);
    }

    public List<NPC> getNPCs() {
        return new ArrayList<>(npcs);
    }

    public String getDescription() {
        return description;
    }



}