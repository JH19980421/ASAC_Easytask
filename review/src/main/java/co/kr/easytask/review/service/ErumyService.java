package co.kr.easytask.review.service;

import co.kr.easytask.review.domain.Erumy;
import co.kr.easytask.review.repository.ErumyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ErumyService {

    private final ErumyRepository erumyRepository;

    @Transactional
    public Long createErumy(Erumy erumy) {
        erumyRepository.save(erumy);
        return erumy.getId();
    }

    public Erumy findOne(Long erumyId) {
        return erumyRepository.findOne(erumyId);
    }

}
