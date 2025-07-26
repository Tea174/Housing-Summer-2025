package belgium.antwerp.housing.repository;

import belgium.antwerp.housing.domain.AppUser;
import belgium.antwerp.housing.domain.CustomerHouseRented;
import belgium.antwerp.housing.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerHouseRentedRepo extends JpaRepository<CustomerHouseRented, Integer> {
    @Query("""
    FROM AppUser a
    LEFT JOIN FETCH  a.customerHouseRented ch
    LEFT JOIN FETCH  ch.house
    WHERE a.id = :id
""")
    Optional<House> getHousesRentedByCustomer(@Param("id") int id);
    @Query("""
SELECT a FROM AppUser a
LEFT JOIN FETCH a.customerHouseRented ch
LEFT JOIN FETCH ch.house h
WHERE h.id = :id
""")
    List<AppUser> getCustomersByHouseRented(@Param("id") int id);

}
