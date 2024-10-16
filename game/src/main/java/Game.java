public class Game {
    private final Player player;

    public Game(Player player) {
        this.player = player;
    }

    public String executeCommand(String command) {
        return switch (command.toLowerCase()) {
            case "go forward" -> moveForward();
            case "go back" -> moveBack();
            case "look around" -> lookAround();
            default -> "I don't understand .";
        };
    }

    private String moveForward() {
        Room nextRoom = player.getCurrentRoom().getNextRoom();
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            return nextRoom.getDescription();
        } else {
            return "There is no room ahead.";
        }
    }

    private String moveBack() {
        Room previousRoom = player.getCurrentRoom().getPreviousRoom();
        if (previousRoom != null) {
            player.setCurrentRoom(previousRoom);
            return "You move back to the previous room.";
        } else {
            return "There is no room behind you.";
        }
    }

    private String lookAround() {
        return player.getCurrentRoom().getDescription();
    }
}