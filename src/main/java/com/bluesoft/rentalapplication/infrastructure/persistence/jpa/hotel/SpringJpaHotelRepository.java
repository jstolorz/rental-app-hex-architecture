package com.bluesoft.rentalapplication.infrastructure.persistence.jpa.hotel;

import com.bluesoft.rentalapplication.domain.hotel.Hotel;
import org.springframework.data.repository.CrudRepository;

interface SpringJpaHotelRepository extends CrudRepository<Hotel,String> {
}
