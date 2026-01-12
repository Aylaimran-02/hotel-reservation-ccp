// Name.java
package com.hotel.domain;

public record Name(String value) {
    public Name {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
    }
}