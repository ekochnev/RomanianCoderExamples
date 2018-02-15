package rc.persistence;

import org.springframework.stereotype.Component;
import rc.domain.Hotel;
import rc.domain.HotelInterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class HotelRepositoryWrapper implements HotelRepositoryWrapperInterface {

    HotelRepository hotelRepository;

    public HotelRepositoryWrapper(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<HotelInterface> findAll() {
        List<Hotel> hotels = hotelRepository.findAll();
        List<HotelInterface> hotelInterfaces = new ArrayList<>(hotels.size());
        hotelInterfaces.addAll(hotels);
        return hotelInterfaces;
}

    @Override
    public void save(List<HotelInterface> hotelInterfaces) {
//        List<Hotel> hotels = new ArrayList<>(hotelInterfaces.size());
//        hotels.addAll((Collection<? extends Hotel>) hotelInterfaces);
        hotelRepository.save((List<Hotel>) (List<?>) hotelInterfaces); // TODO ... not very good solution, drawbacks are possible
    }

    @Override
    public HotelInterface save(HotelInterface hotel) {
        return hotelRepository.save((Hotel) hotel);
    }

    @Override
    public HotelInterface findOne(long id) {

        HotelInterface hotelInterface = hotelRepository.findOne(id);

        return hotelInterface;
    }
}
