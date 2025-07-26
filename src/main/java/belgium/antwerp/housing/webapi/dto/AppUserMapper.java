package belgium.antwerp.housing.webapi.dto;

import belgium.antwerp.housing.domain.AppUser;
import belgium.antwerp.housing.webapi.dto.response.AppUserDto;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface AppUserMapper {
    AppUser toAppUser(AppUserDto appUserDto);
    AppUserDto toAppUserDto(AppUser appUser);
}
