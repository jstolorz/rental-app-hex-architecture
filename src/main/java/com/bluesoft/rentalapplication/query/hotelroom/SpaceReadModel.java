package com.bluesoft.rentalapplication.query.hotelroom;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HOTEL_ROOM_SPACE")
public class SpaceReadModel {

    private final String name;
    private final Double value;

    public SpaceReadModel(final String name, final Double value) {
        this.name = name;
        this.value = value;
    }

   public String getName() {
        return name;
    }

   public Double getValue() {
        return value;
    }
}
