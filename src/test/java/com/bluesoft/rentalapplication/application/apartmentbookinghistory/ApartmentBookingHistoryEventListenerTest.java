package com.bluesoft.rentalapplication.application.apartmentbookinghistory;

import com.bluesoft.rentalapplication.domain.apartment.ApartmentBooked;
import com.bluesoft.rentalapplication.domain.apartment.ApartmentBookedTestFactory;
import com.bluesoft.rentalapplication.domain.apartment.Period;
import com.bluesoft.rentalapplication.domain.apartmentbookinghistory.ApartmentBooking;
import com.bluesoft.rentalapplication.domain.apartmentbookinghistory.ApartmentBookingAssertion;
import com.bluesoft.rentalapplication.domain.apartmentbookinghistory.ApartmentBookingHistory;
import com.bluesoft.rentalapplication.domain.apartmentbookinghistory.ApartmentBookingHistoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class ApartmentBookingHistoryEventListenerTest {

    private static final String APARTMENT_ID = "1234";
    private static final String OWNER_ID = "3456";
    private static final String TENANT_ID = "3434";
    private static final LocalDate START = LocalDate.of(2021, 7, 20);
    private static final LocalDate END = LocalDate.of(2021, 7, 28);
    private static final Period PERIOD = new Period(START,END);

    private final ArgumentCaptor<ApartmentBookingHistory> captor = ArgumentCaptor.forClass(ApartmentBookingHistory.class);
    private final ApartmentBookingHistoryRepository repository = mock(ApartmentBookingHistoryRepository.class);
    private final ApartmentBookingHistoryEventListener eventListener = new ApartmentBookingHistoryEventListener(repository);

    @Test
    void shouldCreateApartmentBookingHistoryWhenConsumingApartmentBooked(){
          givenNotExistingApartmentBookingHistory();
          eventListener.consume(givenApartmentBooking());

          then(repository).should().save(captor.capture());

          thenApartmentBookingHistoryShouldHave(captor.getValue(),OWNER_ID,TENANT_ID,START,END,1);
    }

    private void thenApartmentBookingHistoryShouldHave(
            final ApartmentBookingHistory actual, final String ownerId,
            final String tenantId, final LocalDate start, final LocalDate end, int bookingSize) {

        Assertions.assertThat(actual).extracting("bookings").satisfies(actualBookings -> {
            List<ApartmentBooking> bookings = (List<ApartmentBooking>)actualBookings;
            Assertions.assertThat(bookings)
                    .hasSize(bookingSize)
                    .anySatisfy(actualBooking -> {
                        ApartmentBookingAssertion.assertThat(actualBooking)
                                .hasOwnerIdEqualTo(OWNER_ID)
                                .hasTenantIdEqualTo(TENANT_ID)
                                .hasBookingPeriodThatHas(START,END);
                    });
        });
    }


    private void givenNotExistingApartmentBookingHistory() {
        BDDMockito.given(repository.exists(APARTMENT_ID)).willReturn(false);
    }

    @Test
    void shouldUpdateApartmentBookingHistoryWhenConsumingApartmentBooked(){
        givenExistingApartmentBookingHistory();
        eventListener.consume(givenApartmentBooking());

        then(repository).should().save(captor.capture());

        thenApartmentBookingHistoryShouldHave(captor.getValue(),OWNER_ID,TENANT_ID,START,END,1);
    }

    private void givenExistingApartmentBookingHistory() {
        BDDMockito.given(repository.exists(APARTMENT_ID)).willReturn(true);

        final ApartmentBookingHistory apartmentBookingHistory = new ApartmentBookingHistory(APARTMENT_ID);
        BDDMockito.given(repository.findFor(APARTMENT_ID)).willReturn(apartmentBookingHistory);


    }

    private ApartmentBooked givenApartmentBooking() {
        return ApartmentBookedTestFactory.create(APARTMENT_ID,OWNER_ID,TENANT_ID,PERIOD);
    }


}