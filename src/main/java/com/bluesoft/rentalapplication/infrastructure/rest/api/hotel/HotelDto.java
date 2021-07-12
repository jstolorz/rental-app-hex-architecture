package com.bluesoft.rentalapplication.infrastructure.rest.api.hotel;
class HotelDto {
   private final String name;
   private final String street;
   private final String buildingNumber;
   private final String postalCode;
 ;  private final String city;
 ;  private final String country;

    HotelDto(final String name, final String street, final String buildingN, final String buildingNumber, final String postalCode, final String city, final String country) {
        this.name = name;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    String getName() {
        return name;
    }

    String getStreet() {
        return street;
    }

    String getBuildingNumber() {
        return buildingNumber;
    }

    String getPostalCode() {
        return postalCode;
    }

    String getCity() {
        return city;
    }

    String getCountry() {
        return country;
    }
}
