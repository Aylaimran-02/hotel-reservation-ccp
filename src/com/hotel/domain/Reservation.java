// Reservation.java
package com.hotel.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reservation {

    private final LocalDate reservationDate;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final ReserverPayer reserver;
    private final int reservationNumber;
    private final List<HowMany> requestedRooms = new ArrayList<>();

    public Reservation(LocalDate reservationDate,
                       LocalDate startDate,
                       LocalDate endDate,
                       ReserverPayer reserver,
                       int reservationNumber) {

        // Reservation date is always today
        this.reservationDate = LocalDate.now();

        // Validation
        if (startDate == null) {
            throw new IllegalArgumentException("Start date is required");
        }
        if (endDate == null) {
            throw new IllegalArgumentException("End date is required");
        }
        if (reserver == null) {
            throw new IllegalArgumentException("Reserver is required");
        }
        if (reservationNumber <= 0) {
            throw new IllegalArgumentException("Invalid reservation number");
        }
        if (!startDate.isBefore(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date");
        }

        // Assignments
        this.startDate = startDate;
        this.endDate = endDate;
        this.reserver = reserver;
        this.reservationNumber = reservationNumber;
    }

    public void addRequestedRooms(HowMany howMany) {
        if (howMany == null) {
            throw new IllegalArgumentException("Requested room cannot be null");
        }
        requestedRooms.add(howMany);
    }

    public List<HowMany> getRequestedRooms() {
        return Collections.unmodifiableList(requestedRooms);
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ReserverPayer getReserver() {
        return reserver;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }
}
