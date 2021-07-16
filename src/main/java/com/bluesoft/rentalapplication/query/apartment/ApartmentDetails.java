package com.bluesoft.rentalapplication.query.apartment;


public class ApartmentDetails {
    private final ApartmentReadModel apartment;
    private final ApartmentBookingHistoryReadModel bookingHistory;

    public ApartmentDetails(final ApartmentReadModel apartment, final ApartmentBookingHistoryReadModel bookingHistory) {
        this.apartment = apartment;
        this.bookingHistory = bookingHistory;
    }

   public ApartmentReadModel getApartment() {
        return apartment;
    }

   public ApartmentBookingHistoryReadModel getBookingHistory() {
        return bookingHistory;
    }
}
