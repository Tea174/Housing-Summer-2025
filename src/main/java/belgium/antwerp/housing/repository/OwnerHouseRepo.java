package belgium.antwerp.housing.repository;

import belgium.antwerp.housing.domain.House;
import belgium.antwerp.housing.domain.OwnerHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OwnerHouseRepo extends JpaRepository<OwnerHouse, Integer> {
    @Query("""
    FROM House h
    LEFT JOIN FETCH h.ownerHouses oh 
    LEFT JOIN FETCH oh.appUser ap
    WHERE ap.id = :id                    
            """)
    List<House> getHousesOwnedByOwner(@Param("id") int id);
}
