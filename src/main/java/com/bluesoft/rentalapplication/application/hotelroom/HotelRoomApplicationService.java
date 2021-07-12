package com.bluesoft.rentalapplication.application.hotelroom;

import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoom;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomFactory;

import java.util.Map;

public class HotelRoomApplicationService {  // Adapter

    public void add(
            String hotelId,
            int number,
            String description,
            Map<String, Double> spacesDefinition
    ){

       HotelRoom hotelRoom = new HotelRoomFactory().create(hotelId,number,description,spacesDefinition);

    }

}
