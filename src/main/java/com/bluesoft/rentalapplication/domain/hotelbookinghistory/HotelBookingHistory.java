package com.bluesoft.rentalapplication.domain.hotelbookinghistory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class HotelBookingHistory {
    private String hotelId;

    public HotelBookingHistory(final String hotelId) {
        this.hotelId = hotelId;
    }

    void add(final String hotelRoomId, final LocalDateTime eventCreationDateTime, final String tenantId, final List<LocalDate> days) {

    }
}
