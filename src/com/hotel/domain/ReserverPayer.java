// ReserverPayer.java
package com.hotel.domain;

public class ReserverPayer extends Guest {

    private final String identity;
    private final CreditCard creditCardDetails;

    public ReserverPayer(Name name,
                         Address address,
                         String identity,
                         CreditCard creditCard) {

        super(name, address);

        // Validation
        if (identity == null || identity.trim().isEmpty()) {
            throw new IllegalArgumentException("Identity is required");
        }

        if (creditCard == null) {
            throw new IllegalArgumentException("Credit card details are required");
        }

        // Assignments
        this.identity = identity;
        this.creditCardDetails = creditCard;
    }

    public String getIdentity() {
        return identity;
    }

    public CreditCard getCreditCardDetails() {
        return creditCardDetails;
    }
}
