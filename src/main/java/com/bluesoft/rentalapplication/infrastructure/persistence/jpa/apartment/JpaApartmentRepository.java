package com.bluesoft.rentalapplication.infrastructure.persistence.jpa.apartment;

import com.bluesoft.rentalapplication.domain.apartment.Apartment;
import com.bluesoft.rentalapplication.domain.apartment.ApartmentRepository;

class JpaApartmentRepository implements ApartmentRepository {

    private final SpringJpaApartmentRepository springJpaApartmentRepository;

    JpaApartmentRepository(final SpringJpaApartmentRepository springJpaApartmentRepository) {
        this.springJpaApartmentRepository = springJpaApartmentRepository;
    }

    @Override
    public void save(final Apartment apartment) {
       springJpaApartmentRepository.save(apartment);
    }

    @Override
    public Apartment findById(final String id) {
        return springJpaApartmentRepository.findById(id).get();
    }
}
