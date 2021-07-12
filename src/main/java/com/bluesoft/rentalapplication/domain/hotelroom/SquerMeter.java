package com.bluesoft.rentalapplication.domain.hotelroom;

import javax.persistence.Embeddable;

@Embeddable
class SquerMeter {
    private final double value;

    SquerMeter(final double value) {
        this.value = value;
    }
}
