package com.bluesoft.rentalapplication.domain.apartment;

import com.bluesoft.rentalapplication.domain.eventchannel.EventChannel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "APARTMENT")
public class Apartment {

    @Id
    @GeneratedValue
    private String id;

    private final String ownerId;

    @Embedded
    private final Address address;

    private final String description;

    @OneToMany
    private final List<Room> rooms;

    Apartment(final String ownerId, final Address address, final String description, final List<Room> rooms) {
        this.ownerId = ownerId;
        this.address = address;
        this.description = description;
        this.rooms = rooms;
    }

    public Booking book(final String tenantId, final Period period, final EventChannel eventChannel) {
         // publish an eventcreate
        ApartmentBooked apartmentBooked = ApartmentBooked.create(id, ownerId, tenantId, period); // << Object of Event
        eventChannel.publish(apartmentBooked);

        return Booking.apartment(id,tenantId,period);
    }
}
