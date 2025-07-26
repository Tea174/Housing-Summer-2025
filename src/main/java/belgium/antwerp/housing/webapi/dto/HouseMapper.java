package belgium.antwerp.housing.webapi.dto;

import belgium.antwerp.housing.domain.House;
import belgium.antwerp.housing.webapi.dto.response.HouseDto;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface HouseMapper {
    HouseDto toHouse(House house);
    House toHouseDto(HouseDto houseDto);
}
