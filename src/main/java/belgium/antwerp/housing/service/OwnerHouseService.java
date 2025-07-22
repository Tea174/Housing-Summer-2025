package belgium.antwerp.housing.service;

import belgium.antwerp.housing.domain.House;

import java.util.List;

public interface OwnerHouseService {
    List<House> getHousesOwnedByOwner(final int ownerId);

}