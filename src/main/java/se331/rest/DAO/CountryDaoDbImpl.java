package se331.rest.DAO;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Repository;
import se331.rest.entity.Country;
import se331.rest.repository.CountryRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class CountryDaoDbImpl implements CountryDao  {
    final CountryRepository countryRepository;


    @Override
    public Page<Country> getAllCountries(Integer pageSize, Integer page) {
        return countryRepository.findAll(PageRequest.of(page -1, pageSize));
    }
    @Override
    public Page<Country> getAllCountries(String name,Pageable pageable) {
        return countryRepository.findByNameIgnoreCaseContaining(name,pageable);
    }

    @Override
    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void deleteCountry(Long id) {
            countryRepository.deleteById(id);
    }
}
