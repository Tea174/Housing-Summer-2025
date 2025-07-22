package belgium.antwerp.housing.service.Implementation;

import belgium.antwerp.housing.domain.AppUser;
import belgium.antwerp.housing.domain.Role;
import belgium.antwerp.housing.repository.AppUserRepo;
import belgium.antwerp.housing.service.AppUserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
@AllArgsConstructor
public class AppUserServiceImp implements AppUserService {
    private final AppUserRepo appUserRepo;
    private final Logger logger = Logger.getLogger(AppUserServiceImp.class.getName());

    @Override
    public Optional<List<AppUser>> getCustomers(final String role) {
        logger.info("Getting customers with role: " + role);
        Role roleEnum = Role.valueOf(role.toUpperCase());
        Optional<List<AppUser>> customers = appUserRepo.getAppUsers(roleEnum);
        // if the customer does not exist, call 2nd function
        customers.ifPresentOrElse(
                customerList -> customerList.forEach(customer -> System.out.println(customer.getName())),
                () -> System.out.println("No customers found")
        );
        return customers;
    }

    @Override
    public Optional<List<AppUser>> getOwners(final String role) {
        logger.info("Getting owners with role: " + role);
        Role roleEnum = Role.valueOf(role.toUpperCase());
        Optional<List<AppUser>> owners = appUserRepo.getAppUsers(roleEnum);
        owners.ifPresentOrElse(
                ownerList -> ownerList.forEach(owner ->  System.out.println(owner.getName())),
                () -> System.out.println("No owners found")
        );
        return owners;
    }
}
