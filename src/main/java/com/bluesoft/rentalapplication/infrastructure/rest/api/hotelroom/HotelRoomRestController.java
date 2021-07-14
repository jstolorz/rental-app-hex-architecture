package com.bluesoft.rentalapplication.infrastructure.rest.api.hotelroom;

import com.bluesoft.rentalapplication.application.hotelroom.HotelRoomApplicationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotelroom")
public class HotelRoomRestController {
    private final HotelRoomApplicationService hotelRoomApplicationService;

    public HotelRoomRestController(final HotelRoomApplicationService hotelRoomApplicationService) {
        this.hotelRoomApplicationService = hotelRoomApplicationService;
    }

    @PostMapping
    public void add(@RequestBody HotelRoomDto hotelRoomDto){
        hotelRoomApplicationService.add(
                hotelRoomDto.getHotelId(),
                hotelRoomDto.getNumber(),
                hotelRoomDto.getDescription(),
                hotelRoomDto.getSpacesDefinition()
        );
    }

    @PutMapping("/book/{id}")
    public void book(@PathVariable String  id, @RequestBody HotelRoomBookingDto hotelRomBookingDto){
        hotelRoomApplicationService.book(
                id,
                hotelRomBookingDto.getTenantId(),
                hotelRomBookingDto.getDays()
                );
    }
}
