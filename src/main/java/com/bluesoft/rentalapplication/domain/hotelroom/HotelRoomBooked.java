package com.bluesoft.rentalapplication.domain.hotelroom;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class HotelRoomBooked {


    private final String eventId;
    private final LocalDateTime eventCreationDateTime;
    private final String hotelId;
    private final String tenantId;
    private final List<LocalDate> days;

    HotelRoomBooked(final String eventId, final LocalDateTime eventCreationDateTime, final String hotelId, final String tenantId, final List<LocalDate> days) {

        this.eventId = eventId;
        this.eventCreationDateTime = eventCreationDateTime;
        this.hotelId = hotelId;
        this.tenantId = tenantId;
        this.days = days;
    }

    static HotelRoomBooked create(final String hotelId, final String tenantId, final List<LocalDate> days) {
        final String eventId = UUID.randomUUID().toString();
        final LocalDateTime eventCreationDateTime = LocalDateTime.now();

        return new HotelRoomBooked(eventId,eventCreationDateTime, hotelId,tenantId,days);
    }

   public String getEventId() {
        return eventId;
    }

  public LocalDateTime getEventCreationDateTime() {
        return eventCreationDateTime;
    }

   public String getHotelId() {
        return hotelId;
    }

   public String getTenantId() {
        return tenantId;
    }

   public List<LocalDate> getDays() {
        return days;
    }
}
