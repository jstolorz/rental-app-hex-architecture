package com.bluesoft.rentalapplication.application.hotelroom;

import com.bluesoft.rentalapplication.domain.apartment.Booking;
import com.bluesoft.rentalapplication.domain.apartment.BookingRepository;
import com.bluesoft.rentalapplication.domain.eventchannel.EventChannel;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoom;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomFactory;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class HotelRoomApplicationService {
    private final HotelRoomRepository hotelRoomRepository;
    private final BookingRepository bookingRepository;
    private final EventChannel eventChannel;

    public HotelRoomApplicationService(HotelRoomRepository hotelRoomRepository, final BookingRepository bookingRepository, EventChannel eventChannel) {
        this.hotelRoomRepository = hotelRoomRepository;
        this.bookingRepository = bookingRepository;
        this.eventChannel = eventChannel;
    }

    public void add(String hotelId, int number, Map<String, Double> spacesDefinition, String description) {
        HotelRoom hotelRoom = new HotelRoomFactory().create(hotelId, number, spacesDefinition, description);

        hotelRoomRepository.save(hotelRoom);
    }

    public void book(String id, String tenantId, List<LocalDate> days) {
        HotelRoom hotelRoom = hotelRoomRepository.findById(id);

        Booking booking = hotelRoom.book(tenantId, days, eventChannel);

        bookingRepository.save(booking);
    }
}
