package com.bluesoft.rentalapplication.domain.apartment;

import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

class BookingAssertion {
    private Booking actual;

    public BookingAssertion(final Booking actual) {
        this.actual = actual;
    }

    static BookingAssertion assertThat(final Booking actual) {
        return new BookingAssertion(actual);
    }

    BookingAssertion hasRentalPlaceIdEqualTo(final String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalPlaceId",expected);
        return this;
    }


    BookingAssertion hasTenantIdEqualTo(final String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("tenantId",expected);
        return this;
    }

    BookingAssertion hasDaysContainsAll(final LocalDate expectedStart, final LocalDate expectedEnd) {
        final List<LocalDate> dates = expectedStart.datesUntil(expectedEnd).collect(Collectors.toList());
        dates.add(expectedEnd);
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("days",dates);
        return this;
    }

    BookingAssertion hasDaysContainsAll(final List<LocalDate> expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("days",expected);
        return this;
    }

    BookingAssertion isApartment() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalType",RentalType.APARTMENT);
        return this;
    }

    BookingAssertion isHotelRoom() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("rentalType",RentalType.HOTEL_ROOM);
        return this;
    }

    BookingAssertion isOpen() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingStatus",BookingStatus.OPEN);
        return this;
    }
}