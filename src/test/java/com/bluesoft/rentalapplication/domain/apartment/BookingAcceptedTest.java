package com.bluesoft.rentalapplication.domain.apartment;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class BookingAcceptedTest {

    @Test
    void shouldCreateBookingAcceptedWithAllRequiredInformation(){

        final RentalType rentalType = RentalType.APARTMENT;
        final String rentalPlaceId = "123";
        final String tenantId = "234";
        final List<LocalDate> days = ImmutableList.of(
                LocalDate.of(2021,7,10),
                LocalDate.of(2021,7,11),
                LocalDate.of(2021,7,12),
                LocalDate.of(2021,7,13)
        );

        final BookingAccepted actual = BookingAccepted.create(rentalType, rentalPlaceId, tenantId, days);

        assertThat(actual.getEventId()).matches(Pattern.compile("[0-9a-z\\-]{36}"));
        assertThat(actual.getEventDateTime()).isBefore(LocalDateTime.now().plusSeconds(2));
        assertThat(actual).hasFieldOrPropertyWithValue("rentalType", "APARTMENT");
        assertThat(actual).hasFieldOrPropertyWithValue("rentalPlaceId", rentalPlaceId);
        assertThat(actual).hasFieldOrPropertyWithValue("tenantId", tenantId);
        assertThat(actual.getDays()).containsExactlyElementsOf(days);
    }

    @Test
    void shouldCreateEventWithAllInformation(){

        final RentalType rentalType = RentalType.APARTMENT;
        final String rentalPlaceId = "123";
        final String tenantId = "234";
        final List<LocalDate> days = asList(
                LocalDate.of(2021,7,10),
                LocalDate.of(2021,7,11),
                LocalDate.of(2021,7,12),
                LocalDate.of(2021,7,13)
        );

        shouldCreateEventWithAllInformation(rentalType, rentalPlaceId, tenantId, days);

    }

    @ParameterizedTest
    @MethodSource("createBookingAccepted")
    void shouldCreateEventWithAllInformation(final RentalType rentalType, final String rentalPlaceId, final String tenantId, final List<LocalDate> days) {
        final BookingAccepted actual = BookingAccepted.create(rentalType, rentalPlaceId, tenantId, days);

        assertThat(actual.getEventId()).matches(Pattern.compile("[0-9a-z\\-]{36}"));
        assertThat(actual.getEventDateTime()).isBefore(LocalDateTime.now().plusSeconds(2));
        assertThat(actual).hasFieldOrPropertyWithValue("rentalType", rentalType.name());
        assertThat(actual).hasFieldOrPropertyWithValue("rentalPlaceId", rentalPlaceId);
        assertThat(actual).hasFieldOrPropertyWithValue("tenantId", tenantId);
        assertThat(actual.getDays()).containsExactlyElementsOf(days);
    }

    private static Stream<Arguments> createBookingAccepted() {
        return Stream.of(
                Arguments.of(
                        RentalType.APARTMENT,"123","345",
                        asList(
                                LocalDate.of(2021,7,10),
                                LocalDate.of(2021,7,11),
                                LocalDate.of(2021,7,12),
                                LocalDate.of(2021,7,13)
                        )
                ),
                Arguments.of(
                        RentalType.HOTEL_ROOM,"12333","345666",
                        asList(
                                LocalDate.of(2021,9,10),
                                LocalDate.of(2021,9,11),
                                LocalDate.of(2021,9,12),
                                LocalDate.of(2021,9,13)
                        )
                )

        );
    }


}