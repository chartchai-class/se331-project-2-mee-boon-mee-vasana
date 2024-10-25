package se331.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.SportDetail;

import java.util.List;

public interface SportDetailService {
    Page<SportDetail> getSports(Pageable pageRequest);
    SportDetail getSportById(Long id);
    SportDetail saveSport(SportDetail sport);
    void deleteSport(Long id);
}
