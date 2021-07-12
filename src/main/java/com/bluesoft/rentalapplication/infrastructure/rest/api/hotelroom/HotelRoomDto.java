package com.bluesoft.rentalapplication.infrastructure.rest.api.hotelroom;

import java.util.Map;

class HotelRoomDto {
   private final String hotelId;
   private final int number;
   private final String description;
   private final Map<String, Double> spacesDefinition;

    HotelRoomDto(final String hotelId, final int number, final String description, final Map<String, Double> spacesDefinition) {
        this.hotelId = hotelId;
        this.number = number;
        this.description = description;
        this.spacesDefinition = spacesDefinition;
    }

    String getHotelId() {
        return hotelId;
    }

    int getNumber() {
        return number;
    }

    String getDescription() {
        return description;
    }

    Map<String, Double> getSpacesDefinition() {
        return spacesDefinition;
    }
}
