package com.bluesoft.rentalapplication.application.hotelroombookinghistory;

import com.bluesoft.rentalapplication.domain.hotelroom.HotelRoomBooked;
import com.bluesoft.rentalapplication.domain.hotelroombookinghistory.HotelRoomBooking;
import com.bluesoft.rentalapplication.domain.hotelroombookinghistory.HotelRoomBookingHistory;
import com.bluesoft.rentalapplication.domain.hotelroombookinghistory.HotelRoomBookingHistoryRepository;
import org.springframework.context.event.EventListener;

class HotelRoomBookingHistoryEventListener {

    private final HotelRoomBookingHistoryRepository hotelRoomBookingHistoryRepository;

    HotelRoomBookingHistoryEventListener(final HotelRoomBookingHistoryRepository hotelRoomBookingHistoryRepository) {
        this.hotelRoomBookingHistoryRepository = hotelRoomBookingHistoryRepository;
    }

    @EventListener
    public void consume(HotelRoomBooked hotelRoomBooked){

        HotelRoomBookingHistory hotelRoomBookingHistory = getHotelRoomBookingHistory(hotelRoomBooked.getHotelRoomId());
        hotelRoomBookingHistory.add(HotelRoomBooking.start(
                hotelRoomBooked.getEventCreationDateTime(),
                hotelRoomBooked.getTenantId(),
                hotelRoomBooked.getDays()
        ));

        hotelRoomBookingHistoryRepository.save(hotelRoomBookingHistory);

    }

    private HotelRoomBookingHistory getHotelRoomBookingHistory(String hotelRoomId){
        if(hotelRoomBookingHistoryRepository.existFor(hotelRoomId)){
            return hotelRoomBookingHistoryRepository.findFor(hotelRoomId);
        }else{
            return new HotelRoomBookingHistory(hotelRoomId);
        }
    }

}
