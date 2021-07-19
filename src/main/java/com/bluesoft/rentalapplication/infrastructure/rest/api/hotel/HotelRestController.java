package com.bluesoft.rentalapplication.infrastructure.rest.api.hotel;

import com.bluesoft.rentalapplication.application.hotel.HotelApplicationService;
import com.bluesoft.rentalapplication.query.hotel.HotelReadModel;
import com.bluesoft.rentalapplication.query.hotel.QueryHotelRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelRestController {

    private final HotelApplicationService hotelApplicationService;
    private final QueryHotelRepository queryHotelRepository;

    public HotelRestController(final HotelApplicationService hotelApplicationService, final QueryHotelRepository queryHotelRepository) {
        this.hotelApplicationService = hotelApplicationService;
        this.queryHotelRepository = queryHotelRepository;
    }

    @PostMapping
    public void add(@RequestBody HotelDto hotelDto){
        hotelApplicationService.add(
                hotelDto.getName(),
                hotelDto.getStreet(),
                hotelDto.getBuildingNumber(),
                hotelDto.getPostalCode(),
                hotelDto.getCity(),
                hotelDto.getCountry()
        );
    }

    @GetMapping
    public Iterable<HotelReadModel> findAll(){
        return queryHotelRepository.findAll();
    }
}
