package com.bluesoft.rentalapplication.query.apartment;

import org.springframework.data.repository.CrudRepository;

interface SpringQueryApartmentRepository extends CrudRepository<ApartmentReadModel,String> {
}
