package se331.rest.DAO;

import se331.rest.entity.Country;

public interface CountryDao {
    Country getCountry(Long id);
    Country saveCountry(Country country);
}
