package com.bluesoft.rentalapplication.domain.apartment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApartmentFactory {  // Port

    public Apartment create(
            final String ownerId,
            final String street,
            final String postalCode,
            final String houseNumber,
            final String apartmentNumber,
            final String city,
            final String country,
            final String description,
            final Map<String, Double> roomsDefinition
    )
    {
        Address address = new Address(street, postalCode, houseNumber, apartmentNumber, city, country);
        List<Room> rooms = new ArrayList<>();
        roomsDefinition.forEach((name, size) -> rooms.add(new Room(name, new SquerMeter(size))));
        return new Apartment(ownerId,address, description, rooms);
    }
}
