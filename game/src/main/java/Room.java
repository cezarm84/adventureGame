public class Room {
    private final String description;
    private Room nextRoom;
    private Room previousRoom;

    public Room(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public void setPreviousRoom(Room previousRoom) {
        this.previousRoom = previousRoom;
    }
}