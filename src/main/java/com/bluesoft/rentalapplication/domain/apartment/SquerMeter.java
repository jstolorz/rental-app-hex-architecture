package com.bluesoft.rentalapplication.domain.apartment;

import javax.persistence.Embeddable;

@Embeddable
class SquerMeter {
    private Double size;

     SquerMeter(final Double size) {
        this.size = size;
    }
}
