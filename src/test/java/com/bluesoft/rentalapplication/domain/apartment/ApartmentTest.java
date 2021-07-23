package com.bluesoft.rentalapplication.domain.apartment;


import com.google.inject.internal.util.ImmutableMap;
import org.junit.jupiter.api.Test;

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

    @Test
    void shouldCreateApartmentWithAllRequiredFields() {

        final Apartment actual = APARTMENT_FACTORY.create(
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
        ApartmentAssertion.assertThat(actual)
               .HasOwnerIdEqualsTo( OWNER_ID)
               .HasDescriptionEqualsTo( DESCRIPTION)
               .HasAddressEqualsTo( STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER, CITY, COUNTRY)
               .HasRoomsEqualsTo( ROOMS_DEFINITION);
    }


}