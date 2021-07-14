package com.bluesoft.rentalapplication.application.hotelroom;

import com.bluesoft.rentalapplication.domain.eventchannel.EventChannel;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoom;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomFactory;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class HotelRoomApplicationService {  // Adapter

    private final HotelRoomRepository hotelRoomRepository;
    private final EventChannel eventChannel;

    public HotelRoomApplicationService(final HotelRoomRepository hotelRoomRepository, final EventChannel eventChannel) {
        this.hotelRoomRepository = hotelRoomRepository;
        this.eventChannel = eventChannel;
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



    public void book(final String id, final String tenantId, final List<LocalDate> days) {
        HotelRoom hotelRoom = hotelRoomRepository.findById(id);
        hotelRoom.book(tenantId,days,eventChannel);
    }
}
