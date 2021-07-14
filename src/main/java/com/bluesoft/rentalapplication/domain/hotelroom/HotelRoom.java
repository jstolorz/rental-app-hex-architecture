package com.bluesoft.rentalapplication.domain.hotelroom;

import com.bluesoft.rentalapplication.domain.eventchannel.EventChannel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
public class HotelRoom {

    @Id
    @GeneratedValue
    private String hotelRoomId;

    private final String hotelId;
    private final int number;
    private final String description;

    @OneToMany
    private final List<Space> spaces;

    HotelRoom(final String hotelId, final int number, final String description, final List<Space> spaces) {

        this.hotelId = hotelId;
        this.number = number;
        this.description = description;
        this.spaces = spaces;
    }

    public void book(final String tenantId, final List<LocalDate> days, final EventChannel eventChannel) {
        HotelRoomBooked hotelRoomBooked = HotelRoomBooked.create(hotelId,tenantId,days);
        eventChannel.publish(hotelRoomBooked);
    }
}
