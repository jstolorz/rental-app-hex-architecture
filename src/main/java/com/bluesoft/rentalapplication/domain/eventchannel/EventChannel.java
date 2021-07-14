package com.bluesoft.rentalapplication.domain.eventchannel;

import com.bluesoft.rentalapplication.domain.apartment.ApartmentBooked;

public interface EventChannel {

    void publish(ApartmentBooked apartmentBooked);
}
