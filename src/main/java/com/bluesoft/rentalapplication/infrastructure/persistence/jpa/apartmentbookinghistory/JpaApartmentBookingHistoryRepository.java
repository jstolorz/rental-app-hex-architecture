package com.bluesoft.rentalapplication.infrastructure.persistence.jpa.apartmentbookinghistory;

import com.bluesoft.rentalapplication.domain.apartmentbookinghistory.ApartmentBookingHistory;
import com.bluesoft.rentalapplication.domain.apartmentbookinghistory.ApartmentBookingHistoryRepository;

class JpaApartmentBookingHistoryRepository implements ApartmentBookingHistoryRepository {

    private final SpringJpaApartmentBookingHistoryRepository springJpaApartmentBookingHistoryRepository;

    JpaApartmentBookingHistoryRepository(final SpringJpaApartmentBookingHistoryRepository springJpaApartmentBookingHistoryRepository) {
        this.springJpaApartmentBookingHistoryRepository = springJpaApartmentBookingHistoryRepository;
    }

    @Override
    public void save(final ApartmentBookingHistory apartmentBookingHistory) {
        springJpaApartmentBookingHistoryRepository.save(apartmentBookingHistory);
    }

    @Override
    public boolean exists(final String apartmentId) {

        return springJpaApartmentBookingHistoryRepository.existsById(apartmentId);
    }

    @Override
    public ApartmentBookingHistory findFor(final String apartmentId) {

        return springJpaApartmentBookingHistoryRepository.findById(apartmentId).get();
    }
}
