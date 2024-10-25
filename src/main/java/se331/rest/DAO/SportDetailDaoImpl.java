package se331.rest.DAO;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.rest.entity.SportDetail;
import se331.rest.repository.SportDetailRepository;

import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class SportDetailDaoImpl implements SportDetailDao {
    final SportDetailRepository sportDetailRepository;


    @Override
    public Page<SportDetail> getSports(Pageable pageRequest) {
        return sportDetailRepository.findAll(pageRequest);
    }

    @Override
    public SportDetail getSportById(Long id) {
        return sportDetailRepository.findById(id).orElse(null);
    }

    @Override
    public SportDetail saveSport(SportDetail sport) {
        return sportDetailRepository.save(sport);
    }

    @Override
    public void deleteSport(Long id) {
        sportDetailRepository.deleteById(id);

    }
}
