public class Game {
    private final Player player;

    public Game(Player player) {
        this.player = player;
    }

    public String executeCommand(String command) {
        switch (command.toLowerCase()) {
            case "go forward":
                return moveForward();
            case "go back":
                return moveBack();
            case "look around":
                return lookAround();
            default:
                return "I don't understand .";
        }
    }

    private String moveForward() {
        Room nextRoom = player.getCurrentRoom().getNextRoom();
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            return "You move forward to the next room.";
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