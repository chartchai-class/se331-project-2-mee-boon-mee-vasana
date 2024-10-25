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

import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Transactional
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final CountryRepository countryRepository;
    final MedalRepository medalRepository;
    final SportDetailRepository sportRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // สร้างประเทศและข้อมูลที่เกี่ยวข้อง

        // United States
        Country usa = countryRepository.save(Country.builder()
                .name("United States")
                .nocCode("USA")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/US.svg")
                .basicInfo("A global leader in various fields, excelling in sports.")
                .build());

        SportDetail swimmingUSA = SportDetail.builder()
                .sportName("Swimming")
                .rankPosition(1)
                .medalsUrl("🥇")
                .country(usa)
                .build();

        SportDetail trackAndFieldUSA = SportDetail.builder()
                .sportName("Track and Field")
                .rankPosition(2)
                .medalsUrl("🥈")
                .country(usa)
                .build();

        sportRepository.saveAll(Arrays.asList(swimmingUSA, trackAndFieldUSA));
        usa.getOwnSports().addAll(Arrays.asList(swimmingUSA, trackAndFieldUSA));
        countryRepository.save(usa);

        Medal medalUSA = Medal.builder()
                .country(usa)
                .goldCount(20)
                .silverCount(15)
                .bronzeCount(10)
                .build();
        medalRepository.save(medalUSA);

        // China
        Country china = countryRepository.save(Country.builder()
                .name("China")
                .nocCode("CHN")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/CN.svg")
                .basicInfo("A rapidly rising power, strong in various Olympic sports.")
                .build());

        SportDetail divingChina = SportDetail.builder()
                .sportName("Diving")
                .rankPosition(1)
                .medalsUrl("🥇")
                .country(china)
                .build();

        SportDetail gymnasticsChina = SportDetail.builder()
                .sportName("Gymnastics")
                .rankPosition(2)
                .medalsUrl("🥈")
                .country(china)
                .build();

        sportRepository.saveAll(Arrays.asList(divingChina, gymnasticsChina));
        china.getOwnSports().addAll(Arrays.asList(divingChina, gymnasticsChina));
        countryRepository.save(china);

        Medal medalChina = Medal.builder()
                .country(china)
                .goldCount(18)
                .silverCount(20)
                .bronzeCount(15)
                .build();
        medalRepository.save(medalChina);

        // Japan
        Country japan = countryRepository.save(Country.builder()
                .name("Japan")
                .nocCode("JPN")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/JP.svg")
                .basicInfo("An island nation with a rich history and cultural influence.")
                .build());

        SportDetail judoJapan = SportDetail.builder()
                .sportName("Judo")
                .rankPosition(1)
                .medalsUrl("🥇")
                .country(japan)
                .build();

        SportDetail wrestlingJapan = SportDetail.builder()
                .sportName("Wrestling")
                .rankPosition(2)
                .medalsUrl("🥈")
                .country(japan)
                .build();

        sportRepository.saveAll(Arrays.asList(judoJapan, wrestlingJapan));
        japan.getOwnSports().addAll(Arrays.asList(judoJapan, wrestlingJapan));
        countryRepository.save(japan);

        Medal medalJapan = Medal.builder()
                .country(japan)
                .goldCount(12)
                .silverCount(10)
                .bronzeCount(8)
                .build();
        medalRepository.save(medalJapan);

        // Australia
        Country australia = countryRepository.save(Country.builder()
                .name("Australia")
                .nocCode("AUS")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/AU.svg")
                .basicInfo("A country renowned for its natural beauty and athleticism.")
                .build());

        SportDetail swimmingAustralia = SportDetail.builder()
                .sportName("Swimming")
                .rankPosition(1)
                .medalsUrl("🥇")
                .country(australia)
                .build();

        SportDetail rowingAustralia = SportDetail.builder()
                .sportName("Rowing")
                .rankPosition(2)
                .medalsUrl("🥈")
                .country(australia)
                .build();

        sportRepository.saveAll(Arrays.asList(swimmingAustralia, rowingAustralia));
        australia.getOwnSports().addAll(Arrays.asList(swimmingAustralia, rowingAustralia));
        countryRepository.save(australia);

        Medal medalAustralia = Medal.builder()
                .country(australia)
                .goldCount(10)
                .silverCount(15)
                .bronzeCount(12)
                .build();
        medalRepository.save(medalAustralia);

        // Great Britain
        Country greatBritain = countryRepository.save(Country.builder()
                .name("Great Britain")
                .nocCode("GBR")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/ENGLAND.svg")
                .basicInfo("A historic nation with a deep cultural and sporting heritage.")
                .build());

        SportDetail cyclingGB = SportDetail.builder()
                .sportName("Cycling")
                .rankPosition(1)
                .medalsUrl("🥇")
                .country(greatBritain)
                .build();

        SportDetail rowingGB = SportDetail.builder()
                .sportName("Rowing")
                .rankPosition(2)
                .medalsUrl("🥈")
                .country(greatBritain)
                .build();

        sportRepository.saveAll(Arrays.asList(cyclingGB, rowingGB));
        greatBritain.getOwnSports().addAll(Arrays.asList(cyclingGB, rowingGB));
        countryRepository.save(greatBritain);

        Medal medalGB = Medal.builder()
                .country(greatBritain)
                .goldCount(13)
                .silverCount(8)
                .bronzeCount(9)
                .build();
        medalRepository.save(medalGB);

        // Germany
        Country germany = countryRepository.save(Country.builder()
                .name("Germany")
                .nocCode("GER")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/DE.svg")
                .basicInfo("A nation with a strong tradition in both industry and sports.")
                .build());

        SportDetail athleticsGermany = SportDetail.builder()
                .sportName("Athletics")
                .rankPosition(3)
                .medalsUrl("🥉")
                .country(germany)
                .build();

        SportDetail swimmingGermany = SportDetail.builder()
                .sportName("Swimming")
                .rankPosition(2)
                .medalsUrl("🥈")
                .country(germany)
                .build();

        sportRepository.saveAll(Arrays.asList(athleticsGermany, swimmingGermany));
        germany.getOwnSports().addAll(Arrays.asList(athleticsGermany, swimmingGermany));
        countryRepository.save(germany);

        Medal medalGermany = Medal.builder()
                .country(germany)
                .goldCount(14)
                .silverCount(12)
                .bronzeCount(7)
                .build();
        medalRepository.save(medalGermany);

        // France
        Country france = countryRepository.save(Country.builder()
                .name("France")
                .nocCode("FRA")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/FR.svg")
                .basicInfo("A country celebrated for its art, culture, and sporting achievements.")
                .build());

        SportDetail fencingFrance = SportDetail.builder()
                .sportName("Fencing")
                .rankPosition(1)
                .medalsUrl("🥇")
                .country(france)
                .build();

        SportDetail cyclingFrance = SportDetail.builder()
                .sportName("Cycling")
                .rankPosition(3)
                .medalsUrl("🥉")
                .country(france)
                .build();

        sportRepository.saveAll(Arrays.asList(fencingFrance, cyclingFrance));
        france.getOwnSports().addAll(Arrays.asList(fencingFrance, cyclingFrance));
        countryRepository.save(france);

        Medal medalFrance = Medal.builder()
                .country(france)
                .goldCount(11)
                .silverCount(10)
                .bronzeCount(9)
                .build();
        medalRepository.save(medalFrance);

        // Italy
        Country italy = countryRepository.save(Country.builder()
                .name("Italy")
                .nocCode("ITA")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/IT.svg")
                .basicInfo("Renowned for its history, culture, and excellence in various sports.")
                .build());

        SportDetail shootingItaly = SportDetail.builder()
                .sportName("Shooting")
                .rankPosition(1)
                .medalsUrl("🥇")
                .country(italy)
                .build();

        SportDetail rowingItaly = SportDetail.builder()
                .sportName("Rowing")
                .rankPosition(2)
                .medalsUrl("🥈")
                .country(italy)
                .build();

        sportRepository.saveAll(Arrays.asList(shootingItaly, rowingItaly));
        italy.getOwnSports().addAll(Arrays.asList(shootingItaly, rowingItaly));
        countryRepository.save(italy);

        Medal medalItaly = Medal.builder()
                .country(italy)
                .goldCount(10)
                .silverCount(8)
                .bronzeCount(7)
                .build();
        medalRepository.save(medalItaly);

        // Canada
        Country canada = countryRepository.save(Country.builder()
                .name("Canada")
                .nocCode("CAN")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/CA.svg")
                .basicInfo("Known for its vast landscapes and achievements in winter sports.")
                .build());

        SportDetail iceHockeyCanada = SportDetail.builder()
                .sportName("Ice Hockey")
                .rankPosition(1)
                .medalsUrl("🥇")
                .country(canada)
                .build();

        SportDetail swimmingCanada = SportDetail.builder()
                .sportName("Swimming")
                .rankPosition(3)
                .medalsUrl("🥉")
                .country(canada)
                .build();

        sportRepository.saveAll(Arrays.asList(iceHockeyCanada, swimmingCanada));
        canada.getOwnSports().addAll(Arrays.asList(iceHockeyCanada, swimmingCanada));
        countryRepository.save(canada);

        Medal medalCanada = Medal.builder()
                .country(canada)
                .goldCount(7)
                .silverCount(11)
                .bronzeCount(8)
                .build();
        medalRepository.save(medalCanada);

        // Brazil
        Country brazil = countryRepository.save(Country.builder()
                .name("Brazil")
                .nocCode("BRA")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/BR.svg")
                .basicInfo("Famed for its vibrant culture and dominance in football.")
                .build());

        SportDetail volleyballBrazil = SportDetail.builder()
                .sportName("Volleyball")
                .rankPosition(1)
                .medalsUrl("🥇")
                .country(brazil)
                .build();

        SportDetail footballBrazil = SportDetail.builder()
                .sportName("Football")
                .rankPosition(2)
                .medalsUrl("🥈")
                .country(brazil)
                .build();

        sportRepository.saveAll(Arrays.asList(volleyballBrazil, footballBrazil));
        brazil.getOwnSports().addAll(Arrays.asList(volleyballBrazil, footballBrazil));
        countryRepository.save(brazil);

        Medal medalBrazil = Medal.builder()
                .country(brazil)
                .goldCount(6)
                .silverCount(7)
                .bronzeCount(9)
                .build();
        medalRepository.save(medalBrazil);

        // South Korea
        Country southKorea = countryRepository.save(Country.builder()
                .name("South Korea")
                .nocCode("KOR")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/KP.svg")
                .basicInfo("A technologically advanced nation, excelling in archery and Taekwondo.")
                .build());

        SportDetail archeryKorea = SportDetail.builder()
                .sportName("Archery")
                .rankPosition(4)
                .medalsUrl("")
                .country(southKorea)
                .build();

        SportDetail taekwondoKorea = SportDetail.builder()
                .sportName("Taekwondo")
                .rankPosition(2)
                .medalsUrl("🥈")
                .country(southKorea)
                .build();

        sportRepository.saveAll(Arrays.asList(archeryKorea, taekwondoKorea));
        southKorea.getOwnSports().addAll(Arrays.asList(archeryKorea, taekwondoKorea));
        countryRepository.save(southKorea);

        Medal medalKorea = Medal.builder()
                .country(southKorea)
                .goldCount(8)
                .silverCount(5)
                .bronzeCount(6)
                .build();
        medalRepository.save(medalKorea);

        // Netherlands
        Country netherlands = countryRepository.save(Country.builder()
                .name("Netherlands")
                .nocCode("NED")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/NL.svg")
                .basicInfo("A low-lying country known for its canals and cycling culture.")
                .build());

        SportDetail speedSkatingNetherlands = SportDetail.builder()
                .sportName("Speed Skating")
                .rankPosition(3)
                .medalsUrl("🥉")
                .country(netherlands)
                .build();

        SportDetail cyclingNetherlands = SportDetail.builder()
                .sportName("Cycling")
                .rankPosition(2)
                .medalsUrl("🥈")
                .country(netherlands)
                .build();

        sportRepository.saveAll(Arrays.asList(speedSkatingNetherlands, cyclingNetherlands));
        netherlands.getOwnSports().addAll(Arrays.asList(speedSkatingNetherlands, cyclingNetherlands));
        countryRepository.save(netherlands);

        Medal medalNetherlands = Medal.builder()
                .country(netherlands)
                .goldCount(8)
                .silverCount(6)
                .bronzeCount(7)
                .build();
        medalRepository.save(medalNetherlands);

        // Sweden
        Country sweden = countryRepository.save(Country.builder()
                .name("Sweden")
                .nocCode("SWE")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/SE.svg")
                .basicInfo("A Scandinavian country known for its welfare system and winter sports.")
                .build());

        SportDetail skiingSweden = SportDetail.builder()
                .sportName("Skiing")
                .rankPosition(1)
                .medalsUrl("🥇")
                .country(sweden)
                .build();

        SportDetail wrestlingSweden = SportDetail.builder()
                .sportName("Wrestling")
                .rankPosition(2)
                .medalsUrl("🥈")
                .country(sweden)
                .build();

        sportRepository.saveAll(Arrays.asList(skiingSweden, wrestlingSweden));
        sweden.getOwnSports().addAll(Arrays.asList(skiingSweden, wrestlingSweden));
        countryRepository.save(sweden);

        Medal medalSweden = Medal.builder()
                .country(sweden)
                .goldCount(5)
                .silverCount(7)
                .bronzeCount(8)
                .build();
        medalRepository.save(medalSweden);

        // Spain
        Country spain = countryRepository.save(Country.builder()
                .name("Spain")
                .nocCode("ESP")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/ES.svg")
                .basicInfo("Spain, in Southern Europe, is known for its diverse culture, historic cities, and traditions like flamenco dancing and bullfighting.")
                .build());

        SportDetail basketballSpain = SportDetail.builder()
                .sportName("Basketball")
                .rankPosition(1)
                .medalsUrl("🥇")
                .country(spain)
                .build();

        SportDetail footballSpain = SportDetail.builder()
                .sportName("Football")
                .rankPosition(2)
                .medalsUrl("🥈")
                .country(spain)
                .build();

        sportRepository.saveAll(Arrays.asList(basketballSpain, footballSpain));
        spain.getOwnSports().addAll(Arrays.asList(basketballSpain, footballSpain));
        countryRepository.save(spain);

        Medal medalSpain = Medal.builder()
                .country(spain)
                .goldCount(5)
                .silverCount(4)
                .bronzeCount(6)
                .build();
        medalRepository.save(medalSpain);

        // India
        Country india = countryRepository.save(Country.builder()
                .name("India")
                .nocCode("IND")
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/IN.svg")
                .basicInfo("India, in South Asia, is the world's largest democracy and known for its rich history and varied landscapes.")
                .build());

        SportDetail cricketIndia = SportDetail.builder()
                .sportName("Cricket")
                .rankPosition(1)
                .medalsUrl("🥇")
                .country(india)
                .build();

        SportDetail fieldHockeyIndia = SportDetail.builder()
                .sportName("Field Hockey")
                .rankPosition(2)
                .medalsUrl("🥈")
                .country(india)
                .build();

        sportRepository.saveAll(Arrays.asList(cricketIndia, fieldHockeyIndia));
        india.getOwnSports().addAll(Arrays.asList(cricketIndia, fieldHockeyIndia));
        countryRepository.save(india);

        Medal medalIndia = Medal.builder()
                .country(india)
                .goldCount(3)
                .silverCount(4)
                .bronzeCount(5)
                .build();
        medalRepository.save(medalIndia);

        // คุณสามารถเพิ่มข้อมูลเพิ่มเติมหรือปรับแต่งตามความต้องการของคุณ

        // หมายเหตุ:
        // - ตรวจสอบให้แน่ใจว่าคุณได้กำหนดความสัมพันธ์ระหว่างเอนทิตีอย่างถูกต้อง
        // - หากคุณต้องการแมปเหรียญกับกีฬาที่เฉพาะเจาะจง คุณอาจต้องปรับโครงสร้างข้อมูลหรือเพิ่มข้อมูลเหรียญสำหรับแต่ละกีฬา
    }
}