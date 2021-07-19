package com.bluesoft.rentalapplication.query.hotelroom;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "HOTEL_ROOM")
public class HotelRoomReadModel {

    @Id
    @GeneratedValue
    private String hotelRoomId;
    private final String hotelId;
    private final int number;

    @OneToMany
    private final List<SpaceReadModel> spaces;

    private final String description;

    public HotelRoomReadModel(final String hotelRoomId, final String hotelId, final int number, final List<SpaceReadModel> spaces, final String description) {
        this.hotelRoomId = hotelRoomId;
        this.hotelId = hotelId;
        this.number = number;
        this.spaces = spaces;
        this.description = description;
    }

    public String getHotelRoomId() {
        return hotelRoomId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public int getNumber() {
        return number;
    }

    public List<SpaceReadModel> getSpaces() {
        return spaces;
    }

    public String getDescription() {
        return description;
    }
}
