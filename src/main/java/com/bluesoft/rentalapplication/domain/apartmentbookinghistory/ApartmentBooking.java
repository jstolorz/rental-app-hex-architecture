package com.bluesoft.rentalapplication.domain.apartmentbookinghistory;

public class ApartmentBooking {

    private final BookingStep start;
    private final String ownerId;
    private final String tenantId;
    private final BookingPeriod bookingPeriod;

    public ApartmentBooking(final BookingStep start, final String ownerId, final String tenantId, final BookingPeriod bookingPeriod) {

        this.start = start;
        this.ownerId = ownerId;
        this.tenantId = tenantId;
        this.bookingPeriod = bookingPeriod;
    }

    public static ApartmentBooking start(final String ownerId, final String tenantId, final BookingPeriod bookingPeriod) {
        return new ApartmentBooking(BookingStep.START, ownerId,tenantId,bookingPeriod);
    }
}
