package se331.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.rest.entity.Country;
import se331.rest.entity.Medal;
import se331.rest.entity.SportDetail;
import se331.rest.repository.CountryRepository;
import se331.rest.repository.MedalRepository;
import se331.rest.repository.SportDetailRepository;

@Component
@RequiredArgsConstructor
@Transactional
public class InitApp implements ApplicationListener<ApplicationReadyEvent>{
    final CountryRepository countryRepository;
    final MedalRepository medalRepository;
    final SportDetailRepository sportRepository;



    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // Create sports
        SportDetail sport1 = sportRepository.save(SportDetail.builder().sportName("Athletics").build());
        SportDetail sport2 = sportRepository.save(SportDetail.builder().sportName("Swimming").build());
        SportDetail sport3 = sportRepository.save(SportDetail.builder().sportName("Gymnastics").build());

        // Create countries
        Country country1 = countryRepository.save(Country.builder().name("Thailand").basicInfo("Southeast Asian country").build());
        Country country2 = countryRepository.save(Country.builder().name("USA").basicInfo("North American country").build());
        Country country3 = countryRepository.save(Country.builder().name("Japan").basicInfo("East Asian country").build());

        // Create medals for countries
        medalRepository.save(Medal.builder().country(country1).sport(sport1).goldCount(1).silverCount(2).bronzeCount(1).build());
        medalRepository.save(Medal.builder().country(country1).sport(sport2).goldCount(0).silverCount(1).bronzeCount(2).build());
        medalRepository.save(Medal.builder().country(country2).sport(sport1).goldCount(5).silverCount(3).bronzeCount(2).build());
        medalRepository.save(Medal.builder().country(country2).sport(sport3).goldCount(3).silverCount(1).bronzeCount(0).build());
        medalRepository.save(Medal.builder().country(country3).sport(sport2).goldCount(2).silverCount(2).bronzeCount(1).build());
        medalRepository.save(Medal.builder().country(country3).sport(sport3).goldCount(1).silverCount(0).bronzeCount(2).build());

    }
}
