package com.bluesoft.rentalapplication.domain.apartment;


import com.bluesoft.rentalapplication.domain.eventchannel.EventChannel;
import com.google.inject.internal.util.ImmutableMap;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Map;

class ApartmentTest {

    public static final String OWNER_ID = "1234";
    public static final String STREET = "Zdrowotna";
    public static final String POSTAL_CODE = "43-384";
    public static final String HOUSE_NUMBER = "10";
    public static final String APARTMENT_NUMBER = "1";
    public static final String CITY = "Jaworze";
    public static final String COUNTRY = "Poland";
    public static final String DESCRIPTION = "Nice place to stay";
    public static final Map<String, Double> ROOMS_DEFINITION = ImmutableMap.of(
            "Toilet", 10.0, "Bedroom", 30.0
    );
    public static final ApartmentFactory APARTMENT_FACTORY = new ApartmentFactory();
    private static final String TENANT_ID = "2345";
    private static final LocalDate START = LocalDate.of(2021,7,10);
    private static final LocalDate END = LocalDate.of(2021, 7, 15);
    private static final Period PERIOD = new Period(START, END);
    private EventChannel eventChannel = Mockito.mock(EventChannel.class);

    @Test
    void shouldCreateApartmentWithAllRequiredFields() {

        final Apartment actual = createApartment();
        ApartmentAssertion.assertThat(actual)
               .HasOwnerIdEqualsTo( OWNER_ID)
               .HasDescriptionEqualsTo( DESCRIPTION)
               .HasAddressEqualsTo( STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER, CITY, COUNTRY)
               .HasRoomsEqualsTo( ROOMS_DEFINITION);
    }

    private Apartment createApartment() {
        return APARTMENT_FACTORY.create(
                OWNER_ID,
                STREET,
                POSTAL_CODE,
                HOUSE_NUMBER,
                APARTMENT_NUMBER,
                CITY,
                COUNTRY,
                DESCRIPTION,
                ROOMS_DEFINITION
        );
    }

    @Test
    void shouldPublishApartmentBooked(){
        ArgumentCaptor<ApartmentBooked> captor = ArgumentCaptor.forClass(ApartmentBooked.class);
        final Apartment apartment = createApartment();

        apartment.book(TENANT_ID, PERIOD, eventChannel);

        BDDMockito.then(eventChannel).should().publish(captor.capture());

        ApartmentBooked actual = captor.getValue();

        Assertions.assertThat(actual.getTenantId()).isEqualTo(TENANT_ID);
        Assertions.assertThat(actual.getOwnerId()).isEqualTo(OWNER_ID);
        Assertions.assertThat(actual.getPeriodStart()).isEqualTo(START);
        Assertions.assertThat(actual.getPeriodEnd()).isEqualTo(END);


    }


    @Test
    void shouldCreateBookingOnceBook(){
        final Apartment apartment = createApartment();

        final Booking actual = apartment.book(TENANT_ID, PERIOD, eventChannel);

        BookingAssertion.assertThat(actual)
                .isApartment()
                .hasTenantIdEqualTo(TENANT_ID)
                .hasDaysContainsAll(START,END);

    }

}