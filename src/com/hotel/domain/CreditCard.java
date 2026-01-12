// CreditCard.java (very simplified)
package com.hotel.domain;

public record CreditCard(String number, String expiry) {
    public CreditCard {
        if (number == null || number.length() < 12) throw new IllegalArgumentException("Invalid card number");
        if (expiry == null || expiry.trim().isEmpty()) throw new IllegalArgumentException("Expiry date is required");
    }
}