package se331.rest.service;

import se331.rest.entity.Country;

public interface CountryService {
    Country getCountry(Long id);
    Country saveCountry(Country country);
}
