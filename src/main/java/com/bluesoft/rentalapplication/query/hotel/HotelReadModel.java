package com.bluesoft.rentalapplication.query.hotel;


import javax.persistence.*;

@Entity
@Table(name = "HOTEL")
public class HotelReadModel {
    @Id
    @GeneratedValue
    private String id;

    private final String name;
    private final String street;
    private final String buildingNumber;
    private final String postalCode;
    private final String city;
    private final String country;

    public HotelReadModel(final String id, final String name, final String street, final String buildingNumber, final String postalCode, final String city, final String country) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
