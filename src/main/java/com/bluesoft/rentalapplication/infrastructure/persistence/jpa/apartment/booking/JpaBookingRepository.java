package com.bluesoft.rentalapplication.infrastructure.persistence.jpa.apartment.booking;

import com.bluesoft.rentalapplication.domain.apartment.Booking;
import com.bluesoft.rentalapplication.domain.apartment.BookingRepository;

class JpaBookingRepository implements BookingRepository {

    private final SpringJpaBookingRepository springJpaBookingRepository;

    JpaBookingRepository(final SpringJpaBookingRepository springJpaBookingRepository) {
        this.springJpaBookingRepository = springJpaBookingRepository;
    }

    @Override
    public void save(final Booking booking) {
        springJpaBookingRepository.save(booking);
    }

    @Override
    public Booking findById(final String bookingId) {
        return springJpaBookingRepository.findById(bookingId).get();
    }
}
