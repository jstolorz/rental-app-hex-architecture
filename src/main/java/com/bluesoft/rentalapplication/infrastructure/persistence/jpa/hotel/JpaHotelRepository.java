package com.bluesoft.rentalapplication.infrastructure.persistence.jpa.hotel;

import com.bluesoft.rentalapplication.domain.hotel.Hotel;
import com.bluesoft.rentalapplication.domain.hotel.HotelRepository;

class JpaHotelRepository implements HotelRepository {

    private final SpringJpaHotelRepository springJpaHotelRepository;

    JpaHotelRepository(final SpringJpaHotelRepository springJpaHotelRepository) {
        this.springJpaHotelRepository = springJpaHotelRepository;
    }

    @Override
    public void save(final Hotel hotel) {
        springJpaHotelRepository.save(hotel);
    }
}
