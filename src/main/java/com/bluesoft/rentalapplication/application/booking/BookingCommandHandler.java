package com.bluesoft.rentalapplication.application.booking;

import com.bluesoft.rentalapplication.domain.apartment.Booking;
import com.bluesoft.rentalapplication.domain.apartment.BookingRepository;
import org.springframework.context.event.EventListener;

public class BookingCommandHandler {
    private final BookingRepository bookingRepository;

    public BookingCommandHandler(final BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @EventListener
    public void reject(BookingReject bookingReject){
        Booking booking = bookingRepository.findById(bookingReject.getBookingId());
        booking.reject();
        bookingRepository.save(booking);
    }
}
