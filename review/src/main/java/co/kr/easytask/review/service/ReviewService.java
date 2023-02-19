package co.kr.easytask.review.service;

import co.kr.easytask.review.domain.Erumy;
import co.kr.easytask.review.domain.Review;
import co.kr.easytask.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional
    public Long createReview(Review review) {
        reviewRepository.save(review);
        return review.getId();
    }

    public List<Review> findReviewsByUserId(Long userId) {
        return reviewRepository.findAllByUserId(userId);
    }

    public void deleteReview(Long reviewId) {
        Review review = reviewRepository.findOne(reviewId);
        review.delete();
    }

}
