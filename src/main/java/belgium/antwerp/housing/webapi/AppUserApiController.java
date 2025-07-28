package belgium.antwerp.housing.webapi;

import belgium.antwerp.housing.domain.AppUser;
import belgium.antwerp.housing.domain.Role;
import belgium.antwerp.housing.service.AppUserService;

import belgium.antwerp.housing.service.CustomerHouseRentedService;
import belgium.antwerp.housing.service.OwnerHouseService;
import belgium.antwerp.housing.webapi.dto.AppUserMapper;
import belgium.antwerp.housing.webapi.dto.HouseMapper;
import belgium.antwerp.housing.webapi.dto.request.AddAppUserDto;
import belgium.antwerp.housing.webapi.dto.request.PatchAppUserDto;
import belgium.antwerp.housing.webapi.dto.response.AppUserDto;
import belgium.antwerp.housing.webapi.dto.response.HouseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController()
@RequestMapping("/api/appUsers")
public class AppUserApiController {
    private final AppUserService appUserService;
    private final AppUserMapper appUserMapper;
    private final HouseMapper houseMapper;
    private final CustomerHouseRentedService customerHouseRentedService;
    private final OwnerHouseService ownerHouseService;

    //done
    @GetMapping("/{ownerId}/housesOwned")
    public ResponseEntity<List<HouseDto> > getHousesByOwnerId(@PathVariable("ownerId") final int ownerId){
        final List<HouseDto> houses = ownerHouseService.getHousesOwnedByOwner(ownerId)
                .stream()
                .map(houseMapper::toHouseDto)
                .toList();
        return ResponseEntity.ok(houses);
    }

    //done
    @GetMapping("/{customerId}/housesRented")
    public ResponseEntity<List<HouseDto>> getHouseByCustomerId(@PathVariable("customerId") final int customerId){
        final List<HouseDto> houses = customerHouseRentedService.getHousesRentedByCustomer(customerId)
                .stream()
                .map(houseMapper::toHouseDto)
                .toList();
        return ResponseEntity.ok(houses);
    }

    //done
    @GetMapping("/{id}/customers")
    public ResponseEntity<List<AppUserDto>> getCustomersByHouseOwner(@PathVariable("id") final int id){
    final List<AppUserDto> customers = customerHouseRentedService.getCustomersByHouseOwner(id)
            .stream()
            .map(appUserMapper ::toAppUserDto)
            .toList();
    return ResponseEntity.ok(customers);
    }

    // done
    @GetMapping()
    public ResponseEntity<List<AppUserDto>> getAllAppUsers(){
        final List<AppUserDto> appUsers = appUserService.getAppUsers()
                .stream()
                .map(appUserMapper:: toAppUserDto)
                .toList();
        return ResponseEntity.ok(appUsers);
    }

    // done
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAppUser(@PathVariable("id") final int id){
        appUserService.removeAppUser(id);
        return ResponseEntity.noContent().build();
    }

    //done
    @PatchMapping("/{id}")
    public ResponseEntity<AppUserDto> patch(@PathVariable("id") final int id,
                                            @RequestBody @Valid final PatchAppUserDto patchAppUserDto){
        final AppUser appUser =
                appUserService.patchAppUser(id, patchAppUserDto.name());
        return ResponseEntity.status(HttpStatus.OK)
                .body(appUserMapper.toAppUserDto(appUser));
    }

//done
    @PostMapping
    public ResponseEntity<AppUserDto> addAppUser(@RequestBody @Valid final AddAppUserDto addAppUserDto){
        final AppUser appUser = appUserService.addAppUser(addAppUserDto.email(),
                addAppUserDto.name(),
                addAppUserDto.password(),
                Role.valueOf(addAppUserDto.role()));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(appUserMapper.toAppUserDto(appUser));
    }

}
