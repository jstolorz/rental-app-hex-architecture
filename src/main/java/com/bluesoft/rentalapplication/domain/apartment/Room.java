package com.bluesoft.rentalapplication.domain.apartment;

class Room {
    private final String name;
    private final SquerMeter squerMeter;

     Room(final String name, final SquerMeter squerMeter) {

        this.name = name;
        this.squerMeter = squerMeter;
    }
}
