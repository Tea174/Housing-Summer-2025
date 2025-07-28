package belgium.antwerp.housing.service;

import belgium.antwerp.housing.domain.CustomerHouseRented;
import belgium.antwerp.housing.domain.House;

import java.util.Optional;

public interface HouseService {
    House patchHouse(int id, String address);
    void removeHouse(int id);
    House addHouse(String address);
    CustomerHouseRented customerSignUpForHouse(int customerId, int houseId);
}
