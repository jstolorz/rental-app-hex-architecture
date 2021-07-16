package com.bluesoft.rentalapplication.query.apartment;

public class QueryApartmentRepository {

    private final SpringQueryApartmentRepository springQueryApartmentRepository;

    public QueryApartmentRepository(final SpringQueryApartmentRepository springQueryApartmentRepository) {
        this.springQueryApartmentRepository = springQueryApartmentRepository;
    }

    public Iterable<ApartmentReadModel> findAll() {
        return springQueryApartmentRepository.findAll();
    }
}
