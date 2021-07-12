package com.bluesoft.rentalapplication.infrastructure.persistence.jpa.apartment;

import com.bluesoft.rentalapplication.domain.apartment.Apartment;
import org.springframework.data.repository.CrudRepository;

interface SpringJpaApartmentRepository extends CrudRepository<Apartment, String> {
}
