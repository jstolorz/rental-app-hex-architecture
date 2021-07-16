package com.bluesoft.rentalapplication.query.apartment;

import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "APARTMENT_BOOKING")
public class ApartmentBookingReadModel {

    private final String bookingStep;
    private LocalDateTime bookingDateTime;
    private final String ownerId;
    private final String tenantId;

    private final LocalDate periodStart;
    private final LocalDate periodEnd;

    ApartmentBookingReadModel(final String bookingStep, final LocalDateTime bookingDateTime, final String ownerId, final String tenantId, final LocalDate periodStart, final LocalDate periodEnd) {
        this.bookingStep = bookingStep;
        this.bookingDateTime = bookingDateTime;
        this.ownerId = ownerId;
        this.tenantId = tenantId;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }

   public String getBookingStep() {
        return bookingStep;
    }

   public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
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
