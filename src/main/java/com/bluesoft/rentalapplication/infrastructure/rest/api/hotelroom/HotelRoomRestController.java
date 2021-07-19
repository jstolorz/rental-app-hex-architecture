package com.bluesoft.rentalapplication.infrastructure.rest.api.hotelroom;

import com.bluesoft.rentalapplication.application.hotelroom.HotelRoomApplicationService;
import com.bluesoft.rentalapplication.query.hotelroom.HotelRoomReadModel;
import com.bluesoft.rentalapplication.query.hotelroom.QueryHotelRoomRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotelroom")
public class HotelRoomRestController {
    private final HotelRoomApplicationService hotelRoomApplicationService;
    private QueryHotelRoomRepository queryHotelRoomRepository;

    public HotelRoomRestController(HotelRoomApplicationService hotelRoomApplicationService) {
        this.hotelRoomApplicationService = hotelRoomApplicationService;
    }

    @PostMapping
    public void add(@RequestBody HotelRoomDto hotelRoomDto) {
        hotelRoomApplicationService.add(
                hotelRoomDto.getHotelId(), hotelRoomDto.getNumber(), hotelRoomDto.getSpacesDefinition(), hotelRoomDto.getDescription());
    }

    @PutMapping("/book/{id}")
    public void book(@PathVariable String id, @RequestBody HotelRoomBookingDto hotelBookingDto) {
        hotelRoomApplicationService.book(id, hotelBookingDto.getTenantId(), hotelBookingDto.getDays());
    }

    @GetMapping("/{id}")
    public Iterable<HotelRoomReadModel> findAll(@PathVariable String hotelId){
        return queryHotelRoomRepository.findAll(hotelId);
    }
}
