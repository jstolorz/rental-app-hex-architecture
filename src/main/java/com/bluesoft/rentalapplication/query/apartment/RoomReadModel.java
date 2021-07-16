package com.bluesoft.rentalapplication.query.apartment;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "APARTMENT_ROOM")
public class RoomReadModel {

    private final String name;
    private final Double size;


    RoomReadModel(final String name, final Double size) {
        this.name = name;
        this.size = size;
    }

   public String getName() {
        return name;
    }

   public Double getSize() {
        return size;
    }
}
