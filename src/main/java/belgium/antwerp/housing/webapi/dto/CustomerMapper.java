package belgium.antwerp.housing.webapi.dto;

import belgium.antwerp.housing.domain.AppUser;
import org.mapstruct.Mapper;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface CustomerMapper {
    CustomerDto toCustomer (AppUser appUser);
}
