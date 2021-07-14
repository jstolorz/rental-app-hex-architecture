package com.bluesoft.rentalapplication.domain.apartmentbookinghistory;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class BookingPeriod {
    private final LocalDate periodStart;
    private final LocalDate periodEnd;

    public BookingPeriod(final LocalDate periodStart, final LocalDate periodEnd) {

        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
    }

}
