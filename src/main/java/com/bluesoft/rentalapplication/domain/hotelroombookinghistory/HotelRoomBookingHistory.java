package com.bluesoft.rentalapplication.domain.hotelroombookinghistory;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HotelRoomBookingHistory {

    @Id
    private String hotelRoomId;

    @OneToMany
    private List<HotelRoomBooking> bookings = new ArrayList<>();

    public HotelRoomBookingHistory(final String hotelRoomId) {
        this.hotelRoomId = hotelRoomId;
    }

    public void add(final HotelRoomBooking hotelRoomBooking) {
        bookings.add(hotelRoomBooking);
    }
}
