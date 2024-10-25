package se331.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.DTO.CountryDTO;
import se331.rest.entity.Country;

import java.util.List;

public interface CountryService {
    CountryDTO getCountryById(Long id);
    List<CountryDTO> getAllCountries();
    CountryDTO addCountry(CountryDTO countryDTO);
    CountryDTO updateCountry(Long id, CountryDTO countryDTO);
    void deleteCountry(Long id);

}
