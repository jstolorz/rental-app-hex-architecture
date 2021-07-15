package com.bluesoft.rentalapplication.infrastructure.persistence.jpa.hotelroombookinghistory;

import com.bluesoft.rentalapplication.domain.hotelroombookinghistory.HotelRoomBookingHistory;
import org.springframework.data.repository.CrudRepository;

interface SpringJpaHotelRoomBookingHistoryRepository extends CrudRepository<HotelRoomBookingHistory,String> {
}
