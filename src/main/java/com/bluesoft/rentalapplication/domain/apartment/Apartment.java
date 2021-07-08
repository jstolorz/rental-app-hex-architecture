package com.bluesoft.rentalapplication.domain.apartment;

import java.util.List;

public class Apartment {
    private final String ownerId;
    private final Address address;
    private final String description;
    private final List<Room> rooms;

    Apartment(final String ownerId, final Address address, final String description, final List<Room> rooms) {
        this.ownerId = ownerId;
        this.address = address;
        this.description = description;
        this.rooms = rooms;
    }
}
