package com.bluesoft.rentalapplication.domain.hotelroombookinghistory;

public interface HotelRoomBookingHistoryRepository {
    void save(HotelRoomBookingHistory hotelRoomBookingHistory);

    boolean existFor(String hotelRoomId);

    HotelRoomBookingHistory findFor(String hotelRoomId);
}
