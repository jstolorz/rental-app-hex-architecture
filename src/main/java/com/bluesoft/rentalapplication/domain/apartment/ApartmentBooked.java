package com.bluesoft.rentalapplication.domain.apartment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ApartmentBooked {


    private final String eventId;
    private final LocalDateTime eventCreationDateTime;
    private final String apartmentId;
    private final String ownerId;
    private final String tenantId;
    private final LocalDate periodStart;
    private final LocalDate periodEnd;


    ApartmentBooked(final String eventId, final LocalDateTime eventCreationDateTime, final String apartmemtId, final String ownerId, final String tenantId, final Period period) {

        this.eventId = eventId;
        this.eventCreationDateTime = eventCreationDateTime;
        this.apartmentId = apartmemtId;
        this.ownerId = ownerId;
        this.tenantId = tenantId;
        periodStart = period.getStart();
        periodEnd = period.getEnd();
    }

    static ApartmentBooked create(String apartmemtId, String ownerId, String tenantId, Period period){
        final String eventId = UUID.randomUUID().toString();
        final LocalDateTime eventCreationDateTime = LocalDateTime.now();

        return new ApartmentBooked(eventId, eventCreationDateTime, apartmemtId, ownerId, tenantId, period);
    }

   public String getEventId() {
        return eventId;
    }

   public LocalDateTime getEventCreationDateTime() {
        return eventCreationDateTime;
    }

   public String getApartmentId() {
        return apartmentId;
    }

   public String getOwnerId() {
        return ownerId;
    }

   public String getTenantId() {
        return tenantId;
    }

   public LocalDate getPeriodStart() {
        return periodStart;
    }

   public LocalDate getPeriodEnd() {
        return periodEnd;
    }
}
