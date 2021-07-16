package com.bluesoft.rentalapplication.infrastructure.commandregistry.spring;

import com.bluesoft.rentalapplication.application.booking.BookingAccept;
import com.bluesoft.rentalapplication.application.booking.BookingReject;
import com.bluesoft.rentalapplication.application.commandregistry.CommandRegistry;
import org.springframework.context.ApplicationEventPublisher;

class SpringCommandRegistry implements CommandRegistry {

    private final ApplicationEventPublisher publisher;

    SpringCommandRegistry(final ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void register(final BookingReject bookingReject) {
        publisher.publishEvent(bookingReject);
    }

    @Override
    public void register(final BookingAccept bookingAccept) {
        publisher.publishEvent(bookingAccept);
    }
}
