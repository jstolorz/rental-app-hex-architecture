package com.bluesoft.rentalapplication.domain.apartmentbookinghistory;

public interface ApartmentBookingHistoryRepository {
    void save(ApartmentBookingHistory apartmentBookingHistory);

    boolean exists(String apartmemtId);

    ApartmentBookingHistory findFor(String apartmemtId);
}
