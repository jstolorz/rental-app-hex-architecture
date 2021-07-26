package com.bluesoft.rentalapplication.application.hotelroom;

import com.bluesoft.rentalapplication.domain.apartment.Booking;
import com.bluesoft.rentalapplication.domain.apartment.BookingAssertion;
import com.bluesoft.rentalapplication.domain.apartment.BookingRepository;
import com.bluesoft.rentalapplication.domain.eventchannel.EventChannel;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoom;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomFactory;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomRepository;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomTestFactory;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.mock;

class HotelRoomApplicationServiceTest {

    private static final String ID = "12";
    private static final String TENANT_ID = "1234";
    private static final List<LocalDate> DAYS = ImmutableList.of(
            LocalDate.of(2021, 7, 10),
            LocalDate.of(2021, 7, 12)
    );
    private static final String HOTEL_ID = "12";
    private static final int NUMBER = 22;
    private static final String DESCRIPTION = "dddd";
    private final HotelRoomRepository hotelRoomRepository = mock(HotelRoomRepository.class);
    private final BookingRepository bookingRepository = mock(BookingRepository.class);
    private final EventChannel eventChannel = mock(EventChannel.class);

    HotelRoomApplicationService service = new HotelRoomApplicationService(hotelRoomRepository,bookingRepository,eventChannel);

    @Test
    void shouldBookHotelRoom(){

        ArgumentCaptor<Booking> captor = ArgumentCaptor.forClass(Booking.class);

        final HotelRoom hotelRoom = HotelRoomTestFactory.create(HOTEL_ID, NUMBER, DESCRIPTION);
        BDDMockito.given(hotelRoomRepository.findById(ID)).willReturn(hotelRoom);
        service.book(ID,TENANT_ID,DAYS);

        BDDMockito.then(bookingRepository).should().save(captor.capture());

        BookingAssertion.assertThat(captor.getValue())
                .isHotelRoom()
                .hasTenantIdEqualTo(TENANT_ID)
                .hasDaysContainsAll(DAYS);

    }

    @Test
    void shouldBookingWhenHotelRoomBooked(){

        final String hotelRoomId = "1234";
        givenHotelRoom(hotelRoomId);

        service.book(hotelRoomId,TENANT_ID,DAYS);

        thenBookShouldBeCreated();

    }

    private void thenBookShouldBeCreated() {
        ArgumentCaptor<Booking> captor = ArgumentCaptor.forClass(Booking.class);
        BDDMockito.then(bookingRepository).should().save(captor.capture());
        BookingAssertion.assertThat(captor.getValue())
                .isHotelRoom()
                .hasTenantIdEqualTo(TENANT_ID)
                .hasDaysContainsAll(DAYS);
    }

    private void givenHotelRoom(final String hotelRoomId) {
        final HotelRoom hotelRoom = createHotelRoom();
        BDDMockito.given(hotelRoomRepository.findById(hotelRoomId)).willReturn(hotelRoom);
    }

    private HotelRoom createHotelRoom() {
        return new HotelRoomFactory().create("5678",42, ImmutableMap.of("Room1",30.0), "Nice");
    }

}