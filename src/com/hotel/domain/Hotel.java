// Hotel.java
package com.hotel.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hotel {

    private final String name;
    private final int number;
    private final List<Room> rooms = new ArrayList<>();

    public Hotel(String name, int number) {

        // Validation
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Hotel name is required");
        }

        if (number <= 0) {
            throw new IllegalArgumentException("Hotel number must be positive");
        }

        // Assignments
        this.name = new Name(name).value();
        this.number = number;
    }

    public void addRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("Room cannot be null");
        }
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return Collections.unmodifiableList(rooms);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    // Very simple availability check (only counts free rooms, no date check yet)
    public int countFreeRoomsOfType(RoomType type) {
        if (type == null) {
            throw new IllegalArgumentException("Room type is required");
        }

        return (int) rooms.stream()
                .filter(r -> !r.isOccupied())
                .count(); // simplified – real version should match by type
    }
}
