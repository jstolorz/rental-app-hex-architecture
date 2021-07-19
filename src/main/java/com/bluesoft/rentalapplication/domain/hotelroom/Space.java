package com.bluesoft.rentalapplication.domain.hotelroom;

import javax.persistence.*;

@Entity
@Table(name = "HOTEL_ROOM_SPACE")
class Space {

    @Id
    @GeneratedValue
    private String id;

    private final String name;

    @Embedded
    private final SquareMeter squerMeter;

    Space(final String name, final SquareMeter squerMeter) {

        this.name = name;
        this.squerMeter = squerMeter;
    }
}
