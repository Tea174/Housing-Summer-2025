package belgium.antwerp.housing.service.Implementation;

import belgium.antwerp.housing.domain.AppUser;
import belgium.antwerp.housing.domain.House;
import belgium.antwerp.housing.repository.OwnerHouseRepo;
import belgium.antwerp.housing.service.OwnerHouseService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
@AllArgsConstructor
public class OwnerHouseServiceImp implements OwnerHouseService {
    private final OwnerHouseRepo ownerHouseRepo;
    private final Logger logger = Logger.getLogger(OwnerHouseServiceImp.class.getName());
    @Override
    public List<House> getHousesOwnedByOwner(final int ownerId) {
        logger.info("Getting houses owned by owner with id: " + ownerId);
        return ownerHouseRepo.getHousesOwnedByOwner(ownerId);
    }

}
