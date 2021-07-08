package com.bluesoft.rentalapplication.application.apartment;

import com.bluesoft.rentalapplication.domain.apartment.Apartment;
import com.bluesoft.rentalapplication.domain.apartment.ApartmentFactory;

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

          final Apartment apartment = new ApartmentFactory().create(ownerId, street, postalCode, houseNumber, apartmentNumber, city, country, description, roomsDefinition);
     }



}
