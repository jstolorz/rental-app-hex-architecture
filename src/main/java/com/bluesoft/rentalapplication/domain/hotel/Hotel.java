package com.bluesoft.rentalapplication.domain.hotel;

import javax.persistence.*;

@Entity
@Table(name = "HOTEL")
public class Hotel {

    @Id
    @GeneratedValue
    private String id;

    private final String name;

    @Embedded
    private final Address address;

    Hotel(final String name, final Address address) {
        this.name = name;
        this.address = address;
    }

}
