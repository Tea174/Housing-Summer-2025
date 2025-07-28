package belgium.antwerp.housing.service.Implementation;

import belgium.antwerp.housing.domain.AppUser;
import belgium.antwerp.housing.domain.Role;
import belgium.antwerp.housing.domain.exception.NotFoundException;
import belgium.antwerp.housing.repository.AppUserRepo;
import belgium.antwerp.housing.repository.CustomerHouseRentedRepo;
import belgium.antwerp.housing.repository.OwnerHouseRepo;
import belgium.antwerp.housing.service.AppUserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class AppUserServiceImp implements AppUserService {
    private final AppUserRepo appUserRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final OwnerHouseRepo ownerHouseRepo;
    private final CustomerHouseRentedRepo customerHouseRentedRepo;
    private final Logger logger = Logger.getLogger(AppUserServiceImp.class.getName());

    @Override
    public List<AppUser> getAppUsers() {
        logger.info("Getting all app users");
       return appUserRepo.findAll();

    }

    @Override
    public AppUser addAppUser(final String email,
                              final String name,
                              final String password,
                              final Role role) {
        logger.info("Adding app user with email: " + email);
        final AppUser appUser = new AppUser();
        appUser.setEmail(email);
        appUser.setName(name);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setRole(role);
        logger.info("Saving app user with email: " + email);
        return appUserRepo.save(appUser);
    }

    @Override
    public AppUser patchAppUser(final int id, final String name){
        logger.info("Patching app user with id: " + id);
        final AppUser appUser = appUserRepo.findById(id).orElseThrow(() -> NotFoundException.forAppUser(id));
        if(name != null){
            appUser.setName(name);
        }
        logger.info("Saving app user with id: " + id + " with name: " + name);
        return appUser;
    }

    @Override
    public void removeAppUser(final int id){
        logger.info("Removing app user with id: " + id);
        final AppUser appUser = appUserRepo.findById(id).orElseThrow(() -> NotFoundException.forAppUser(id));
        if(appUser.getRole() == Role.OWNER){
            ownerHouseRepo.deleteAll(appUser.getOwnerHouses());
        } else if (appUser.getRole() == Role.CUSTOMER) {
            customerHouseRentedRepo.deleteAll(appUser.getCustomerHouseRented());
        }
        appUserRepo.delete(appUser);
    }
}
