// Main.java
package com.hotel.domain;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
    	//Final demo: shows successful reservation, failed quantity check, check-in/out
        System.out.println("=== Hotel Reservation System - Demo ===\n");

        HotelChain chain = new HotelChain("Luxury Chain");

        Hotel hotel = new Hotel("Karachi Grand", 1);
        chain.addHotel(hotel);

        RoomType single = new RoomType(RoomKind.SINGLE, new Money(6500));
        RoomType family = new RoomType(RoomKind.FAMILY, new Money(14500));

        hotel.addRoom(new Room(101));
        hotel.addRoom(new Room(102));
        hotel.addRoom(new Room(201));

        ReserverPayer payer = new ReserverPayer(
                new Name("Ahmed Ali"),
                new Address("Gulshan-e-Iqbal, Karachi"),
                "PK-123456789",
                new CreditCard("4342562001001234", "12/27")
        );

        try {
            System.out.println("Attempting to reserve 2 family rooms...");
            Reservation res = chain.makeReservation(
                    hotel,
                    LocalDate.of(2026, 2, 15),
                    LocalDate.of(2026, 2, 20),
                    family,
                    payer,
                    2
            );

            System.out.println("SUCCESS! Reservation created");
            System.out.println("Reservation #: " + res.getReservationNumber());
            System.out.println("Guest: " + res.getReserver().getName().value());
            System.out.println("Period: " + res.getStartDate() + " to " + res.getEndDate());
            System.out.println("Requested: " + res.getRequestedRooms().get(0).getQuantity() +
                               " × " + res.getRequestedRooms().get(0).getType().getKind());

            // NEW: Failed reservation demo (only 3 rooms total, so 10 will fail)
            System.out.println("\nAttempting to reserve 10 family rooms (should fail due to insufficient rooms)...");
            try {
                chain.makeReservation(
                        hotel,
                        LocalDate.of(2026, 2, 15),
                        LocalDate.of(2026, 2, 20),
                        family,
                        payer,
                        10
                );
            } catch (Exception e) {
                System.out.println("FAILED (not enough rooms available): " + e.getMessage());
            }

            // Demo check-in
            Room room101 = hotel.getRooms().get(0);
            System.out.println("\nCheck-in to room " + room101.getNumber() + "...");
            chain.checkIn(payer, room101);
            System.out.println("Room " + room101.getNumber() + " is now occupied by " +
                               room101.getOccupant().getName().value());

            // Demo check-out
            System.out.println("\nCheck-out from room " + room101.getNumber() + "...");
            chain.checkOut(room101);
            System.out.println("Room " + room101.getNumber() + " is now free");

        } catch (Exception e) {
            System.out.println("FAILED: " + e.getMessage());
        }
    }
}