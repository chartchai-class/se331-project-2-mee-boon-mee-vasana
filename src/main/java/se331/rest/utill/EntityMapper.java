package se331.rest.utill;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import se331.rest.DTO.CountryDTO;
import se331.rest.entity.Country;

import java.util.List;

@Mapper
public interface EntityMapper {
    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);
    CountryDTO getCountryDTO(Country country);
    List<CountryDTO> getCountryDTO(List<Country> countries);
}
