package com.bluesoft.rentalapplication.application.hotel;

import com.bluesoft.rentalapplication.domain.hotel.Hotel;
import com.bluesoft.rentalapplication.domain.hotel.HotelFactory;

public class HotelApplicationService {   // Adapter

    public void add(
            String name,
            String street,
            String buildingNumber,
            String postalCode,
            String city,
            String country

    ){
       Hotel hotel = new HotelFactory().create(name,street,buildingNumber,postalCode,city,country);
    }



}
