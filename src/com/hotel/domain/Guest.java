// Guest.java
package com.hotel.domain;

public abstract class Guest {

    private final Name name;
    private final Address addressDetails;

    protected Guest(Name name, Address addressDetails) {

        // Validation
        if (name == null) {
            throw new IllegalArgumentException("Name is required");
        }

        if (addressDetails == null) {
            throw new IllegalArgumentException("Address is required");
        }

        // Assignments
        this.name = name;
        this.addressDetails = addressDetails;
    }

    public Name getName() {
        return name;
    }

    public Address getAddressDetails() {
        return addressDetails;
    }
}
