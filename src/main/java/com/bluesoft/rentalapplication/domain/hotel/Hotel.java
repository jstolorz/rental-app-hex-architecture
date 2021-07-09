package com.bluesoft.rentalapplication.domain.hotel;

public class Hotel {

    private final String hotelID;
    private final String name;
    private final Address address;

    Hotel(final String hotelID, final String name, final Address address) {
        this.hotelID = hotelID;
        this.name = name;
        this.address = address;
    }

}
