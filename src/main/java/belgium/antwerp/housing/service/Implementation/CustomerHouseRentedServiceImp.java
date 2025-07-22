package belgium.antwerp.housing.service.Implementation;

import belgium.antwerp.housing.domain.AppUser;
import belgium.antwerp.housing.domain.House;
import belgium.antwerp.housing.repository.CustomerHouseRentedRepo;
import belgium.antwerp.housing.service.CustomerHouseRentedService;
import belgium.antwerp.housing.service.OwnerHouseService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
@Transactional
@AllArgsConstructor
public class CustomerHouseRentedServiceImp implements CustomerHouseRentedService {
    private final CustomerHouseRentedRepo customerHouseRentedRepo;
    private final OwnerHouseService ownerHouseService;
    private final Logger logger = Logger.getLogger(CustomerHouseRentedServiceImp.class.getName());
    @Override
    public Optional<House> getHousesRentedByCustomer(final int customerId) {
        logger.info("Getting houses rented by customer with id: " + customerId);
        return customerHouseRentedRepo.getHousesRentedByCustomer(customerId);
    }
    @Override
    public List<AppUser> getCustomerbyHouse(int houseId) {
        logger.info("Getting customers by house with id: " + houseId);
        return customerHouseRentedRepo.getCustomersByHouseRented(houseId);
    }

    @Override
    public Set<AppUser> getCustomersByHouseOwner(int ownerId) {
        logger.info("Getting customers by house with id: " + ownerId);
        List<House> houses = ownerHouseService.getHousesOwnedByOwner(ownerId);
        //Initialize a list to store the customers, use set as it will save unique value, treeset with compare will sort by ID
        Set<AppUser> customers = new TreeSet<>(Comparator.comparingInt(AppUser::getId));
        for(int i = 0; i < houses.size(); i++) {
            for(int j = 0; j < houses.get(i).getCustomerHouseRented().size(); j++) {
                customers.add(houses.get(i).getCustomerHouseRented().get(j).getAppUser());
            }
        }
        return customers;
    }
}
