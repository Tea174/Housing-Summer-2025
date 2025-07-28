package belgium.antwerp.housing.webapi.dto;

import belgium.antwerp.housing.domain.CustomerHouseRented;
import belgium.antwerp.housing.webapi.dto.request.CustomerSignUpHouseDto;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CustomerHouseRentedMapper {
    CustomerSignUpHouseDto toCustomerSignUpHouseDto(CustomerHouseRented customerHouseRented);
}
