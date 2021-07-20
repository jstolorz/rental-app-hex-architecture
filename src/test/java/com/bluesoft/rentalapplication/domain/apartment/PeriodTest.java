package com.bluesoft.rentalapplication.domain.apartment;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PeriodTest {

    @Test
    void shouldConvertStartAdnEndDatePointAsListOfDays(){

        final LocalDate start = LocalDate.of(2021,7,20);
        final LocalDate end = LocalDate.of(2021,7,30);

        final List<LocalDate> actual = new Period(start, end).asDays();

        actual.forEach(date -> {
            assertThat(date).isBeforeOrEqualTo(end);
            assertThat(date).isAfterOrEqualTo(start);
        });
    }

    @Test
    void shouldReturnAllDaysBetweenStartAndEnd(){
        final LocalDate start = LocalDate.of(2020,1,1);
        final LocalDate end = LocalDate.of(2020,1,3);
        final List<LocalDate> actual = new Period(start, end).asDays();

        assertThat(actual).containsExactly(start,LocalDate.of(2020,1,2),end);

    }

}