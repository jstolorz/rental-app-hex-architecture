package com.bluesoft.rentalapplication.domain.apartment;

import com.bluesoft.rentalapplication.domain.eventchannel.EventChannel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Booking {

    @Id
    @GeneratedValue
    private String id;

    private final RentalType rentalType;
    private final String rentalPlaceId;
    private final String tenantId;
    private final List<LocalDate> days;
    private BookingStatus bookingStatus = BookingStatus.OPEN;

    public Booking(final RentalType rentalType, final String rentalPlaceId, final String tenantId, final List<LocalDate> days) {

        this.rentalType = rentalType;
        this.rentalPlaceId = rentalPlaceId;
        this.tenantId = tenantId;
        this.days = days;
    }

    static Booking apartment(final String rentalPlaceId, final String tenantId, final Period period) {
        List<LocalDate> days = period.asDays();
        return new Booking(RentalType.APARTMENT, rentalPlaceId, tenantId, days);
    }

    public static Booking hotelRoom(final String rentalPlaceId, final String tenantId, final List<LocalDate> days) {
        return new Booking(RentalType.HOTEL_ROOM, rentalPlaceId, tenantId, days);
    }

    public void reject() {
       bookingStatus = BookingStatus.REJECTED;
    }

    public void accept(final EventChannel eventChannel) {
        bookingStatus = BookingStatus.ACCEPT;

        BookingAccepted bookingAccepted = BookingAccepted.create(rentalType,rentalPlaceId,tenantId,days);
        eventChannel.publish(bookingAccepted);

    }
}
