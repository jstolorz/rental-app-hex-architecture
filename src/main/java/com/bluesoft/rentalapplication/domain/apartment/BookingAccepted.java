package com.bluesoft.rentalapplication.domain.apartment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BookingAccepted {


    private final String eventId;
    private final LocalDateTime eventDateTime;
    private final String rentalType;
    private final String rentalPlaceId;
    private final String tenantId;
    private final List<LocalDate> days;

    BookingAccepted(final String eventId, final LocalDateTime eventDateTime, final String rentalType, final String rentalPlaceId, final String tenantId, final List<LocalDate> days) {

        this.eventId = eventId;
        this.eventDateTime = eventDateTime;
        this.rentalType = rentalType;
        this.rentalPlaceId = rentalPlaceId;
        this.tenantId = tenantId;
        this.days = days;
    }

    static BookingAccepted create(
            final RentalType rentalType,
            final String rentalPlaceId,
            final String tenantId,
            final List<LocalDate> days) {

        final String eventId = UUID.randomUUID().toString();
        final LocalDateTime eventDateTime = LocalDateTime.now();

        return new BookingAccepted(eventId,eventDateTime,rentalType.name(),rentalPlaceId,tenantId,days);
    }

    String getEventId() {
        return eventId;
    }

    LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    String getRentalType() {
        return rentalType;
    }

    String getRentalPlaceId() {
        return rentalPlaceId;
    }

    String getTenantId() {
        return tenantId;
    }

    List<LocalDate> getDays() {
        return days;
    }
}
