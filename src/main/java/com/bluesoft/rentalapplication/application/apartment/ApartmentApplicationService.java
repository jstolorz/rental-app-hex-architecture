package com.bluesoft.rentalapplication.application.apartment;

import com.bluesoft.rentalapplication.domain.apartment.*;
import com.bluesoft.rentalapplication.domain.eventchannel.EventChannel;

import java.time.LocalDate;
import java.util.Map;

public class ApartmentApplicationService {     // Adapter

    private final ApartmentRepository apartmentRepository;
    private final EventChannel eventChannel;

    public ApartmentApplicationService(final ApartmentRepository apartmentRepository, final EventChannel eventChannel) {
        this.apartmentRepository = apartmentRepository;
        this.eventChannel = eventChannel;
    }

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

          apartmentRepository.save(apartment);
     }


    public void book(final String id, final String tenantId, final LocalDate start, final LocalDate end) {
         Apartment apartment = apartmentRepository.findById(id);
         Period period = new Period(start,end);
         apartment.book(tenantId, period, eventChannel);
    }
}
