package rc.persistence;

import rc.domain.HotelInterface;

import java.util.List;

public interface HotelRepositoryWrapperInterface {

    List<HotelInterface> findAll();

    void save(List<HotelInterface> hotels);

    HotelInterface save(HotelInterface hotels);

    HotelInterface findOne(long id);
}
