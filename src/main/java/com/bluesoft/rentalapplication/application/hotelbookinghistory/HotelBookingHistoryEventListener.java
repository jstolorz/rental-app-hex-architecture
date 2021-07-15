package com.bluesoft.rentalapplication.application.hotelbookinghistory;

import com.bluesoft.rentalapplication.domain.hotelbookinghistory.HotelBookingHistory;
import com.bluesoft.rentalapplication.domain.hotelbookinghistory.HotelBookingHistoryRepository;
import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomBooked;
import org.springframework.context.event.EventListener;

class HotelBookingHistoryEventListener {

    private final HotelBookingHistoryRepository hotelBookingHistoryRepository;

    HotelBookingHistoryEventListener(final HotelBookingHistoryRepository hotelBookingHistoryRepository) {
        this.hotelBookingHistoryRepository = hotelBookingHistoryRepository;
    }


    @EventListener
    public void consume(HotelRoomBooked hotelRoomBooked){
        HotelBookingHistory hotelBookingHistory = getHotelBookingHistory(hotelRoomBooked.getHotelId());
        hotelBookingHistory.add(
                hotelRoomBooked.getHotelRoomId(),
                hotelRoomBooked.getEventCreationDateTime(),
                hotelRoomBooked.getTenantId(),
                hotelRoomBooked.getDays()
        );

        hotelBookingHistoryRepository.save(hotelBookingHistory);
    }

    private HotelBookingHistory getHotelBookingHistory(String hotelId){
        if(hotelBookingHistoryRepository.existFor(hotelId)){
            return hotelBookingHistoryRepository.findFor(hotelId);
        }else{
            return new HotelBookingHistory(hotelId);
        }
    }
}
