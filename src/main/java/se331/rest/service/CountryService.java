package se331.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.DTO.CountryDTO;
import se331.rest.entity.Country;

import java.util.List;

public interface CountryService {
    Page<Country> getAllCountries(String name,Pageable pageable);
    Page<Country> getAllCountries(Integer pageSize, Integer page);

    Country getCountryById(Long id);
    Country saveCountry(Country country);
    void deleteCountry(Long id);
}
