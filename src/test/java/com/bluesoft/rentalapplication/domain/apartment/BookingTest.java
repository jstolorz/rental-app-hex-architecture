package com.bluesoft.rentalapplication.domain.apartment;


import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class BookingTest {

     @Test
     void shouldReturnBookingOfApartment(){
         final String rentalPlaceId = "123";
         final String tenantId = "345";
         final LocalDate start = LocalDate.of(2021,7,1);
         final LocalDate end = LocalDate.of(2021,7,10);

         final Booking actual = Booking.apartment(rentalPlaceId, tenantId, new Period(start, end));

         BookingAssertion.assertThat(actual)
                 .isOpen()
                 .isApartment()
                 .hasRentalPlaceIdEqualTo(rentalPlaceId)
                 .hasTenantIdEqualTo(tenantId)
                 .hasDaysContainsAll(start,end);

     }

    @Test
    void shouldReturnBookingOfHotelRoom(){
        final String rentalPlaceId = "123";
        final String tenantId = "345";
        final List<LocalDate> days = ImmutableList.of(
                LocalDate.of(2021,7,1),
                LocalDate.of(2021,7,2),
                LocalDate.of(2021,7,3)
        );

        final Booking actual = Booking.hotelRoom(rentalPlaceId, tenantId, days);

        BookingAssertion.assertThat(actual)
                .isOpen()
                .isHotelRoom()
                .hasRentalPlaceIdEqualTo(rentalPlaceId)
                .hasTenantIdEqualTo(tenantId)
                .hasDaysContainsAll(days);

    }

}