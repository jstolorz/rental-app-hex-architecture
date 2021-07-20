package com.bluesoft.rentalapplication.domain.apartment;


import com.google.inject.internal.util.ImmutableMap;
import org.junit.jupiter.api.Test;

import java.util.Map;

class ApartmentTest {

    @Test
    void shouldCreateApartmentWithAllRequiredFields(){
        final String ownerId = "1234";
        final String street = "Zdrowotna";
        final String postalCode = "43-384";
        final String houseNumber = "10";
        final String apartmentNumber = "1";
        final String city = "Jaworze";
        final String country = "Poland";
        final String description = "Nice place to stay";

        final Map<String, Double> roomsDefinition = ImmutableMap.of(
                "Toilet", 10.0, "Bedroom", 30.0
        );

        final Apartment actual = new ApartmentFactory().create(
                ownerId,
                street,
                postalCode,
                houseNumber,
                apartmentNumber,
                city,
                country,
                description,
                roomsDefinition
        );

        assertThatHasOwnerId(actual, ownerId);
        assertThatHasDescription(actual, description);
        assertThatHasAddress(actual, street, postalCode, houseNumber, apartmentNumber, city, country);
        assertThatHasRomms(actual, roomsDefinition);
    }

    private void assertThatHasRomms(final Apartment actual, final Map<String, Double> roomsDefinition) {

    }

    private void assertThatHasAddress(final Apartment actual, final String street, final String postalCode, final String houseNumber, final String apartmentNumber, final String city, final String country) {

    }

    private void assertThatHasDescription(final Apartment actual, final String description) {

    }

    private void assertThatHasOwnerId(final Apartment actual, final String ownerId) {
    }

}