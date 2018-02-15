package rc.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import rc.domain.HotelFactoryInterface;
import rc.domain.HotelInterface;

import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner, DbSeederInterface {
    private HotelRepositoryWrapperInterface hotelRepository;
    private HotelFactoryInterface factoryInterface;

    public DbSeeder(HotelRepositoryWrapperInterface hotelRepository, HotelFactoryInterface factoryInterface){
        this.hotelRepository = hotelRepository;
        this.factoryInterface = factoryInterface;
    }

    @Override
    public void run(String... strings) throws Exception {
        HotelInterface marriot = factoryInterface.create("Marriot", 5, true);
        HotelInterface ibis = factoryInterface.create("Ibis", 3, false);
        HotelInterface goldenTulip = factoryInterface.create("Golden Tulip", 4, true);

        List<HotelInterface> hotels = new ArrayList<>();
        hotels.add(marriot);
        hotels.add(ibis);
        hotels.add(goldenTulip);

        this.hotelRepository.save(hotels);
    }
}
