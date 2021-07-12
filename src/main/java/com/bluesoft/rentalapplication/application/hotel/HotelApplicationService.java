package com.bluesoft.rentalapplication.application.hotel;

import com.bluesoft.rentalapplication.domain.hotel.Hotel;
import com.bluesoft.rentalapplication.domain.hotel.HotelFactory;
import com.bluesoft.rentalapplication.domain.hotel.HotelRepository;

public class HotelApplicationService {   // Adapter

    private final HotelRepository hotelRepository;

    public HotelApplicationService(final HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public void add(
            String name,
            String street,
            String buildingNumber,
            String postalCode,
            String city,
            String country

    ){
       Hotel hotel = new HotelFactory().create(name,street,buildingNumber,postalCode,city,country);
       hotelRepository.save(hotel);
    }



}
