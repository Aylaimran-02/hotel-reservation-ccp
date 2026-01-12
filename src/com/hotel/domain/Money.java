// Money.java
package com.hotel.domain;

public record Money(double amount) {
    public Money {
        if (amount < 0) {
            throw new IllegalArgumentException("Money amount cannot be negative");
        }
    }
}