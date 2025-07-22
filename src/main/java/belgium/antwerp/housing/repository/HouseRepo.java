package belgium.antwerp.housing.repository;

import belgium.antwerp.housing.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepo extends JpaRepository<House, Integer>{
}
