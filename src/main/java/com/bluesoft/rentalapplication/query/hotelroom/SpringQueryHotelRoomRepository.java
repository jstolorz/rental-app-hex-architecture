package com.bluesoft.rentalapplication.query.hotelroom;

import org.springframework.data.repository.CrudRepository;

interface SpringQueryHotelRoomRepository extends CrudRepository<HotelRoomReadModel,String> {
     Iterable<HotelRoomReadModel> findAllByHotelId(String hotelId);
}
