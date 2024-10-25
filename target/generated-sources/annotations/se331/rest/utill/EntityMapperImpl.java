package se331.rest.utill;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import se331.rest.DTO.CountryDTO;
import se331.rest.DTO.MedalDTO;
import se331.rest.entity.Country;
import se331.rest.entity.Medal;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-25T12:18:05+0700",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.3 (Eclipse Adoptium)"
)
public class EntityMapperImpl implements EntityMapper {

    @Override
    public CountryDTO getCountryDTO(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDTO.CountryDTOBuilder countryDTO = CountryDTO.builder();

        countryDTO.id( country.getId() );
        countryDTO.name( country.getName() );
        countryDTO.nocCode( country.getNocCode() );
        countryDTO.flagUrl( country.getFlagUrl() );
        countryDTO.description( country.getDescription() );
        countryDTO.medals( medalListToMedalDTOList( country.getMedals() ) );

        return countryDTO.build();
    }

    @Override
    public List<CountryDTO> getCountryDTO(List<Country> countries) {
        if ( countries == null ) {
            return null;
        }

        List<CountryDTO> list = new ArrayList<CountryDTO>( countries.size() );
        for ( Country country : countries ) {
            list.add( getCountryDTO( country ) );
        }

        return list;
    }

    protected MedalDTO medalToMedalDTO(Medal medal) {
        if ( medal == null ) {
            return null;
        }

        MedalDTO.MedalDTOBuilder medalDTO = MedalDTO.builder();

        return medalDTO.build();
    }

    protected List<MedalDTO> medalListToMedalDTOList(List<Medal> list) {
        if ( list == null ) {
            return null;
        }

        List<MedalDTO> list1 = new ArrayList<MedalDTO>( list.size() );
        for ( Medal medal : list ) {
            list1.add( medalToMedalDTO( medal ) );
        }

        return list1;
    }
}
