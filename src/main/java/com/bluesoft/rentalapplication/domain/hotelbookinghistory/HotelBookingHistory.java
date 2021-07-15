package com.bluesoft.rentalapplication.domain.hotelbookinghistory;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class HotelBookingHistory {

    @Id
    private String hotelId;

    public HotelBookingHistory(final String hotelId) {
        this.hotelId = hotelId;
    }

    public void add(final String hotelRoomId, final LocalDateTime eventCreationDateTime, final String tenantId, final List<LocalDate> days) {

    }
}
