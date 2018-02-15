package rc.web;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import rc.domain.HotelInterface;
import rc.persistence.HotelRepositoryWrapperInterface;
import rc.web.bean.Hotel;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {
    private HotelRepositoryWrapperInterface hotelRepository;

    public HotelController(HotelRepositoryWrapperInterface hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @GetMapping("/hotels")
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<Hotel> getHotels(){
        List<HotelInterface> hotels = this.hotelRepository.findAll();

        return map(hotels);
    }

    @GetMapping("/hotels/{id}")
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Hotel getHotel(@PathVariable(name = "id") Long id){
        HotelInterface hotel = this.hotelRepository.findOne(id);

        return map(hotel);
    }

    @PostMapping("/hotel")
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Hotel updateHotel(@RequestBody Hotel hotel){

        HotelInterface foundHotel = this.hotelRepository.findOne(hotel.getId());
        foundHotel.setName(hotel.getName());
        foundHotel.setOpen(hotel.isOpen());

        HotelInterface updatedHotel = this.hotelRepository.save(foundHotel);

        if ("Marriotzzzzzzzzzzzz".equals(hotel.getName())) { // testing rollback transaction
            throw new RuntimeException("Transaction should be rollback!!!");
        }
        return map(updatedHotel);
    }

    private Hotel map(HotelInterface updatedHotel) {
        assert updatedHotel!=null;
        return new Hotel(updatedHotel.getId(), updatedHotel.getName(),updatedHotel.getClassification(),updatedHotel.isOpen());
    }

    private List<Hotel> map(List<HotelInterface> hotelInterfaces) {
        List<Hotel> hotels = new ArrayList<Hotel>(hotelInterfaces.size());
        for (HotelInterface hotelInterface : hotelInterfaces) {
            hotels.add(map(hotelInterface));
        }
        return hotels;
    }

}
