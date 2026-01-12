// Room.java
package com.hotel.domain;

public class Room {
    private final int number;
    private Guest occupant;

    public Room(int number) {
        if (number <= 0) throw new IllegalArgumentException("Room number must be positive");
        this.number = number;
    }

    public int getNumber() { return number; }
    public boolean isOccupied() { return occupant != null; }
    public Guest getOccupant() { return occupant; }

    public void occupy(Guest guest) {
        if (isOccupied()) throw new IllegalStateException("Room is already occupied");
        this.occupant = guest;
    }

    public void vacate() {
        this.occupant = null;
    }
}