package com.bluesoft.rentalapplication.infrastructure.persistence.jpa.hotelroombookinghistory;

import com.bluesoft.rentalapplication.domain.hotelroombookinghistory.HotelRoomBookingHistory;
import com.bluesoft.rentalapplication.domain.hotelroombookinghistory.HotelRoomBookingHistoryRepository;

class JpaHotelRoomBookingHistoryRepository implements HotelRoomBookingHistoryRepository {

    private final SpringJpaHotelRoomBookingHistoryRepository springHotelRoomBookingHistoryRepository;

    JpaHotelRoomBookingHistoryRepository(final SpringJpaHotelRoomBookingHistoryRepository springHotelRoomBookingHistoryRepository) {
        this.springHotelRoomBookingHistoryRepository = springHotelRoomBookingHistoryRepository;
    }

    @Override
    public void save(final HotelRoomBookingHistory hotelRoomBookingHistory) {
        springHotelRoomBookingHistoryRepository.save(hotelRoomBookingHistory);
    }

    @Override
    public boolean existFor(final String hotelRoomId) {

        return springHotelRoomBookingHistoryRepository.existsById(hotelRoomId);
    }

    @Override
    public HotelRoomBookingHistory findFor(final String hotelRoomId) {
        return springHotelRoomBookingHistoryRepository.findById(hotelRoomId).get();

    }
}
