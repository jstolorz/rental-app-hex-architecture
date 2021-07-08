package com.bluesoft.rentalapplication.application.apartment;

import com.bluesoft.rentalapplication.domain.apartment.Address;
import com.bluesoft.rentalapplication.domain.apartment.Apartment;
import com.bluesoft.rentalapplication.domain.apartment.Room;
import com.bluesoft.rentalapplication.domain.apartment.SquerMeter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApartmentApplicationService {     // Adapter

     public void add(
             String ownerId,
             String street,
             String postalCode,
             String houseNumber,
             String apartmentNumber,
             String city,
             String country,
             String description,
             Map<String, Double> roomsDefinition
             )
     {

          Address address = new Address(street, postalCode,houseNumber,apartmentNumber,city,country);
          List<Room> rooms = new ArrayList<>();
          roomsDefinition.forEach((name,size) -> rooms.add(new Room(name, new SquerMeter(size))));
          Apartment apartment = new Apartment(ownerId,address, description, rooms);
     }

}
