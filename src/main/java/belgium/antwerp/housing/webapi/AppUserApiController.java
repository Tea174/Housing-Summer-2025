package belgium.antwerp.housing.webapi;

import belgium.antwerp.housing.service.AppUserService;

import belgium.antwerp.housing.service.CustomerHouseRentedService;
import belgium.antwerp.housing.webapi.dto.CustomerDto;
import belgium.antwerp.housing.webapi.dto.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController()
@RequestMapping("/api")
public class AppUserApiController {
    private final AppUserService appUserService;
    private final CustomerMapper customerMapper;
    private final CustomerHouseRentedService customerHouseRentedService;

    @GetMapping("/owner/{id}")
    public ResponseEntity<List<CustomerDto>> getCustomersByHouseOwner(@PathVariable final int id){
    final List<CustomerDto> customers = customerHouseRentedService.getCustomersByHouseOwner(id)
            .stream()
            .map(customerMapper ::toCustomer)
            .toList();
    return ResponseEntity.ok(customers);
    }




}
