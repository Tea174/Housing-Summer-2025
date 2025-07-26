package belgium.antwerp.housing.security;

import belgium.antwerp.housing.repository.AppUserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger LOGGER = Logger.getLogger(UserDetailsServiceImpl.class.getName());
    private final AppUserRepo appUserRepo;
    public UserDetailsServiceImpl(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        return appUserRepo.findByEmail(email)
                .map(appUser -> {
                    LOGGER.info("Found user: " + appUser);
                    return new CustomAppUserDetails(
                            appUser.getId(),
                            appUser.getEmail(),
                            appUser.getPassword(),
                            appUser.getRole());
                })
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }
}
