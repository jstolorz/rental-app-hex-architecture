package com.bluesoft.rentalapplication.query.hotel;

public class QueryHotelRepository {

    private final SpringQueryHotelRepository springQueryHotelRepository;

    public QueryHotelRepository(final SpringQueryHotelRepository springQueryHotelRepository) {
        this.springQueryHotelRepository = springQueryHotelRepository;
    }

    public Iterable<HotelReadModel> findAll() {
        return springQueryHotelRepository.findAll();
    }
}
