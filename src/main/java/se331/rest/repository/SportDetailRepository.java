package se331.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.rest.entity.SportDetail;

public interface SportDetailRepository extends JpaRepository<SportDetail, Long> {
}
