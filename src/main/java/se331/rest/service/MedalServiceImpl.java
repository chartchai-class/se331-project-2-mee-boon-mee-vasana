package se331.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.rest.DAO.MedalDao;
import se331.rest.entity.Medal;
import se331.rest.repository.MedalRepository;

@Service
@RequiredArgsConstructor
public class MedalServiceImpl implements MedalService {
final MedalDao medalDao;
    @Override
    public Page<Medal> getMedals(Pageable pageable) {
        return medalDao.getMedals(pageable);
    }

    @Override
    public Medal saveMedal(Medal medal) {
        return medalDao.saveMedal(medal);
    }

    @Override
    public void deleteMedal(Long id) {
        medalDao.deleteMedal(id);
    }
}
