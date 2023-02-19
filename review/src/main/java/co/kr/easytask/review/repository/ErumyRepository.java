package co.kr.easytask.review.repository;

import co.kr.easytask.review.domain.Erumy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class ErumyRepository {

    private final EntityManager entityManager;

    public void save(Erumy erumy) {
        entityManager.persist(erumy);
    }

    public Erumy findOne(Long erumyId) {
        return entityManager.find(Erumy.class, erumyId);
    }


}
