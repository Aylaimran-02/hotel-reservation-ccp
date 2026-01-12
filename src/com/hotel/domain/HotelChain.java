// HotelChain.java
package com.hotel.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelChain {
    private final String name;
    private final List<Hotel> hotels = new ArrayList<>();

    public HotelChain(String name) {
        this.name = new Name(name).value();
    }

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public List<Hotel> getHotels() {
        return List.copyOf(hotels);
    }

    public Reservation makeReservation(Hotel hotel, LocalDate start, LocalDate end,
                                       RoomType type, ReserverPayer payer, int quantity) {
        if (!hotels.contains(hotel)) {
            throw new IllegalArgumentException("This hotel does not belong to this chain");
        }

        int available = hotel.countFreeRoomsOfType(type);
        if (available < quantity) {
            throw new IllegalStateException("Not enough rooms available for type " + type.getKind());
        }

        int randomNumber = 1000 + (int)(Math.random() * 9000);
        Reservation reservation = new Reservation(LocalDate.now(), start, end, payer, randomNumber);
        reservation.addRequestedRooms(new HowMany(type, quantity));

        // In real version: assign concrete rooms here
        // For now just pretend we reserved

        return reservation;
    }

    // Very simplified - just for demo
    public void checkIn(ReserverPayer payer, Room room) {
        if (!room.isOccupied()) {
            room.occupy(payer);
        } else {
            throw new IllegalStateException("Room already occupied");
        }
    }

    public void checkOut(Room room) {
        room.vacate();
    }
}