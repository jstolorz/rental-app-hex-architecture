package com.bluesoft.rentalapplication.domain.apartment;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ApartmentBookedTest {

    @Test
    void shouldCreateEventWithAllInformation(){

        final String apartmentId = "1234";
        final String ownerId = "5678";
        final String tenantId = "3456";
        final LocalDate periodStart = LocalDate.of(2021, 8, 14);
        final LocalDate periodEnd = LocalDate.of(2021,8,24);
        final Period period = new Period(periodStart,periodEnd);

        final ApartmentBooked actual = ApartmentBooked.create(apartmentId, ownerId, tenantId, period);

        assertThat(actual.getEventId()).matches(Pattern.compile("[0-9a-z\\-]{36}"));
        assertThat(actual.getEventCreationDateTime()).isBefore(LocalDateTime.now().plusSeconds(2));
        assertThat(actual.getApartmentId()).isEqualTo("1234");
        assertThat(actual.getOwnerId()).isEqualTo("5678");
        assertThat(actual.getTenantId()).isEqualTo("3456");
        assertThat(actual.getPeriodStart()).isEqualTo(periodStart);
        assertThat(actual.getPeriodEnd()).isEqualTo(periodEnd);

    }

}