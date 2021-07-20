package com.bluesoft.rentalapplication.domain.apartment;


import com.google.inject.internal.util.ImmutableMap;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThatHasRooms(actual, roomsDefinition);
    }

    private void assertThatHasRooms(final Apartment actual, final Map<String, Double> roomsDefinition) {

    }

    private void assertThatHasAddress(final Apartment actual, final String street, final String postalCode, final String houseNumber, final String apartmentNumber, final String city, final String country) {
          assertThat(actual).extracting("address")
                  .hasFieldOrPropertyWithValue("street",street)
                  .hasFieldOrPropertyWithValue("postalCode",postalCode)
                  .hasFieldOrPropertyWithValue("houseNumber",houseNumber)
                  .hasFieldOrPropertyWithValue("apartmentNumber",apartmentNumber)
                  .hasFieldOrPropertyWithValue("city",city)
                  .hasFieldOrPropertyWithValue("country",country);
    }

    private void assertThatHasDescription(final Apartment actual, final String description) {
         assertThat(actual).hasFieldOrPropertyWithValue("description",description);
    }

    private void assertThatHasOwnerId(final Apartment actual, final String ownerId) {
        assertThat(actual).hasFieldOrPropertyWithValue("ownerId",ownerId);
    }

}