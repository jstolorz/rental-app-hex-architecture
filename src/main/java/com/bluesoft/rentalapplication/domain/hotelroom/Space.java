package com.bluesoft.rentalapplication.domain.hotelroom;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Space {

    @Id
    @GeneratedValue
    private String id;

    private final String name;

    @Embedded
    private final SquerMeter squerMeter;

    Space(final String name, final SquerMeter squerMeter) {

        this.name = name;
        this.squerMeter = squerMeter;
    }
}
