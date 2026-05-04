package oopsproject;

public class Room {

    private int roomNumber;
    private boolean isOccupied;

    public Room() {
        this.isOccupied = false;
    }

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isOccupied = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    public String toString() {
        return "Room No: " + roomNumber + " | Occupied: " + isOccupied;
    }
}
