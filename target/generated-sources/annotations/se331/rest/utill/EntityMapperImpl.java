package se331.rest.utill;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import se331.rest.DTO.CountryDTO;
import se331.rest.DTO.CountryOwnSportDTO;
import se331.rest.DTO.MedalDTO;
import se331.rest.DTO.SportDetailDTO;
import se331.rest.entity.Country;
import se331.rest.entity.Medal;
import se331.rest.entity.SportDetail;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-25T21:32:55+0700",
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
        countryDTO.basicInfo( country.getBasicInfo() );
        countryDTO.ownSports( sportDetailListToCountryOwnSportDTOList( country.getOwnSports() ) );
        countryDTO.medals( getMedalDTO( country.getMedals() ) );

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

    @Override
    public MedalDTO getMedalDTO(Medal medal) {
        if ( medal == null ) {
            return null;
        }

        MedalDTO.MedalDTOBuilder medalDTO = MedalDTO.builder();

        medalDTO.id( medal.getId() );
        medalDTO.goldCount( medal.getGoldCount() );
        medalDTO.silverCount( medal.getSilverCount() );
        medalDTO.bronzeCount( medal.getBronzeCount() );

        return medalDTO.build();
    }

    @Override
    public List<MedalDTO> getMedalDTO(List<Medal> medals) {
        if ( medals == null ) {
            return null;
        }

        List<MedalDTO> list = new ArrayList<MedalDTO>( medals.size() );
        for ( Medal medal : medals ) {
            list.add( getMedalDTO( medal ) );
        }

        return list;
    }

    @Override
    public SportDetailDTO getSportDetailDTO(SportDetail sportDetail) {
        if ( sportDetail == null ) {
            return null;
        }

        SportDetailDTO.SportDetailDTOBuilder sportDetailDTO = SportDetailDTO.builder();

        sportDetailDTO.id( sportDetail.getId() );
        sportDetailDTO.sportName( sportDetail.getSportName() );
        sportDetailDTO.medalsUrl( sportDetail.getMedalsUrl() );
        sportDetailDTO.medals( getMedalDTO( sportDetail.getMedals() ) );

        return sportDetailDTO.build();
    }

    @Override
    public List<SportDetailDTO> getSportDetailDTO(List<SportDetail> sportDetails) {
        if ( sportDetails == null ) {
            return null;
        }

        List<SportDetailDTO> list = new ArrayList<SportDetailDTO>( sportDetails.size() );
        for ( SportDetail sportDetail : sportDetails ) {
            list.add( getSportDetailDTO( sportDetail ) );
        }

        return list;
    }

    protected CountryOwnSportDTO sportDetailToCountryOwnSportDTO(SportDetail sportDetail) {
        if ( sportDetail == null ) {
            return null;
        }

        CountryOwnSportDTO.CountryOwnSportDTOBuilder countryOwnSportDTO = CountryOwnSportDTO.builder();

        countryOwnSportDTO.id( sportDetail.getId() );
        countryOwnSportDTO.sportName( sportDetail.getSportName() );
        countryOwnSportDTO.rankPosition( sportDetail.getRankPosition() );
        countryOwnSportDTO.medalsUrl( sportDetail.getMedalsUrl() );

        return countryOwnSportDTO.build();
    }

    protected List<CountryOwnSportDTO> sportDetailListToCountryOwnSportDTOList(List<SportDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<CountryOwnSportDTO> list1 = new ArrayList<CountryOwnSportDTO>( list.size() );
        for ( SportDetail sportDetail : list ) {
            list1.add( sportDetailToCountryOwnSportDTO( sportDetail ) );
        }

        return list1;
    }
}
