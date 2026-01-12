// Address.java
package com.hotel.domain;

public record Address(String value) {
    public Address {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty");
        }
    }
}