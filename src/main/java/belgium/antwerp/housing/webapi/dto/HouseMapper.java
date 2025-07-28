package belgium.antwerp.housing.webapi.dto;

import belgium.antwerp.housing.domain.House;
import belgium.antwerp.housing.webapi.dto.request.AddHouseDto;
import belgium.antwerp.housing.webapi.dto.response.HouseDto;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface HouseMapper {
    HouseDto toHouseDto(House house);
    House toHouse(HouseDto houseDto);
    AddHouseDto toAddHouseDto(House house);
}
