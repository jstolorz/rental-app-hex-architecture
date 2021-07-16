package com.bluesoft.rentalapplication.infrastructure.eventchannel.spring;

import com.bluesoft.rentalapplication.domain.apartment.ApartmentBooked;
import com.bluesoft.rentalapplication.domain.apartment.BookingAccepted;
import com.bluesoft.rentalapplication.domain.eventchannel.EventChannel;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomBooked;
import org.springframework.context.ApplicationEventPublisher;

class SpringEventChannel implements EventChannel {

    private final ApplicationEventPublisher publisher;

    SpringEventChannel(final ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(final ApartmentBooked apartmentBooked) {
        publisher.publishEvent(apartmentBooked);
    }

    @Override
    public void publish(final HotelRoomBooked hotelRoomBooked) {
       publisher.publishEvent(hotelRoomBooked);
    }

    @Override
    public void publish(final BookingAccepted bookingAccepted) {
        publisher.publishEvent(bookingAccepted);
    }
}
