package se331.rest.config;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import se331.rest.entity.Comment;
import se331.rest.entity.Country;
import se331.rest.entity.Medal;
import se331.rest.entity.SportDetail;
import se331.rest.repository.CommentRepository;
import se331.rest.repository.CountryRepository;
import se331.rest.repository.MedalRepository;
import se331.rest.repository.SportDetailRepository;
import se331.rest.security.user.Role;
import se331.rest.security.user.User;
import se331.rest.security.user.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Transactional
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final CountryRepository countryRepository;
    final MedalRepository medalRepository;
    final SportDetailRepository sportRepository;
    final UserRepository userRepository;
    final CommentRepository commentRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        addUser();
        addComments();
        // Create countries and related data based on the Tokyo 2020 Olympics


        // United States
        Country usa = createCountry("United States", "USA", "US.svg", "The United States of America is a federal republic consisting of 50 states.");
        usa.setOwnSports(new ArrayList<>());

        // Assigning medals from sports
        SportDetail athleticsUSA = createSportDetail("Athletics", 1, "🥇", usa);
        SportDetail swimmingUSA = createSportDetail("Swimming", 1, "🥇", usa);
        SportDetail shootingUSA = createSportDetail("Shooting", 1, "🥇", usa);
        SportDetail basketballUSA = createSportDetail("Basketball", 1, "🥇", usa);
        SportDetail golfUSA = createSportDetail("Golf", 1, "🥇", usa);
        SportDetail wrestlingUSA = createSportDetail("Wrestling", 2, "🥈", usa);
        SportDetail trackCyclingUSA = createSportDetail("Track Cycling", 3, "🥉", usa);
        SportDetail sportClimbingUSA = createSportDetail("Sport Climbing", 3, "🥉", usa);
        SportDetail surfingUSA = createSportDetail("Surfing", 2, "🥈", usa);
        SportDetail boxingUSA = createSportDetail("Boxing", 2, "🥈", usa);

        sportRepository.saveAll(Arrays.asList(athleticsUSA, swimmingUSA, shootingUSA, basketballUSA, golfUSA,
                wrestlingUSA, trackCyclingUSA, sportClimbingUSA, surfingUSA, boxingUSA));
        usa.getOwnSports().addAll(Arrays.asList(athleticsUSA, swimmingUSA, shootingUSA, basketballUSA, golfUSA,
                wrestlingUSA, trackCyclingUSA, sportClimbingUSA, surfingUSA, boxingUSA));
        countryRepository.save(usa);

        Medal medalUSA = Medal.builder()
                .country(usa)
                .goldCount(5)
                .silverCount(3)
                .bronzeCount(2)
                .build();
        medalRepository.save(medalUSA);

        // China
        Country china = createCountry("China", "CHN", "CN.svg", "The People's Republic of China is the world's most populous country.");
        china.setOwnSports(new ArrayList<>());

        SportDetail weightliftingChina = createSportDetail("Weightlifting", 1, "🥇", china);
        SportDetail divingChina = createSportDetail("Diving", 1, "🥇", china);
        SportDetail tableTennisChina = createSportDetail("Table Tennis", 1, "🥇", china);
        SportDetail badmintonChina = createSportDetail("Badminton", 1, "🥇", china);
        SportDetail gymnasticsChina = createSportDetail("Gymnastics", 1, "🥇", china);
        SportDetail trampolineChina = createSportDetail("Trampoline", 1, "🥇", china);
        SportDetail shootingChina = createSportDetail("Shooting", 2, "🥈", china);
        SportDetail swimmingChina = createSportDetail("Swimming", 2, "🥈", china);
        SportDetail athleticsChina = createSportDetail("Athletics", 2, "🥈", china);
        SportDetail boxingChina = createSportDetail("Boxing", 3, "🥉", china);

        sportRepository.saveAll(Arrays.asList(weightliftingChina, divingChina, tableTennisChina, badmintonChina,
                gymnasticsChina, trampolineChina, shootingChina, swimmingChina, athleticsChina, boxingChina));
        china.getOwnSports().addAll(Arrays.asList(weightliftingChina, divingChina, tableTennisChina, badmintonChina,
                gymnasticsChina, trampolineChina, shootingChina, swimmingChina, athleticsChina, boxingChina));
        countryRepository.save(china);

        Medal medalChina = Medal.builder()
                .country(china)
                .goldCount(6)
                .silverCount(3)
                .bronzeCount(1)
                .build();
        medalRepository.save(medalChina);

        // Japan
        Country japan = createCountry("Japan", "JPN", "JP.svg", "An island country in East Asia with a rich cultural heritage.");
        japan.setOwnSports(new ArrayList<>());

        SportDetail judoJapan = createSportDetail("Judo", 1, "🥇", japan);
        SportDetail skateboardingJapan = createSportDetail("Skateboarding", 1, "🥇", japan);
        SportDetail karateJapan = createSportDetail("Karate", 1, "🥇", japan);
        SportDetail baseballJapan = createSportDetail("Baseball", 1, "🥇", japan);
        SportDetail sportClimbingJapan = createSportDetail("Sport Climbing", 2, "🥈", japan);
        SportDetail surfingJapan = createSportDetail("Surfing", 1, "🥇", japan);
        SportDetail tableTennisJapan = createSportDetail("Table Tennis", 2, "🥈", japan);
        SportDetail wrestlingJapan = createSportDetail("Wrestling", 1, "🥇", japan);
        SportDetail fencingJapan = createSportDetail("Fencing", 3, "🥉", japan);
        SportDetail swimmingJapan = createSportDetail("Swimming", 3, "🥉", japan);

        sportRepository.saveAll(Arrays.asList(judoJapan, skateboardingJapan, karateJapan, baseballJapan,
                sportClimbingJapan, surfingJapan, tableTennisJapan, wrestlingJapan, fencingJapan, swimmingJapan));
        japan.getOwnSports().addAll(Arrays.asList(judoJapan, skateboardingJapan, karateJapan, baseballJapan,
                sportClimbingJapan, surfingJapan, tableTennisJapan, wrestlingJapan, fencingJapan, swimmingJapan));
        countryRepository.save(japan);

        Medal medalJapan = Medal.builder()
                .country(japan)
                .goldCount(6)
                .silverCount(2)
                .bronzeCount(2)
                .build();
        medalRepository.save(medalJapan);

        // Australia
        Country australia = createCountry("Australia", "AUS", "AU.svg", "A country and continent surrounded by the Indian and Pacific oceans.");
        australia.setOwnSports(new ArrayList<>());

        SportDetail swimmingAustralia = createSportDetail("Swimming", 1, "🥇", australia);
        SportDetail rowingAustralia = createSportDetail("Rowing", 1, "🥇", australia);
        SportDetail sailingAustralia = createSportDetail("Sailing", 1, "🥇", australia);
        SportDetail canoeingAustralia = createSportDetail("Canoeing", 1, "🥇", australia);
        SportDetail cyclingAustralia = createSportDetail("Cycling", 2, "🥈", australia);
        SportDetail athleticsAustralia = createSportDetail("Athletics", 3, "🥉", australia);

        sportRepository.saveAll(Arrays.asList(swimmingAustralia, rowingAustralia, sailingAustralia, canoeingAustralia,
                cyclingAustralia, athleticsAustralia));
        australia.getOwnSports().addAll(Arrays.asList(swimmingAustralia, rowingAustralia, sailingAustralia, canoeingAustralia,
                cyclingAustralia, athleticsAustralia));
        countryRepository.save(australia);

        Medal medalAustralia = Medal.builder()
                .country(australia)
                .goldCount(4)
                .silverCount(1)
                .bronzeCount(1)
                .build();
        medalRepository.save(medalAustralia);

        // Great Britain
        Country greatBritain = createCountry("Great Britain", "GBR", "GB.svg", "The United Kingdom of Great Britain and Northern Ireland.");
        greatBritain.setOwnSports(new ArrayList<>());

        SportDetail cyclingGB = createSportDetail("Cycling", 1, "🥇", greatBritain);
        SportDetail sailingGB = createSportDetail("Sailing", 2, "🥈", greatBritain);
        SportDetail boxingGB = createSportDetail("Boxing", 3, "🥉", greatBritain);
        SportDetail equestrianGB = createSportDetail("Equestrian", 1, "🥇", greatBritain);
        SportDetail gymnasticsGB = createSportDetail("Gymnastics", 2, "🥈", greatBritain);

        sportRepository.saveAll(Arrays.asList(cyclingGB, sailingGB, boxingGB, equestrianGB, gymnasticsGB));
        greatBritain.getOwnSports().addAll(Arrays.asList(cyclingGB, sailingGB, boxingGB, equestrianGB, gymnasticsGB));
        countryRepository.save(greatBritain);

        Medal medalGB = Medal.builder()
                .country(greatBritain)
                .goldCount(2)
                .silverCount(2)
                .bronzeCount(1)
                .build();
        medalRepository.save(medalGB);

        // ROC (Russian Olympic Committee)
        Country roc = createCountry("Russian Olympic Committee", "ROC", "RU.svg", "Competed under 'Russian Olympic Committee' due to sanctions.");
        roc.setOwnSports(new ArrayList<>());

        SportDetail gymnasticsROC = createSportDetail("Gymnastics", 1, "🥇", roc);
        SportDetail wrestlingROC = createSportDetail("Wrestling", 2, "🥈", roc);
        SportDetail fencingROC = createSportDetail("Fencing", 1, "🥇", roc);
        SportDetail boxingROC = createSportDetail("Boxing", 3, "🥉", roc);
        SportDetail shootingROC = createSportDetail("Shooting", 3, "🥉", roc);

        sportRepository.saveAll(Arrays.asList(gymnasticsROC, wrestlingROC, fencingROC, boxingROC, shootingROC));
        roc.getOwnSports().addAll(Arrays.asList(gymnasticsROC, wrestlingROC, fencingROC, boxingROC, shootingROC));
        countryRepository.save(roc);

        Medal medalROC = Medal.builder()
                .country(roc)
                .goldCount(2)
                .silverCount(1)
                .bronzeCount(2)
                .build();
        medalRepository.save(medalROC);

        // Netherlands
        Country netherlands = createCountry("Netherlands", "NED", "NL.svg", "A country in northwestern Europe known for its flat landscape.");
        netherlands.setOwnSports(new ArrayList<>());

        SportDetail cyclingNetherlands = createSportDetail("Cycling", 2, "🥈", netherlands);
        SportDetail sailingNetherlands = createSportDetail("Sailing", 1, "🥇", netherlands);
        SportDetail rowingNetherlands = createSportDetail("Rowing", 2, "🥈", netherlands);

        sportRepository.saveAll(Arrays.asList(cyclingNetherlands, sailingNetherlands, rowingNetherlands));
        netherlands.getOwnSports().addAll(Arrays.asList(cyclingNetherlands, sailingNetherlands, rowingNetherlands));
        countryRepository.save(netherlands);

        Medal medalNetherlands = Medal.builder()
                .country(netherlands)
                .goldCount(1)
                .silverCount(2)
                .bronzeCount(0)
                .build();
        medalRepository.save(medalNetherlands);

        // France
        Country france = createCountry("France", "FRA", "FR.svg", "A Western European country with medieval cities and Mediterranean beaches.");
        france.setOwnSports(new ArrayList<>());

        SportDetail judoFrance = createSportDetail("Judo", 2, "🥈", france);
        SportDetail fencingFrance = createSportDetail("Fencing", 2, "🥈", france);
        SportDetail handballFrance = createSportDetail("Handball", 1, "🥇", france);

        sportRepository.saveAll(Arrays.asList(judoFrance, fencingFrance, handballFrance));
        france.getOwnSports().addAll(Arrays.asList(judoFrance, fencingFrance, handballFrance));
        countryRepository.save(france);

        Medal medalFrance = Medal.builder()
                .country(france)
                .goldCount(1)
                .silverCount(2)
                .bronzeCount(0)
                .build();
        medalRepository.save(medalFrance);

        // Germany
        Country germany = createCountry("Germany", "GER", "DE.svg", "A Western European country with a landscape of forests, rivers, and mountain ranges.");
        germany.setOwnSports(new ArrayList<>());

        SportDetail equestrianGermany = createSportDetail("Equestrian", 2, "🥈", germany);
        SportDetail canoeingGermany = createSportDetail("Canoeing", 1, "🥇", germany);
        SportDetail cyclingGermany = createSportDetail("Cycling", 3, "🥉", germany);

        sportRepository.saveAll(Arrays.asList(equestrianGermany, canoeingGermany, cyclingGermany));
        germany.getOwnSports().addAll(Arrays.asList(equestrianGermany, canoeingGermany, cyclingGermany));
        countryRepository.save(germany);

        Medal medalGermany = Medal.builder()
                .country(germany)
                .goldCount(1)
                .silverCount(1)
                .bronzeCount(1)
                .build();
        medalRepository.save(medalGermany);

        // Italy
        Country italy = createCountry("Italy", "ITA", "IT.svg", "A European country with a long Mediterranean coastline.");
        italy.setOwnSports(new ArrayList<>());

        SportDetail athleticsItaly = createSportDetail("Athletics", 2, "🥈", italy);
        SportDetail fencingItaly = createSportDetail("Fencing", 3, "🥉", italy);
        SportDetail shootingItaly = createSportDetail("Shooting", 1, "🥇", italy);

        sportRepository.saveAll(Arrays.asList(athleticsItaly, fencingItaly, shootingItaly));
        italy.getOwnSports().addAll(Arrays.asList(athleticsItaly, fencingItaly, shootingItaly));
        countryRepository.save(italy);

        Medal medalItaly = Medal.builder()
                .country(italy)
                .goldCount(1)
                .silverCount(1)
                .bronzeCount(1)
                .build();
        medalRepository.save(medalItaly);

        // Canada
        Country canada = createCountry("Canada", "CAN", "CA.svg", "A country stretching from the U.S. in the south to the Arctic Circle in the north.");
        canada.setOwnSports(new ArrayList<>());

        SportDetail athleticsCanada = createSportDetail("Athletics", 3, "🥉", canada);
        SportDetail swimmingCanada = createSportDetail("Swimming", 2, "🥈", canada);
        SportDetail rowingCanada = createSportDetail("Rowing", 3, "🥉", canada);

        sportRepository.saveAll(Arrays.asList(athleticsCanada, swimmingCanada, rowingCanada));
        canada.getOwnSports().addAll(Arrays.asList(athleticsCanada, swimmingCanada, rowingCanada));
        countryRepository.save(canada);

        Medal medalCanada = Medal.builder()
                .country(canada)
                .goldCount(0)
                .silverCount(1)
                .bronzeCount(2)
                .build();
        medalRepository.save(medalCanada);

        // Brazil
        Country brazil = createCountry("Brazil", "BRA", "BR.svg", "The largest country in South America, extending from the Amazon Basin to Iguaçu Falls.");
        brazil.setOwnSports(new ArrayList<>());

        SportDetail footballBrazil = createSportDetail("Football", 1, "🥇", brazil);
        SportDetail boxingBrazil = createSportDetail("Boxing", 1, "🥇", brazil);
        SportDetail skateboardingBrazil = createSportDetail("Skateboarding", 2, "🥈", brazil);

        sportRepository.saveAll(Arrays.asList(footballBrazil, boxingBrazil, skateboardingBrazil));
        brazil.getOwnSports().addAll(Arrays.asList(footballBrazil, boxingBrazil, skateboardingBrazil));
        countryRepository.save(brazil);

        Medal medalBrazil = Medal.builder()
                .country(brazil)
                .goldCount(2)
                .silverCount(1)
                .bronzeCount(0)
                .build();
        medalRepository.save(medalBrazil);

        // New Zealand
        Country newZealand = createCountry("New Zealand", "NZL", "NZ.svg", "An island country in the southwestern Pacific Ocean.");
        newZealand.setOwnSports(new ArrayList<>());

        SportDetail rowingNZ = createSportDetail("Rowing", 1, "🥇", newZealand);
        SportDetail rugbyNZ = createSportDetail("Rugby Sevens", 2, "🥈", newZealand);
        SportDetail sailingNZ = createSportDetail("Sailing", 3, "🥉", newZealand);

        sportRepository.saveAll(Arrays.asList(rowingNZ, rugbyNZ, sailingNZ));
        newZealand.getOwnSports().addAll(Arrays.asList(rowingNZ, rugbyNZ, sailingNZ));
        countryRepository.save(newZealand);

        Medal medalNZ = Medal.builder()
                .country(newZealand)
                .goldCount(1)
                .silverCount(1)
                .bronzeCount(1)
                .build();
        medalRepository.save(medalNZ);

        // South Korea
        Country southKorea = createCountry("South Korea", "KOR", "KR.svg", "An East Asian nation on the southern half of the Korean Peninsula.");
        southKorea.setOwnSports(new ArrayList<>());

        SportDetail archeryKorea = createSportDetail("Archery", 1, "🥇", southKorea);
        SportDetail taekwondoKorea = createSportDetail("Taekwondo", 1, "🥇", southKorea);
        SportDetail fencingKorea = createSportDetail("Fencing", 3, "🥉", southKorea);

        sportRepository.saveAll(Arrays.asList(archeryKorea, taekwondoKorea, fencingKorea));
        southKorea.getOwnSports().addAll(Arrays.asList(archeryKorea, taekwondoKorea, fencingKorea));
        countryRepository.save(southKorea);

        Medal medalKorea = Medal.builder()
                .country(southKorea)
                .goldCount(2)
                .silverCount(0)
                .bronzeCount(1)
                .build();
        medalRepository.save(medalKorea);

        // Spain
        Country spain = createCountry("Spain", "ESP", "ES.svg", "A country on Europe's Iberian Peninsula, includes 17 autonomous regions.");
        spain.setOwnSports(new ArrayList<>());

        SportDetail karateSpain = createSportDetail("Karate", 2, "🥈", spain);
        SportDetail sailingSpain = createSportDetail("Sailing", 2, "🥈", spain);
        SportDetail footballSpain = createSportDetail("Football", 2, "🥈", spain);

        sportRepository.saveAll(Arrays.asList(karateSpain, sailingSpain, footballSpain));
        spain.getOwnSports().addAll(Arrays.asList(karateSpain, sailingSpain, footballSpain));
        countryRepository.save(spain);

        Medal medalSpain = Medal.builder()
                .country(spain)
                .goldCount(0)
                .silverCount(3)
                .bronzeCount(0)
                .build();
        medalRepository.save(medalSpain);

        // India
        Country india = createCountry("India", "IND", "IN.svg", "A country in South Asia, the seventh-largest by land area.");
        india.setOwnSports(new ArrayList<>());

        SportDetail athleticsIndia = createSportDetail("Athletics", 1, "🥇", india);
        SportDetail weightliftingIndia = createSportDetail("Weightlifting", 2, "🥈", india);
        SportDetail hockeyIndia = createSportDetail("Field Hockey", 3, "🥉", india);

        sportRepository.saveAll(Arrays.asList(athleticsIndia, weightliftingIndia, hockeyIndia));
        india.getOwnSports().addAll(Arrays.asList(athleticsIndia, weightliftingIndia, hockeyIndia));
        countryRepository.save(india);

        Medal medalIndia = Medal.builder()
                .country(india)
                .goldCount(1)
                .silverCount(1)
                .bronzeCount(1)
                .build();
        medalRepository.save(medalIndia);

        // Kenya
        Country kenya = createCountry("Kenya", "KEN", "KE.svg", "A country in East Africa with coastline on the Indian Ocean.");
        kenya.setOwnSports(new ArrayList<>());

        SportDetail athleticsKenya = createSportDetail("Athletics", 3, "🥉", kenya);

        sportRepository.save(athleticsKenya);
        kenya.getOwnSports().add(athleticsKenya);
        countryRepository.save(kenya);

        Medal medalKenya = Medal.builder()
                .country(kenya)
                .goldCount(0)
                .silverCount(0)
                .bronzeCount(1)
                .build();
        medalRepository.save(medalKenya);

        // Kazakhstan
        Country kazakhstan = createCountry("Kazakhstan", "KAZ", "KZ.svg", "A Central Asian country and former Soviet republic.");
        kazakhstan.setOwnSports(new ArrayList<>());

        SportDetail weightliftingKazakhstan = createSportDetail("Weightlifting", 3, "🥉", kazakhstan);

        sportRepository.save(weightliftingKazakhstan);
        kazakhstan.getOwnSports().add(weightliftingKazakhstan);
        countryRepository.save(kazakhstan);

        Medal medalKazakhstan = Medal.builder()
                .country(kazakhstan)
                .goldCount(0)
                .silverCount(0)
                .bronzeCount(1)
                .build();
        medalRepository.save(medalKazakhstan);

        // Cuba
        Country cuba = createCountry("Cuba", "CUB", "CU.svg", "A Caribbean island nation under communist rule.");
        cuba.setOwnSports(new ArrayList<>());

        SportDetail boxingCuba = createSportDetail("Boxing", 1, "🥇", cuba);

        sportRepository.save(boxingCuba);
        cuba.getOwnSports().add(boxingCuba);
        countryRepository.save(cuba);

        Medal medalCuba = Medal.builder()
                .country(cuba)
                .goldCount(1)
                .silverCount(0)
                .bronzeCount(0)
                .build();
        medalRepository.save(medalCuba);

        // Philippines
        Country philippines = createCountry("Philippines", "PHI", "PH.svg", "An archipelagic country in Southeast Asia.");
        philippines.setOwnSports(new ArrayList<>());

        SportDetail boxingPhilippines = createSportDetail("Boxing", 3, "🥉", philippines);
        SportDetail weightliftingPhilippines = createSportDetail("Weightlifting", 1, "🥇", philippines);

        sportRepository.saveAll(Arrays.asList(boxingPhilippines, weightliftingPhilippines));
        philippines.getOwnSports().addAll(Arrays.asList(boxingPhilippines, weightliftingPhilippines));
        countryRepository.save(philippines);

        Medal medalPhilippines = Medal.builder()
                .country(philippines)
                .goldCount(1)
                .silverCount(0)
                .bronzeCount(1)
                .build();
        medalRepository.save(medalPhilippines);

        // Argentina
        Country argentina = createCountry("Argentina", "ARG", "AR.svg", "A massive South American nation with terrain encompassing Andes mountains.");
        argentina.setOwnSports(new ArrayList<>());

        SportDetail rugbyArgentina = createSportDetail("Rugby Sevens", 3, "🥉", argentina);

        sportRepository.save(rugbyArgentina);
        argentina.getOwnSports().add(rugbyArgentina);
        countryRepository.save(argentina);

        Medal medalArgentina = Medal.builder()
                .country(argentina)
                .goldCount(0)
                .silverCount(0)
                .bronzeCount(1)
                .build();
        medalRepository.save(medalArgentina);

        // Total sports used: 20
        // Total countries: 18
    }

    private SportDetail createSportDetail(String sportName, int rankPosition, String medalsUrl, Country country) {
        SportDetail sportDetail = SportDetail.builder()
                .sportName(sportName)
                .rankPosition(rankPosition)
                .medalsUrl(medalsUrl)
                .country(country)
                .build();
        return sportDetail;
    }

    private Country createCountry(String name, String nocCode, String flagFileName, String basicInfo) {
        Country country = Country.builder()
                .name(name)
                .nocCode(nocCode)
                .flagUrl("https://cdn.jsdelivr.net/npm/country-flag-emoji-json@2.0.0/dist/images/" + flagFileName)
                .basicInfo(basicInfo)
                .build();
        countryRepository.save(country);
        country.setOwnSports(new ArrayList<>());
        return country;
    }
    private void addUser(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // Create an administrator user
        User adminUser = User.builder()
                .firstname("Admin")
                .lastname("Admin")
                .username("admin")
                .email("admin@example.com")
                .password(passwordEncoder.encode("adminpass"))
                .enabled(true)
                .build();

// Create registered users
        User user1 = User.builder()
                .firstname("John")
                .lastname("Doe")
                .username("johndoe")
                .email("john.doe@example.com")
                .password(passwordEncoder.encode("password123"))
                .enabled(true)
                .build();

        User user2 = User.builder()
                .firstname("Jane")
                .lastname("Smith")
                .username("janesmith")
                .email("jane.smith@example.com")
                .password(passwordEncoder.encode("password456"))
                .enabled(true)
                .build();

        adminUser.getRoles().add(Role.ROLE_USER);
        adminUser.getRoles().add(Role.ROLE_ADMIN);

        user1.getRoles().add(Role.ROLE_USER);
        user2.getRoles().add(Role.ROLE_USER);


        userRepository.save(adminUser);
        userRepository.save(user1);
        userRepository.save(user2);
    }
    private void addComments() {
        // Fetch users and countries from repositories
        User user1 = userRepository.findByUsername("johndoe").orElse(null);
        User user2 = userRepository.findByUsername("janesmith").orElse(null);
        Country usa = countryRepository.findByName("United States").orElse(null);
        Country china = countryRepository.findByName("China").orElse(null);

        if (user1 != null && usa != null) {
            Comment comment1 = Comment.builder()
                    .content("Congratulations to the USA team!")
                    .timestamp(LocalDateTime.now())
                    .user(user1)
                    .country(usa)
                    .build();
            commentRepository.save(comment1);
        }

        if (user2 != null && china != null) {
            Comment comment2 = Comment.builder()
                    .content("Well done, China!")
                    .timestamp(LocalDateTime.now())
                    .user(user2)
                    .country(china)
                    .build();
            commentRepository.save(comment2);
        }
    }
}