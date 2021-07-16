package com.bluesoft.rentalapplication.domain.eventchannel;

import com.bluesoft.rentalapplication.domain.apartment.ApartmentBooked;
import com.bluesoft.rentalapplication.domain.apartment.BookingAccepted;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomBooked;

public interface EventChannel {

    void publish(ApartmentBooked apartmentBooked);

    void publish(HotelRoomBooked hotelRoomBooked);

    void publish(BookingAccepted bookingAccepted);
}
