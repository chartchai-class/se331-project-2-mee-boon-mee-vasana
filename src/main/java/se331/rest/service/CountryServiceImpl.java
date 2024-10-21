package se331.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import se331.rest.DAO.CountryDao;
import se331.rest.entity.Country;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    final CountryDao countryDao;

    @Override
    public Country getCountry(Long id) {
        return countryDao.getCountry(id);
    }

    @Override
    public Country saveCountry(Country country) {
        return null;
    }

    @Override
    public Page<Country> getCountries(Integer pageSize, Integer page) {
        return countryDao.getCountries(pageSize,page);
    }


}
