package com.bluesoft.rentalapplication.query.hotelroom;

public class QueryHotelRoomRepository {

    private final SpringQueryHotelRoomRepository springQueryHotelRoomRepository;

    public QueryHotelRoomRepository(final SpringQueryHotelRoomRepository springQueryHotelRoomRepository) {
        this.springQueryHotelRoomRepository = springQueryHotelRoomRepository;
    }

    public Iterable<HotelRoomReadModel> findAll(final String hotelId) {
        return springQueryHotelRoomRepository.findAllByHotelId(hotelId);
    }
}
