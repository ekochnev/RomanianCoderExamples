package rc.domain;

/**
 * Created by ekochne on 2/14/2018.
 */
public interface HotelFactoryInterface {

    public HotelInterface create(String name, int classification, boolean isOpen);
}
