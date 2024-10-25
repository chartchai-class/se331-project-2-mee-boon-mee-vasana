package se331.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.rest.entity.Country;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findAll();
    Page<Country> findByNameIgnoreCaseContaining(String name, Pageable pageable);
}
