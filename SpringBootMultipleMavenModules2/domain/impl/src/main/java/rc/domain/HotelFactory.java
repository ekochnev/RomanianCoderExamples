package rc.domain;

import org.springframework.stereotype.Component;

/**
 * Created by ekochne on 2/14/2018.
 */
@Component
public class HotelFactory implements HotelFactoryInterface {
    @Override
    public HotelInterface create(String name, int classification, boolean isOpen) {
        return new Hotel(name, classification, isOpen);
    }
}
