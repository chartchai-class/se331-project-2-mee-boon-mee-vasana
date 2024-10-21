package se331.rest.DAO;

import org.springframework.data.domain.Page;
import se331.rest.entity.Country;

import java.util.List;

public interface CountryDao {
    Country getCountry(Long id);
    Country saveCountry(Country country);

    Page<Country> getCountries(Integer pageSize, Integer page);
}
