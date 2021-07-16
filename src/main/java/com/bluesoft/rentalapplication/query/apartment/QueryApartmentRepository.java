package com.bluesoft.rentalapplication.query.apartment;

public class QueryApartmentRepository {

    private final SpringQueryApartmentRepository springQueryApartmentRepository;
    private final SpringQueryApartmentBookingHistoryRepository springQueryApartmentBookingHistoryRepository;

    public QueryApartmentRepository(final SpringQueryApartmentRepository springQueryApartmentRepository, final SpringQueryApartmentBookingHistoryRepository springQueryApartmentBookingHistoryRepository) {
        this.springQueryApartmentRepository = springQueryApartmentRepository;
        this.springQueryApartmentBookingHistoryRepository = springQueryApartmentBookingHistoryRepository;
    }

    public Iterable<ApartmentReadModel> findAll() {
        return springQueryApartmentRepository.findAll();
    }

    public ApartmentDetails findById(final String id) {
        final ApartmentReadModel apartmentReadModel = springQueryApartmentRepository.findById(id).get();
        final ApartmentBookingHistoryReadModel apartmentBookingHistoryReadModel = springQueryApartmentBookingHistoryRepository.findById(id).get();

        return new ApartmentDetails(apartmentReadModel,apartmentBookingHistoryReadModel);
    }
}
