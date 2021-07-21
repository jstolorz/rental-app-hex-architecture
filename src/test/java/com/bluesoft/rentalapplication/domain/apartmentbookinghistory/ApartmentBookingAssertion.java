package com.bluesoft.rentalapplication.domain.apartmentbookinghistory;

import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

class ApartmentBookingAssertion {
    private ApartmentBooking actual;

    public ApartmentBookingAssertion(final ApartmentBooking actual) {
        this.actual = actual;
    }

    static ApartmentBookingAssertion assertThat(final ApartmentBooking actual) {
        return new ApartmentBookingAssertion(actual);
    }

    ApartmentBookingAssertion hasBookingDateTimeEqualTo(final LocalDateTime expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingDateTime",expected);
        return this;
    }

    ApartmentBookingAssertion hasOwnerIdEqualTo(final String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("ownerId",expected);
        return this;
    }

    ApartmentBookingAssertion hasTenantIdEqualTo(final String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("tenantId",expected);
        return this;
    }

    ApartmentBookingAssertion hasBookingPeriodThatHas(final LocalDate expectedStart, final LocalDate expectedEnd) {
        Assertions.assertThat(actual)
                .hasFieldOrPropertyWithValue("bookingPeriod.periodStart",expectedStart)
                .hasFieldOrPropertyWithValue("bookingPeriod.periodEnd",expectedEnd);
       return this;
    }

    ApartmentBookingAssertion isStart() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingStep", BookingStep.START);
        return this;
    }
}
