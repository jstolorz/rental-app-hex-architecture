package com.bluesoft.rentalapplication.domain.apartment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
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
    void shouldReturnOneDateWhenStartAndEndAreTheSame(){
        final LocalDate date = LocalDate.of(2021, 7, 20);
        final List<LocalDate> actual = new Period(date, date).asDays();
        assertThat(actual).containsExactly(date);
    }

    @Test
    void shouldReturnAllDaysBetweenStartAndEnd(){
        final LocalDate start = LocalDate.of(2020,1,1);
        final LocalDate end = LocalDate.of(2020,1,3);
        Iterable<LocalDate> expected = asList(start,LocalDate.of(2020,1,2),end);

        shouldReturnAllDaysBetweenStartAndEnd(start, end, expected);

    }

    @ParameterizedTest
    @MethodSource("daysBetweenStartAndEnd")
    void shouldReturnAllDaysBetweenStartAndEnd(final LocalDate start, final LocalDate end, final Iterable<LocalDate> expected) {
        final List<LocalDate> actual = new Period(start, end).asDays();

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    private static Stream<Arguments> daysBetweenStartAndEnd() {
        return Stream.of(
                Arguments.of(
                         LocalDate.of(2021,1,1),LocalDate.of(2021,1,3),
                        asList(LocalDate.of(2021,1,1),LocalDate.of(2021,1,2),LocalDate.of(2021,1,3))
                ),
                Arguments.of(
                        LocalDate.of(2021,5,1),LocalDate.of(2021,5,3),
                        asList(LocalDate.of(2021,5,1),LocalDate.of(2021,5,2),LocalDate.of(2021,5,3))
                )
        );
    }


}