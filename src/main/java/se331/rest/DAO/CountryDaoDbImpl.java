package se331.rest.DAO;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Country;
import se331.rest.repository.CountryRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class CountryDaoDbImpl implements CountryDao  {
    final CountryRepository countryRepository;

    @Override
    public Country getCountry(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }
}
