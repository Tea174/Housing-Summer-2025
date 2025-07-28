package belgium.antwerp.housing.service.Implementation;

import belgium.antwerp.housing.domain.CustomerHouseRented;
import belgium.antwerp.housing.domain.House;
import belgium.antwerp.housing.domain.exception.NotFoundException;
import belgium.antwerp.housing.repository.AppUserRepo;
import belgium.antwerp.housing.repository.CustomerHouseRentedRepo;
import belgium.antwerp.housing.repository.HouseRepo;
import belgium.antwerp.housing.repository.OwnerHouseRepo;
import belgium.antwerp.housing.service.CustomerHouseRentedService;
import belgium.antwerp.housing.service.HouseService;
import belgium.antwerp.housing.service.OwnerHouseService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@Transactional
@AllArgsConstructor
public class HouseServiceImp implements HouseService {
    private final HouseRepo houseRepo;
    private final AppUserRepo appUserRepo;
    private final CustomerHouseRentedRepo customerHouseRentedRepo;
    private final OwnerHouseRepo ownerHouseRepo;
    private final CustomerHouseRentedService customerHouseRentedService;
    private final OwnerHouseService ownerHouseService;
    private final Logger logger = Logger.getLogger(HouseServiceImp.class.getName());


    @Override
    public House patchHouse(int id, String address) {
        logger.info("Patching house with id: " + id);
        final House house = houseRepo.findById(id).orElseThrow(() -> NotFoundException.forHouse(id));
        if(address != null){
            house.setAddress(address);
            return houseRepo.save(house);
        }
        return house;
    }

    @Override
    public void removeHouse(int id) {
        logger.info("Removing house with id: " + id);
        final House house = houseRepo.findById(id).orElseThrow(() -> NotFoundException.forHouse(id));
        ownerHouseRepo.deleteAll(house.getOwnerHouses());
        customerHouseRentedRepo.deleteAll(house.getCustomerHouseRented());
        houseRepo.deleteById(id);
    }

    //owners add houses
    @Override
    public House addHouse(String address) {
        logger.info("Adding house with address: " + address);
        final House house = new House();
        house.setAddress(address);
        return houseRepo.save(house);
    }

    //customers sign up for that house
    @Override
    public CustomerHouseRented customerSignUpForHouse(final int customerId, final int houseId) {
        CustomerHouseRented customerHouseRented = new CustomerHouseRented();
        customerHouseRented.setHouse(houseRepo.findById(houseId).orElseThrow(() -> NotFoundException.forHouse(houseId)));
        customerHouseRented.setAppUser(appUserRepo.findById(customerId).orElseThrow(() -> NotFoundException.forAppUser(customerId)));
        return customerHouseRentedRepo.save(customerHouseRented);
    }

}
