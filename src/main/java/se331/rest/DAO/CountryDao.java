package se331.rest.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Country;

import java.util.List;

public interface CountryDao {
    Page<Country> getAllCountries(String name, Pageable pageable);
    Page<Country> getAllCountries(Integer pageSize, Integer page);

    Country getCountryById(Long id);
    Country saveCountry(Country country);
    void deleteCountry(Long id);
}
