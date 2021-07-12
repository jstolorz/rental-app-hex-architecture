package com.bluesoft.rentalapplication.infrastructure.persistence.jpa.hotelroom;

import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoom;
import org.springframework.data.repository.CrudRepository;

interface SpringJpaHotelRoomRepository extends CrudRepository<HotelRoom,String> {
}
