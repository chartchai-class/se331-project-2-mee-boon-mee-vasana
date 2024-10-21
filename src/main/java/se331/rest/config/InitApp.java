package se331.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.rest.entity.Country;
import se331.rest.repository.CountryRepository;
@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent>{
    final CountryRepository countryRepository;

    

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        countryRepository.save(Country.builder()
                .name("United states")
                .nocCode("USA")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/US.svg")
                .description("A global leader in various fields, excelling in sports.")
                .gold(20)
                .silver(15)
                .bronze(10)
                .total(45)
                .build()
        );

    }
}
