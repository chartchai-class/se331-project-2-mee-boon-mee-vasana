package se331.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.rest.entity.Medal;

public interface MedalRepository extends JpaRepository<Medal, Long> {
}
