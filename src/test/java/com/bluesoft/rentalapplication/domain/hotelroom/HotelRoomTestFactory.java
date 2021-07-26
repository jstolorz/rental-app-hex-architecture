package com.bluesoft.rentalapplication.domain.hotelroom;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class HotelRoomTestFactory {

    public static HotelRoom create(String hotelId, int number, String description){
        final List<Space> spaces = ImmutableList.of(
                new Space("bad",new SquareMeter(23)),
                new Space("kitchen",new SquareMeter(34))
        );
        return new HotelRoom(hotelId, number, spaces, description);
    }

}