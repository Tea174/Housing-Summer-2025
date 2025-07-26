package belgium.antwerp.housing.webapi;

import belgium.antwerp.housing.domain.AppUser;
import belgium.antwerp.housing.service.AppUserService;

import belgium.antwerp.housing.service.CustomerHouseRentedService;
import belgium.antwerp.housing.webapi.dto.AppUserMapper;
import belgium.antwerp.housing.webapi.dto.request.PatchAppUser;
import belgium.antwerp.housing.webapi.dto.response.AppUserDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController()
@RequestMapping("/api/appUser")
public class AppUserApiController {
    private final AppUserService appUserService;
    private final AppUserMapper appUserMapper;
    private final CustomerHouseRentedService customerHouseRentedService;

    @GetMapping("/owner/{id}")
    public ResponseEntity<List<AppUserDto>> getCustomersByHouseOwner(@PathVariable final int id){
    final List<AppUserDto> customers = customerHouseRentedService.getCustomersByHouseOwner(id)
            .stream()
            .map(appUserMapper ::toAppUserDto)
            .toList();
    return ResponseEntity.ok(customers);
    }

    @GetMapping("/allAppUsers")
    public ResponseEntity<List<AppUserDto>> getAllAppUsers(){
        final List<AppUserDto> appusers = appUserService.getAppUsers()
                .stream()
                .map(appUserMapper:: toAppUserDto)
                .toList();
        return ResponseEntity.ok(appusers);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAppUser(@PathVariable("id") final int id){
        appUserService.removeAppUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AppUserDto> patch(@PathVariable("id") final int id,
                                            @RequestBody @Valid final PatchAppUser patchAppUser){
        final AppUser appUser =
                appUserService.patchAppUser(id, patchAppUser.name());
        return ResponseEntity.status(HttpStatus.OK)
                .body(appUserMapper.toAppUserDto(appUser));
    }




}
