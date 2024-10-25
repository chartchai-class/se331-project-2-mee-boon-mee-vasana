package se331.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.rest.entity.Medal;

import java.util.List;

public interface MedalService {
    Page<Medal> getMedals(Pageable pageable);
    Medal saveMedal(Medal medal);
    void deleteMedal(Long id);
    List<Medal> getAllMedals();

}
