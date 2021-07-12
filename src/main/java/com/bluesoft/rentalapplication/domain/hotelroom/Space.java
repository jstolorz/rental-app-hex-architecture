package com.bluesoft.rentalapplication.domain.hotelroom;

class Space {
    private final String key;
    private final SquerMeter squerMeter;

    Space(final String key, final SquerMeter squerMeter) {

        this.key = key;
        this.squerMeter = squerMeter;
    }
}
