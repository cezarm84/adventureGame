package org.example;
import java.util.List;

public class GameUpdate{
    private final PlayerUpdate player;

    public GameUpdate(PlayerUpdate player) {
        this.player = player;
    }

    public String executeCommand(String command) {
        String[] parts = command.toLowerCase().split(" ", 2);
        String action = parts[0];
        String target = parts.length > 1 ? parts[1] : "";
        if (command.trim().isEmpty()) {
            return "Please enter a command.";
        }
        return switch (action) {
            case "go" -> move(target);
            case "look" -> lookAround();
            case "take" -> takeItem(target);
            case "drop" -> dropItem(target);
            case "inventory" -> checkInventory();
            case "talk" -> talkToNPC(target);
            default -> "I don't understand that command.";
        };
    }

    private String move(String direction) {
        Directions dir;
        try {
            dir = Directions.valueOf(direction.toUpperCase());
        } catch (IllegalArgumentException e) {
            return "That's not a valid direction.";
        }

        RoomUpdate nextRoom = player.getCurrentRoom().getExit(dir);
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            return "You move " + direction  +"\n"+ nextRoom.getDescription()+ "\n";
        } else {
            return "You can't go that way.";
        }
    }

    private String lookAround() {
        RoomUpdate currentRoom = player.getCurrentRoom();
        StringBuilder sb = new StringBuilder(currentRoom.getDescription() + "\n");

        if (currentRoom.getItems() != null && !currentRoom.getItems().isEmpty()) {
            sb.append("You see: ");
            for (Item item : currentRoom.getItems()) {
                sb.append(item.name()).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        }

        if (!currentRoom.getNPCs().isEmpty()) {
            sb.append("There are some people here: ");
            for (NPC npc : currentRoom.getNPCs()) {
                sb.append(npc.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        }

        return sb.toString();
    }

    private String takeItem(String itemName) {
        for (Item item : player.getCurrentRoom().getItems()) {
            if (item.name().equalsIgnoreCase(itemName)) {
                player.pickUpItem(item);
                return "You pick up the " + itemName + ".";
            }
        }
        return "There's no " + itemName + " here.";
    }

    private String dropItem(String itemName) {
        for (Item item : player.getInventory()) {
            if (item.name().equalsIgnoreCase(itemName)) {
                player.dropItem(item);
                return "You drop the " + itemName + ".";
            }
        }
        return "You don't have a " + itemName + ".";
    }

    private String checkInventory() {
        List<Item> inventory = player.getInventory();
        if (inventory.isEmpty()) {
            return "Your inventory is empty.";
        }
        StringBuilder sb = new StringBuilder("You are carrying: ");
        for (Item item : inventory) {
            sb.append(item.name()).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    private String talkToNPC(String npcName) {
        for (NPC npc : player.getCurrentRoom().getNPCs()) {
            if (npc.getName().equalsIgnoreCase(npcName)) {
                return "You talk to " + npc.getName() + ". They say: " + npc.talk("default");
            }
        }
        return "There's no one named " + npcName + " here.";
    }
}