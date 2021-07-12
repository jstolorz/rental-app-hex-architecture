package com.bluesoft.rentalapplication.application.hotelroom;

import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoom;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomFactory;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomRepository;

import java.util.Map;

public class HotelRoomApplicationService {  // Adapter

    private final HotelRoomRepository hotelRoomRepository;

    public HotelRoomApplicationService(final HotelRoomRepository hotelRoomRepository) {
        this.hotelRoomRepository = hotelRoomRepository;
    }

    public void add(
            String hotelId,
            int number,
            String description,
            Map<String, Double> spacesDefinition
    ){

       HotelRoom hotelRoom = new HotelRoomFactory().create(hotelId,number,description,spacesDefinition);
       hotelRoomRepository.save(hotelRoom);

    }

}
