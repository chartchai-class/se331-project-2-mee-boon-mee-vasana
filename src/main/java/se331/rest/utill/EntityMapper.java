package se331.rest.utill;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import se331.rest.DTO.CountryDTO;
import se331.rest.DTO.MedalDTO;
import se331.rest.DTO.SportDetailDTO;
import se331.rest.entity.Country;
import se331.rest.entity.Medal;
import se331.rest.entity.SportDetail;

import java.util.List;

@Mapper
public interface EntityMapper {

    EntityMapper INSTANCE = Mappers.getMapper(EntityMapper.class);

    //country DTO
    CountryDTO getCountryDTO(Country country);
    List<CountryDTO> getCountryDTO(List<Country> countries);

    //Medal DTO
    MedalDTO getMedalDTO(Medal medal);
    List<MedalDTO> getMedalDTO(List<Medal> medals);

    //Sport DTO
    SportDetailDTO getSportDetailDTO(SportDetail sportDetail);
    List<SportDetailDTO> getSportDetailDTO(List<SportDetail> sportDetails);

}
