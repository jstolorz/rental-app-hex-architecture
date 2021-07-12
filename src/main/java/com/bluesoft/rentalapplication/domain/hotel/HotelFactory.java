package com.bluesoft.rentalapplication.domain.hotel;


public class HotelFactory {
    public Hotel create(
            final String name,
            final String street,
            final String buildingNumber,
            final String postalCode,
            final String city,
            final String country)
    {

        Address address = new Address(street, buildingNumber,postalCode, city, country);
        return new Hotel(name, address);
    }
}
