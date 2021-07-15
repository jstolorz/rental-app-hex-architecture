package com.bluesoft.rentalapplication.domain.hotelbookinghistory;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class HotelBookingHistory {

    @Id
    private String hotelId;

    @OneToMany
    private final List<HotelRoomBookingHistory> booking = new ArrayList<>();

    public HotelBookingHistory(final String hotelId) {
        this.hotelId = hotelId;
    }

    public void add(final String hotelRoomId, final LocalDateTime bookingDataTime, final String tenantId, final List<LocalDate> days) {
        final HotelRoomBookingHistory hotelRoomBookingHistory = findFor(hotelRoomId);
        hotelRoomBookingHistory.add(bookingDataTime,tenantId,days);

    }

    private HotelRoomBookingHistory findFor(final String hotelRoomId) {
        Optional<HotelRoomBookingHistory> history = booking.stream()
                .filter(hotelRoomBookingHistory -> hotelRoomBookingHistory.hasEqualTo(hotelRoomId))
                .findFirst();

        if(history.isEmpty()){
            final HotelRoomBookingHistory hotelRoomBookingHistory = new HotelRoomBookingHistory(hotelRoomId);
            booking.add(hotelRoomBookingHistory);
            return hotelRoomBookingHistory;
        }else{
            return history.get();
        }
    }
}
