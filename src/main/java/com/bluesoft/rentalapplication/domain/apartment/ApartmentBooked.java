package com.bluesoft.rentalapplication.domain.apartment;

import java.time.LocalDateTime;
import java.util.UUID;

class ApartmentBooked {


    private final String eventId;
    private final Object eventCreationDateTime;
    private final String apartmemtId;
    private final String ownerId;
    private final String tenantId;
    private final Period period;

    ApartmentBooked(final String eventId, final Object eventCreationDateTime, final String apartmemtId, final String ownerId, final String tenantId, final Period period) {

        this.eventId = eventId;
        this.eventCreationDateTime = eventCreationDateTime;
        this.apartmemtId = apartmemtId;
        this.ownerId = ownerId;
        this.tenantId = tenantId;
        this.period = period;
    }

    static ApartmentBooked create(String apartmemtId, String ownerId, String tenantId, Period period){
        final String eventId = UUID.randomUUID().toString();
        final Object eventCreationDateTime = LocalDateTime.now();

        return new ApartmentBooked(eventId, eventCreationDateTime, apartmemtId, ownerId, tenantId, period);
    }
}
