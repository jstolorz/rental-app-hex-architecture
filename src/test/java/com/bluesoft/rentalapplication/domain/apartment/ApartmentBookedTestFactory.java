package com.bluesoft.rentalapplication.domain.apartment;

public class ApartmentBookedTestFactory {

    public static ApartmentBooked create(String apartmemtId, String ownerId, String tenantId, Period period){
        return ApartmentBooked.create(apartmemtId,ownerId,tenantId,period);
    }
}