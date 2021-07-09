package com.bluesoft.rentalapplication.application.hotelroom;

import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoom;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomFactory;

import java.util.Map;

public class HotelRoomApplicationService {  // Adapter

    public void add(
            String hotelID,
            int number,
            String description,
            Map<String, Double> roomsDefinition
    ){

       HotelRoom hotelRoom = new HotelRoomFactory().create(hotelID,number,description,roomsDefinition);

    }

}
