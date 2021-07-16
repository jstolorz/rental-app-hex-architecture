package com.bluesoft.rentalapplication.domain.apartment;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APARTMENT_ROOM")
class Room {
    private final String name;

    @Embedded
    private final SquerMeter squerMeter;

     Room(final String name, final SquerMeter squerMeter) {

        this.name = name;
        this.squerMeter = squerMeter;
    }
}
