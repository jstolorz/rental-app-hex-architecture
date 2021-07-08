package com.bluesoft.rentalapplication.domain.apartment;

public class Address {
    private final String street;
    private final String postalCode;
    private final String houseNumber;
    private final String apartmentNumber;
    private final String city;
    private final String country;

    public Address(
            final String street,
            final String postalCode,
            final String houseNumber,
            final String apartmentNumber,
            final String city,
            final String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.country = country;
    }
}
