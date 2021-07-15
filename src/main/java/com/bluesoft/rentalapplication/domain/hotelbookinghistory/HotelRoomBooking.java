package com.bluesoft.rentalapplication.domain.hotelbookinghistory;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
class HotelRoomBooking {

    private final LocalDateTime bookingDataTime;
    private final String tenantId;
    private final List<LocalDate> days;

    public HotelRoomBooking(final LocalDateTime bookingDataTime, final String tenantId, final List<LocalDate> days) {

        this.bookingDataTime = bookingDataTime;
        this.tenantId = tenantId;
        this.days = days;
    }
}
