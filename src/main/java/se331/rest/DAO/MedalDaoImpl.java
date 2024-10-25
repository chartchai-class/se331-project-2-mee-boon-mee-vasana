package se331.rest.DAO;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.rest.entity.Medal;
import se331.rest.repository.MedalRepository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class MedalDaoImpl implements MedalDao {
    final MedalRepository medalRepository;

    @Override
    public Page<Medal> getMedals(Pageable pageable) {
        return medalRepository.findAll(pageable);
    }
//
//    @Override
//    public List<Medal> getMedalsByCountry(Long countryId) {
//        return medalRepository;
//    }

    @Override
    public Medal saveMedal(Medal medal) {
        return medalRepository.save(medal);
    }

    @Override
    public void deleteMedal(Long id) {
       medalRepository.deleteById(id);
    }

    @Override
    public List<Medal> getAllMedals() {
        return medalRepository.findAll();
    }
}
