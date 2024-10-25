package se331.rest.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Medal;
import se331.rest.entity.SportDetail;

import java.util.List;
import java.util.Optional;

public interface SportDetailDao {
    Page<SportDetail> getSports(Pageable pageRequest);
    SportDetail getSportById(Long id);
    SportDetail saveSport(SportDetail sport);
    void deleteSport(Long id);
    List<SportDetail> getAllSports();

}
