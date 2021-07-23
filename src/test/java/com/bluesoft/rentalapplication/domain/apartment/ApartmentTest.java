package com.bluesoft.rentalapplication.domain.apartment;


import com.google.inject.internal.util.ImmutableMap;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void shouldCreateApartmentWithAllRequiredFields() {

        final Apartment actual = new ApartmentFactory().create(
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

        assertThatHasOwnerId(actual, OWNER_ID);
        assertThatHasDescription(actual, DESCRIPTION);
        assertThatHasAddress(actual, STREET, POSTAL_CODE, HOUSE_NUMBER, APARTMENT_NUMBER, CITY, COUNTRY);
        assertThatHasRooms(actual, ROOMS_DEFINITION);
    }

    private void assertThatHasRooms(final Apartment actual, final Map<String, Double> roomsDefinition) {
        assertThat(actual).extracting("rooms").satisfies(roomsActual -> {
            List<Room> rooms = (List<Room>) roomsActual;
            assertThat(rooms).hasSize(roomsDefinition.size());

            roomsDefinition.forEach((name, squareMeter) -> {
                assertThat(rooms).anySatisfy(room -> {
                    assertThat(room)
                            .hasFieldOrPropertyWithValue("name", name)
                            .hasFieldOrPropertyWithValue("squerMeter.size", squareMeter);
                });
            });

        });
    }

    private void assertThatHasAddress(final Apartment actual, final String street, final String postalCode, final String houseNumber, final String apartmentNumber, final String city, final String country) {
        assertThat(actual).extracting("address")
                .hasFieldOrPropertyWithValue("street", street)
                .hasFieldOrPropertyWithValue("postalCode", postalCode)
                .hasFieldOrPropertyWithValue("houseNumber", houseNumber)
                .hasFieldOrPropertyWithValue("apartmentNumber", apartmentNumber)
                .hasFieldOrPropertyWithValue("city", city)
                .hasFieldOrPropertyWithValue("country", country);
    }

    private void assertThatHasDescription(final Apartment actual, final String description) {
        assertThat(actual).hasFieldOrPropertyWithValue("description", description);
    }

    private void assertThatHasOwnerId(final Apartment actual, final String ownerId) {
        assertThat(actual).hasFieldOrPropertyWithValue("ownerId", ownerId);
    }

}