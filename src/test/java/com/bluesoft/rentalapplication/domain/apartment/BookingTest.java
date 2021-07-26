package com.bluesoft.rentalapplication.domain.apartment;


import com.bluesoft.rentalapplication.domain.eventchannel.EventChannel;
import com.google.common.collect.ImmutableList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;

import java.time.LocalDate;
import java.util.List;

import static com.bluesoft.rentalapplication.domain.apartment.BookingAssertion.assertThat;
import static org.mockito.Mockito.mock;

class BookingTest {

    private static final String RENTAL_PLACEID =  "1234";
    private static final String TENANT_ID = "2345";
    private static final List<LocalDate> DAYS = ImmutableList.of(
            LocalDate.of(2021,7,10),
            LocalDate.of(2021,7,12)
    );
    private EventChannel eventChannel = mock(EventChannel.class);

    @Test
     void shouldReturnBookingOfApartment(){
         final String rentalPlaceId = "123";
         final String tenantId = "345";
         final LocalDate start = LocalDate.of(2021,7,1);
         final LocalDate end = LocalDate.of(2021,7,10);

         final Booking actual = Booking.apartment(rentalPlaceId, tenantId, new Period(start, end));

         assertThat(actual)
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

        assertThat(actual)
                .isOpen()
                .isHotelRoom()
                .hasRentalPlaceIdEqualTo(rentalPlaceId)
                .hasTenantIdEqualTo(tenantId)
                .hasDaysContainsAll(days);

    }

    @Test
   void shouldChangeStatusOfBookingOnceAccepted(){
        final Booking booking = Booking.hotelRoom(RENTAL_PLACEID, TENANT_ID, DAYS);
        booking.accept(eventChannel);

        assertThat(booking)
                .isAccepted();
    }

    @Test
    void shouldPublishBookingAcceptedOnceAccepted(){
        ArgumentCaptor<BookingAccepted> captor = ArgumentCaptor.forClass(BookingAccepted.class);

        final Booking actual = Booking.hotelRoom(RENTAL_PLACEID, TENANT_ID, DAYS);
        actual.accept(eventChannel);

        BDDMockito.then(eventChannel).should().publish(captor.capture());

        BookingAccepted accepted = captor.getValue();

        Assertions.assertThat(accepted.getRentalType()).isEqualTo("HOTEL_ROOM");
        Assertions.assertThat(accepted.getRentalPlaceId()).isEqualTo(RENTAL_PLACEID);

    }


}