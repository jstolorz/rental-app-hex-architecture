package com.bluesoft.rentalapplication.domain.hotelroombookinghistory;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class HotelRoomBooking {
    private final BookingStep bookingStep;
    private final LocalDateTime bookingDataTime;
    private final String tenantId;

    private final List<LocalDate> days;

    public HotelRoomBooking(final  BookingStep bookingStep, final LocalDateTime bookingDataTime, final String tenantId, final List<LocalDate> days) {
        this.bookingStep = bookingStep;
        this.bookingDataTime = bookingDataTime;
        this.tenantId = tenantId;
        this.days = days;
    }

    public static HotelRoomBooking start(final LocalDateTime bookingDataTime, final String tenantId, final List<LocalDate> days) {
            return new HotelRoomBooking(BookingStep.START, bookingDataTime,tenantId,days);
    }
}
