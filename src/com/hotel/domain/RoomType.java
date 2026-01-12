// RoomType.java
package com.hotel.domain;

public class RoomType {

    private final RoomKind kind;
    private final Money cost;

    public RoomType(RoomKind kind, Money cost) {

        // Validation
        if (kind == null) {
            throw new IllegalArgumentException("Room kind is required");
        }

        if (cost == null) {
            throw new IllegalArgumentException("Cost is required");
        }

        // Assignments
        this.kind = kind;
        this.cost = cost;
    }

    public RoomKind getKind() {
        return kind;
    }

    public Money getCost() {
        return cost;
    }
}
