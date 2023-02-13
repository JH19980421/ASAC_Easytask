package co.kr.easytask.review.repository;

import co.kr.easytask.review.domain.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepository {

    private final EntityManager entityManager;

    public void save(Review review) {
        entityManager.persist(review);
    }

    public Review findOne(Long reviewId) {
        return entityManager.find(Review.class, reviewId);
    }

    public List<Review> findAllByUserId(Long userId) {
        return entityManager.createQuery("select r from Review r where r.user_id = :user_id", Review.class)
                .setParameter("user_id", userId).getResultList();
    }
}
