package com.bluesoft.rentalapplication.domain.apartment;

public class Room {
    private final String name;
    private final SquerMeter squerMeter;

    public Room(final String name, final SquerMeter squerMeter) {

        this.name = name;
        this.squerMeter = squerMeter;
    }
}
