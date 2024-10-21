package se331.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Country;

public interface CountryService {
    Country getCountry(Long id);
    Country saveCountry(Country country);
    Page<Country> getCountries(Integer pageSize, Integer page );
}
