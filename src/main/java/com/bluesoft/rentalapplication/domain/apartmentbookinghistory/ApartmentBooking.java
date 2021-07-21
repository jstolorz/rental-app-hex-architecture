package com.bluesoft.rentalapplication.domain.apartmentbookinghistory;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "APARTMENT_BOOKING")
public class ApartmentBooking {

    private final BookingStep bookingStep;
    private LocalDateTime bookingDateTime;
    private final String ownerId;
    private final String tenantId;

    @Embedded
    private final BookingPeriod bookingPeriod;

    public ApartmentBooking(final BookingStep start, final LocalDateTime bookingDateTime, final String ownerId, final String tenantId, final BookingPeriod bookingPeriod) {

        this.bookingStep = start;
        this.bookingDateTime = bookingDateTime;
        this.ownerId = ownerId;
        this.tenantId = tenantId;
        this.bookingPeriod = bookingPeriod;
    }

    public static ApartmentBooking start(final LocalDateTime bookingDateTime, final String ownerId, final String tenantId, final BookingPeriod bookingPeriod) {
        return new ApartmentBooking(BookingStep.START,bookingDateTime, ownerId,tenantId,bookingPeriod);
    }
}
