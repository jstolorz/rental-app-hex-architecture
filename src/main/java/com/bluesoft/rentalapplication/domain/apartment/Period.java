package com.bluesoft.rentalapplication.domain.apartment;

import java.time.LocalDate;

public class Period {
    private final LocalDate start;
    private final LocalDate end;

    public Period(final LocalDate start, final LocalDate end) {

        this.start = start;
        this.end = end;
    }
}
