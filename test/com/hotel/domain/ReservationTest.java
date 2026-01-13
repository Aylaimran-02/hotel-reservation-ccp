package com.hotel.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    private final ReserverPayer dummyPayer = new ReserverPayer(
            new Name("Test Guest"),
            new Address("Test Address"),
            "PK-TEST-123",
            new CreditCard("4111111111111111", "12/28")
    );

    @Test
    void shouldThrowWhenStartDateIsAfterEndDate() {
        assertThrows(IllegalArgumentException.class, () ->
                new Reservation(
                        LocalDate.now(),
                        LocalDate.of(2026, 3, 10),
                        LocalDate.of(2026, 3, 5),
                        dummyPayer,
                        1001
                )
        );
    }

    @Test
    void shouldThrowWhenReservationNumberInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
            new Reservation(LocalDate.now(), LocalDate.of(2026, 3, 1), LocalDate.of(2026, 3, 5), dummyPayer, 0));
        assertThrows(IllegalArgumentException.class, () ->
            new Reservation(LocalDate.now(), LocalDate.of(2026, 3, 1), LocalDate.of(2026, 3, 5), dummyPayer, -5));
    }

    @ParameterizedTest
    @CsvSource({
            "2026-02-10, 2026-02-14",
            "2026-03-01, 2026-03-05"
    })
    void validDatesShouldNotThrow(String start, String end) {
        assertDoesNotThrow(() ->
                new Reservation(
                        LocalDate.now(),
                        LocalDate.parse(start),
                        LocalDate.parse(end),
                        dummyPayer,
                        1002
                )
        );
    }

    @Test
    void shouldThrowWhenReserverIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Reservation(LocalDate.now(), LocalDate.of(2026, 4, 1), LocalDate.of(2026, 4, 5), null, 1003));
    }

    // NEW: Two separate tests for null dates (simpler and no parse error)
    @Test
    void shouldThrowWhenStartDateIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Reservation(LocalDate.now(), null, LocalDate.of(2026, 4, 5), dummyPayer, 1004));
    }

    @Test
    void shouldThrowWhenEndDateIsNull() {
        assertThrows(IllegalArgumentException.class, () ->
                new Reservation(LocalDate.now(), LocalDate.of(2026, 4, 1), null, dummyPayer, 1004));
    }
}