package se331.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.rest.DAO.SportDetailDao;
import se331.rest.entity.SportDetail;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SportDetailServiceImpl implements SportDetailService {
    final SportDetailDao sportDetailDao;


    @Override
    public Page<SportDetail> getSports(Pageable pageRequest) {
        return sportDetailDao.getSports(pageRequest);
    }

    @Override
    public SportDetail getSportById(Long id) {
        return sportDetailDao.getSportById(id);
    }

    @Override
    public SportDetail saveSport(SportDetail sport) {
        return sportDetailDao.saveSport(sport);
    }

    @Override
    public void deleteSport(Long id) {
        sportDetailDao.deleteSport(id);
    }
}
