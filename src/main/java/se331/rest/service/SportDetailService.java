package se331.rest.service;

import org.springframework.data.domain.Page;
import se331.rest.entity.SportDetail;

import java.util.List;

public interface SportDetailService {
    List<SportDetail> getAllSportDetails();
    Page<SportDetail> getSportDetails(Integer page, Integer pageSize);
}
