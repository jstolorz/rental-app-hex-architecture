package com.bluesoft.rentalapplication.domain.hotelroom;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HotelRoomFactory {
    public HotelRoom create(final String hotelId, final int number, final String description, final Map<String, Double> spacesDefinition) {

        List<Space> spaces = spacesDefinition.entrySet()
                .stream()
                .map(keyValue -> {
                    SquerMeter squerMeter = new SquerMeter(keyValue.getValue());
                    return new Space(keyValue.getKey(), squerMeter);
                })
                .collect(Collectors.toList());

        return new HotelRoom(hotelId,number,description,spaces);
    }
}
