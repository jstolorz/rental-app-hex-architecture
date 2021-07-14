package com.bluesoft.rentalapplication.application.apartmentbookinghistory;

import com.bluesoft.rentalapplication.domain.apartment.ApartmentBooked;
import com.bluesoft.rentalapplication.domain.apartmentbookinghistory.ApartmentBooking;
import com.bluesoft.rentalapplication.domain.apartmentbookinghistory.ApartmentBookingHistory;
import com.bluesoft.rentalapplication.domain.apartmentbookinghistory.ApartmentBookingHistoryRepository;
import com.bluesoft.rentalapplication.domain.apartmentbookinghistory.BookingPeriod;
import org.springframework.context.event.EventListener;

class ApartmentBookingHistoryEventListener {

    private final ApartmentBookingHistoryRepository apartmentBookingHistoryRepository;

    ApartmentBookingHistoryEventListener(final ApartmentBookingHistoryRepository apartmentBookingHistoryRepository) {
        this.apartmentBookingHistoryRepository = apartmentBookingHistoryRepository;
    }

    @EventListener
    public void consume(ApartmentBooked apartmentBooked){

        ApartmentBookingHistory apartmentBookingHistory = getApartmentBookingHistoryFor(apartmentBooked.getApartmentId());
        BookingPeriod bookingPeriod = new BookingPeriod(
                apartmentBooked.getPeriodStart(),
                apartmentBooked.getPeriodEnd()
        );

         apartmentBookingHistory.add(ApartmentBooking.start(
             apartmentBooked.getEventCreationDateTime(),
             apartmentBooked.getOwnerId(),
             apartmentBooked.getTenantId(),
             bookingPeriod
         ));

        apartmentBookingHistoryRepository.save(apartmentBookingHistory);

    }

    private ApartmentBookingHistory getApartmentBookingHistoryFor(final String apartmentId) {
        if(apartmentBookingHistoryRepository.exists(apartmentId)){
            return apartmentBookingHistoryRepository.findFor(apartmentId);
        }else{
            return new ApartmentBookingHistory(apartmentId);
        }
    }
}
