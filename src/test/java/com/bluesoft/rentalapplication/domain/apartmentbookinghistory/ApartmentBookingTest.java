package com.bluesoft.rentalapplication.domain.apartmentbookinghistory;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ApartmentBookingTest {

    @Test
    void shouldCreateStartApartmentBookingWithAllRequiredInformation(){
        final LocalDateTime bookingDateTime = LocalDateTime.of(2021,7,10,3,4);
        final String ownerId = "123";
        final String tenantId = "345";
        final LocalDate periodStart = LocalDate.of(2021,7,12);
        final LocalDate periodEnd = LocalDate.of(2021,7,21);;

        final ApartmentBooking actual = ApartmentBooking.start(
                bookingDateTime, ownerId, tenantId, new BookingPeriod(periodStart, periodEnd));


         ApartmentBookingAssertion.assertThat(actual)
                 .isStart()
                 .hasBookingDateTimeEqualTo(bookingDateTime)
                 .hasOwnerIdEqualTo(ownerId)
                 .hasTenantIdEqualTo(tenantId)
                 .hasBookingPeriodThatHas(periodStart,periodEnd);
    }

}