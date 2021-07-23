package com.bluesoft.rentalapplication.domain.apartment;

import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;

class ApartmentAssertion {


    private Apartment actual;

    public ApartmentAssertion(final Apartment actual) {

        this.actual = actual;
    }

    static ApartmentAssertion assertThat(final Apartment actual) {
        return new ApartmentAssertion(actual);
    }

    ApartmentAssertion HasOwnerIdEqualsTo(final String ownerId) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("ownerId", ownerId);
        return this;
    }

    ApartmentAssertion HasDescriptionEqualsTo(final String description) {
        Assertions.assertThat(actual).hasFieldOrPropertyWithValue("description", description);
        return this;
    }

    ApartmentAssertion HasAddressEqualsTo(final String street, final String postalCode, final String houseNumber, final String apartmentNumber, final String city, final String country) {
        Assertions.assertThat(actual).extracting("address")
                .hasFieldOrPropertyWithValue("street", street)
                .hasFieldOrPropertyWithValue("postalCode", postalCode)
                .hasFieldOrPropertyWithValue("houseNumber", houseNumber)
                .hasFieldOrPropertyWithValue("apartmentNumber", apartmentNumber)
                .hasFieldOrPropertyWithValue("city", city)
                .hasFieldOrPropertyWithValue("country", country);
        return this;
    }

    ApartmentAssertion HasRoomsEqualsTo(final Map<String, Double> roomsDefinition) {
        Assertions.assertThat(actual).extracting("rooms").satisfies(roomsActual -> {
            List<Room> rooms = (List<Room>) roomsActual;
            Assertions.assertThat(rooms).hasSize(roomsDefinition.size());

            roomsDefinition.forEach((name, squareMeter) -> {
                Assertions.assertThat(rooms).anySatisfy(room -> {
                    Assertions.assertThat(room)
                            .hasFieldOrPropertyWithValue("name", name)
                            .hasFieldOrPropertyWithValue("squerMeter.size", squareMeter);
                });
            });

        });
        return this;
    }
}
