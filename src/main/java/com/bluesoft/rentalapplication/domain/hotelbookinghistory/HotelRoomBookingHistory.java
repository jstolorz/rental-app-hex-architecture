package com.bluesoft.rentalapplication.domain.hotelbookinghistory;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
class HotelRoomBookingHistory {

    @Id
    final String hotelRoomId;

    @OneToMany
    private final List<HotelRoomBooking> bookings = new ArrayList<>();

    HotelRoomBookingHistory(final String hotelRoomId) {
        this.hotelRoomId = hotelRoomId;
    }

    boolean hasEqualTo(final String hotelRoomId) {
        return this.hotelRoomId.equals(hotelRoomId);
    }

    void add(final LocalDateTime bookingDataTime, final String tenantId, final List<LocalDate> days) {
        bookings.add(new HotelRoomBooking(bookingDataTime,tenantId,days));
    }
}
