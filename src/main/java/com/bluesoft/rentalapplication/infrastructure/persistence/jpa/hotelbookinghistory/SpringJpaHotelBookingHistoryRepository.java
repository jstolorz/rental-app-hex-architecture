package com.bluesoft.rentalapplication.infrastructure.persistence.jpa.hotelbookinghistory;

import com.bluesoft.rentalapplication.domain.hotelbookinghistory.HotelBookingHistory;
import org.springframework.data.repository.CrudRepository;

interface SpringJpaHotelBookingHistoryRepository extends CrudRepository<HotelBookingHistory, String> {
}
