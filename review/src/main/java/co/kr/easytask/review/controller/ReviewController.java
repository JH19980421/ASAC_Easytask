package co.kr.easytask.review.controller;

import co.kr.easytask.review.domain.Erumy;
import co.kr.easytask.review.domain.Review;
import co.kr.easytask.review.domain.Task;
import co.kr.easytask.review.service.ErumyService;
import co.kr.easytask.review.service.ReviewService;
import co.kr.easytask.review.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final TaskService taskService;
    private final ErumyService erumyService;

    @PostMapping("/{erumyId}/{taskId}")
    public void createReview(@PathVariable("erumyId") Long erumyId, @PathVariable("taskId") Long taskId, @RequestBody Review review) {
        Erumy erumy = erumyService.findOne(erumyId);
        Task task = taskService.findOne(taskId);
        review.setErumy(erumy);
        review.setTask(task);

        Long reviewId = reviewService.createReview(review);

        System.out.println(reviewId);
    }

    @GetMapping("/{userId}")
    public void getReviewsByUserId(@PathVariable("userId") Long userId) {
        List<Review> userReviews = reviewService.findReviewsByUserId(userId);

        System.out.println(userReviews);
    }
}
