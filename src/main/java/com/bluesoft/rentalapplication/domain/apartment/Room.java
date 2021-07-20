package com.bluesoft.rentalapplication.domain.apartment;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APARTMENT_ROOM")
class Room {
    private final String name;

    @Embedded
    private final SquareMeter squerMeter;

     Room(final String name, final SquareMeter squerMeter) {

        this.name = name;
        this.squerMeter = squerMeter;
    }
}
