package belgium.antwerp.housing.webapi;

import belgium.antwerp.housing.domain.CustomerHouseRented;
import belgium.antwerp.housing.domain.House;
import belgium.antwerp.housing.service.AppUserService;
import belgium.antwerp.housing.service.CustomerHouseRentedService;
import belgium.antwerp.housing.service.HouseService;
import belgium.antwerp.housing.service.OwnerHouseService;
import belgium.antwerp.housing.webapi.dto.AppUserMapper;
import belgium.antwerp.housing.webapi.dto.CustomerHouseRentedMapper;
import belgium.antwerp.housing.webapi.dto.request.AddHouseDto;
import belgium.antwerp.housing.webapi.dto.request.CustomerSignUpHouseDto;
import belgium.antwerp.housing.webapi.dto.response.AppUserDto;
import belgium.antwerp.housing.webapi.dto.response.HouseDto;
import belgium.antwerp.housing.webapi.dto.HouseMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController()
@RequestMapping("/api/houses")
public class HousesApiController {
    private final HouseMapper houseMapper;
    private final CustomerHouseRentedMapper customerHouseRentedMapper;
    private final OwnerHouseService ownerHouseService;
    private final CustomerHouseRentedService customerHouseRentedService;
    private final AppUserService appUserService;
    private final AppUserMapper appUserMapper;
    private final HouseService houseService;


    //done
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeHouse(@PathVariable("id") final int id){
        houseService.removeHouse(id);
        return ResponseEntity.noContent().build();
    }

    //done
    @GetMapping("{id}/houses")
    public ResponseEntity<List<AppUserDto>> getCustomersByHouseId(@PathVariable("id") final int id){
        final List<AppUserDto> customers = customerHouseRentedService.getCustomerbyHouse(id)
                .stream()
                .map(appUserMapper ::toAppUserDto)
                .toList();
        return ResponseEntity.ok(customers);
    }

    //done
    @PatchMapping("{id}")
    public ResponseEntity<HouseDto> patch( @PathVariable("id") final int id,
                                           @RequestBody @Valid final HouseDto houseDto){

        final House house = houseService.patchHouse(id, houseDto.address());
        return ResponseEntity.status(HttpStatus.OK)
                .body(houseMapper.toHouseDto(house));
    }

    //done
    @PostMapping
    public ResponseEntity<AddHouseDto> add(
           @RequestBody @Valid final AddHouseDto addHouseDto
    ) {
        final House house = houseService.addHouse(addHouseDto.address());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(houseMapper.toAddHouseDto(house));
    }

    @PostMapping("/rentals")
    public ResponseEntity<CustomerSignUpHouseDto> customerSignUpHouse(
            @RequestBody @Valid final CustomerSignUpHouseDto customerSignUpHouseDto
    ) {
        final CustomerHouseRented customerHouseRented = houseService.customerSignUpForHouse(customerSignUpHouseDto.customerId(), customerSignUpHouseDto.houseId());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerHouseRentedMapper.toCustomerSignUpHouseDto(customerHouseRented));
    }

}
