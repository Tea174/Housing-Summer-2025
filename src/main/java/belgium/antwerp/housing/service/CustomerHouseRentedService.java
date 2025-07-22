package belgium.antwerp.housing.service;

import belgium.antwerp.housing.domain.AppUser;
import belgium.antwerp.housing.domain.House;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CustomerHouseRentedService {
    Optional<House> getHousesRentedByCustomer(final int customerId);
    List<AppUser> getCustomerbyHouse (final int ownerId);
    Set<AppUser> getCustomersByHouseOwner(int ownerId);
}


