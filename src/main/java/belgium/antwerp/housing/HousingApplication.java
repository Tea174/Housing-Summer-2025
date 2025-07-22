package belgium.antwerp.housing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"belgium.antwerp.housing.domain"})
public class HousingApplication {

    public static void main(String[] args) {
        SpringApplication.run(HousingApplication.class, args);
    }

}
