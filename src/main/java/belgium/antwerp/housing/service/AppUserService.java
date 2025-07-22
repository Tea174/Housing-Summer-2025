package belgium.antwerp.housing.service;

import belgium.antwerp.housing.domain.AppUser;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    Optional<List<AppUser>> getCustomers(final String role);
    Optional<List<AppUser>> getOwners(final String role);
}
