package com.bluesoft.rentalapplication.domain.apartmentbookinghistory;

import org.assertj.core.api.Assertions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ApartmentBookingAssertion {
    private ApartmentBooking actual;

    public ApartmentBookingAssertion(final ApartmentBooking actual) {
        this.actual = actual;
    }

    public static ApartmentBookingAssertion assertThat(final ApartmentBooking actual) {
        return new ApartmentBookingAssertion(actual);
    }

    public ApartmentBookingAssertion hasBookingDateTimeEqualTo(final LocalDateTime expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingDateTime", expected);
        return this;
    }

    public ApartmentBookingAssertion hasOwnerIdEqualTo(final String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("ownerId", expected);
        return this;
    }

    public ApartmentBookingAssertion hasTenantIdEqualTo(final String expected) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("tenantId", expected);
        return this;
    }

    public ApartmentBookingAssertion hasBookingPeriodThatHas(final LocalDate expectedStart, final LocalDate expectedEnd) {
        Assertions.assertThat(actual)
                .hasFieldOrPropertyWithValue("bookingPeriod.periodStart", expectedStart)
                .hasFieldOrPropertyWithValue("bookingPeriod.periodEnd", expectedEnd);
        return this;
    }

    ApartmentBookingAssertion isStart() {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("bookingStep", BookingStep.START);
        return this;
    }

}
