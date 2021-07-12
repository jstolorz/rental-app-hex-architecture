package com.bluesoft.rentalapplication.infrastructure.persistence.jpa.hotelroom;

import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoom;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomRepository;

class JpaHotelRoomRepository implements HotelRoomRepository {

    private final SpringJpaHotelRoomRepository springJpaHotelRoomRepository;

    JpaHotelRoomRepository(final SpringJpaHotelRoomRepository springJpaHotelRoomRepository) {
        this.springJpaHotelRoomRepository = springJpaHotelRoomRepository;
    }

    @Override
    public void save(final HotelRoom hotelRoom) {
       springJpaHotelRoomRepository.save(hotelRoom);
    }
}
