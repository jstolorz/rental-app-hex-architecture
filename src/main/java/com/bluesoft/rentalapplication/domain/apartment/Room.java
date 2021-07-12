package com.bluesoft.rentalapplication.domain.apartment;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
class Room {
    private final String name;

    @Embedded
    private final SquerMeter squerMeter;

     Room(final String name, final SquerMeter squerMeter) {

        this.name = name;
        this.squerMeter = squerMeter;
    }
}
