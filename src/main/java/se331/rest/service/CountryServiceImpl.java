package se331.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.rest.DAO.CountryDao;
import se331.rest.entity.Country;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    final CountryDao countryDao;

    @Override
    public Page<Country> getAllCountries(String name, Pageable pageable) {
        return countryDao.getAllCountries(name, pageable );
    }

    @Override
    public Page<Country> getAllCountries(Integer pageSize, Integer page) {
        return countryDao.getAllCountries(pageSize, page);
    }

    @Override
    public Country getCountryById(Long id) {
        return countryDao.getCountryById(id);
    }

    @Override
    public Country saveCountry(Country country) {
        return countryDao.saveCountry(country);
    }

    @Override
    public void deleteCountry(Long id) {
        countryDao.deleteCountry(id);
    }
}
