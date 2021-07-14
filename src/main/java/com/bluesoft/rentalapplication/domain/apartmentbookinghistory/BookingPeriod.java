package com.bluesoft.rentalapplication.domain.apartmentbookinghistory;

import java.time.LocalDate;

public class BookingPeriod {
    private final LocalDate periodStart;
    private final LocalDate periodEnd;

    public BookingPeriod(final LocalDate periodStart, final LocalDate periodEnd) {

        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }

}
