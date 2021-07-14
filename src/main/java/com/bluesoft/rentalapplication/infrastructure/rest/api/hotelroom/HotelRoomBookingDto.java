package com.bluesoft.rentalapplication.infrastructure.rest.api.hotelroom;

import java.time.LocalDate;
import java.util.List;

class HotelRoomBookingDto {

    private final String tenantId;
    private final List<LocalDate> days;


    HotelRoomBookingDto(final String tenantId, final List<LocalDate> days) {
        this.tenantId = tenantId;
        this.days = days;
    }

   public String getTenantId() {
        return tenantId;
    }

    public List<LocalDate> getDays() {
        return days;
    }
}
