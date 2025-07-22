package belgium.antwerp.housing.webapi;

import belgium.antwerp.housing.service.OwnerHouseService;
import belgium.antwerp.housing.webapi.dto.HouseDto;
import belgium.antwerp.housing.webapi.dto.HouseMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController()
@RequestMapping("/api/houses")
public class HousesApiController {
    private final HouseMapper houseMapper;
    private final OwnerHouseService ownerHouseService;
    @GetMapping("/byOwner/{ownerId}")
    public ResponseEntity<List<HouseDto> > getHousesByOwner(@PathVariable final int ownerId){
        final List<HouseDto> houses = ownerHouseService.getHousesOwnedByOwner(ownerId)
                .stream()
                .map(houseMapper::toHouse)
                .toList();
        return ResponseEntity.ok(houses);
    }
}
