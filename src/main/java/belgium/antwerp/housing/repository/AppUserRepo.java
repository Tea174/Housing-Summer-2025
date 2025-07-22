package belgium.antwerp.housing.repository;

import belgium.antwerp.housing.domain.AppUser;
import belgium.antwerp.housing.domain.CustomerHouseRented;
import belgium.antwerp.housing.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AppUserRepo extends JpaRepository<CustomerHouseRented, Integer> {
    @Query("""
SELECT a
FROM AppUser a 
WHERE a.role = :role
""")
    Optional<List<AppUser>> getAppUsers(@Param("role") Role role);
}
