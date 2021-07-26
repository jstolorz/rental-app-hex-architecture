package com.bluesoft.rentalapplication.domain.apartment;

import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BookingAssertion {
    private Booking actual;

    public BookingAssertion(final Booking actual) {
        this.actual = actual;
    }

    public static BookingAssertion assertThat(final Booking actual) {
        return new BookingAssertion(actual);
    }

    public BookingAssertion hasRentalPlaceIdEqualTo(final String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalPlaceId", expected);
        return this;
    }


    public BookingAssertion hasTenantIdEqualTo(final String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("tenantId", expected);
        return this;
    }

    public BookingAssertion hasDaysContainsAll(final LocalDate expectedStart, final LocalDate expectedEnd) {
        final List<LocalDate> dates = expectedStart.datesUntil(expectedEnd).collect(Collectors.toList());
        dates.add(expectedEnd);
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("days", dates);
        return this;
    }

    public BookingAssertion hasDaysContainsAll(final List<LocalDate> expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("days", expected);
        return this;
    }

    public BookingAssertion isApartment() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalType", RentalType.APARTMENT);
        return this;
    }

    public BookingAssertion isHotelRoom() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalType", RentalType.HOTEL_ROOM);
        return this;
    }

    public BookingAssertion isOpen() {
        final BookingStatus expected = BookingStatus.OPEN;
        return hasBookingStatusEqualTo(expected);
    }

    private BookingAssertion hasBookingStatusEqualTo(final BookingStatus expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingStatus", expected);
        return this;
    }

    BookingAssertion isAccepted() {
        final BookingStatus expected = BookingStatus.ACCEPT;
        return hasBookingStatusEqualTo(expected);
    }
}
