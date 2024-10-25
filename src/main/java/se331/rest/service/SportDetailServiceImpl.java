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
    public List<SportDetail> getAllSportDetails() {
        return sportDetailDao.getSportDetail(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<SportDetail> getSportDetails(Integer page, Integer pageSize) {
        return sportDetailDao.getSportDetail(PageRequest.of(page, pageSize));
    }
}
