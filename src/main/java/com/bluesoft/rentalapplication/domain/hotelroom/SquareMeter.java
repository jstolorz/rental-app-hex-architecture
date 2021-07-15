package com.bluesoft.rentalapplication.domain.hotelroom;

import javax.persistence.Embeddable;

@Embeddable
class SquareMeter {
    private final double value;

    SquareMeter(final double value) {
        this.value = value;
    }
}
