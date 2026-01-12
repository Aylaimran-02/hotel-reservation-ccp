// HowMany.java
package com.hotel.domain;

public class HowMany {
    private final RoomType type;
    private final int quantity;

    public HowMany(RoomType type, int quantity) {
        this.type = type != null ? type : throwException("Room type is required");
        if (quantity < 1) throw new IllegalArgumentException("Must reserve at least 1 room");
        this.quantity = quantity;
    }

    public RoomType getType() { return type; }
    public int getQuantity() { return quantity; }

    private static RoomType throwException(String msg) {
        throw new IllegalArgumentException(msg);
    }
}