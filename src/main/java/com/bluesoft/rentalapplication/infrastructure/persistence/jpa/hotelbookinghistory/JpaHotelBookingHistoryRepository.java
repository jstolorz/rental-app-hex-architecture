package com.bluesoft.rentalapplication.infrastructure.persistence.jpa.hotelbookinghistory;

import com.bluesoft.rentalapplication.domain.hotelbookinghistory.HotelBookingHistory;
import com.bluesoft.rentalapplication.domain.hotelbookinghistory.HotelBookingHistoryRepository;

class JpaHotelBookingHistoryRepository implements HotelBookingHistoryRepository {

    private final SpringJpaHotelBookingHistoryRepository springJpaHotelBookingHistoryRepository;

    JpaHotelBookingHistoryRepository(final SpringJpaHotelBookingHistoryRepository springJpaHotelBookingHistoryRepository) {
        this.springJpaHotelBookingHistoryRepository = springJpaHotelBookingHistoryRepository;
    }

    @Override
    public void save(final HotelBookingHistory hotelBookingHistory) {
        springJpaHotelBookingHistoryRepository.save(hotelBookingHistory);
    }

    @Override
    public boolean existFor(final String hotelId) {
        return springJpaHotelBookingHistoryRepository.existsById(hotelId);
    }

    @Override
    public HotelBookingHistory findFor(final String hotelId) {
        return springJpaHotelBookingHistoryRepository.findById(hotelId).get();
    }
}
