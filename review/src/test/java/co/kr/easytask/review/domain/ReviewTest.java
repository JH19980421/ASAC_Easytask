package co.kr.easytask.review.domain;

import co.kr.easytask.review.repository.ErumyRepository;
import co.kr.easytask.review.repository.ReviewRepository;
import co.kr.easytask.review.repository.TaskRepository;
import co.kr.easytask.review.repository.UserRepository;
import co.kr.easytask.review.service.ErumyService;
import co.kr.easytask.review.service.ReviewService;
import co.kr.easytask.review.service.TaskService;
import co.kr.easytask.review.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ReviewTest {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ErumyRepository erumyRepository;
    @Autowired
    ReviewService reviewService;
    @Autowired
    TaskService taskService;
    @Autowired
    UserService userService;
    @Autowired
    ErumyService erumyService;
    @Autowired
    EntityManager entityManager;

    @Test
    public void 리뷰_생성() {
        //given
        User user = new User("최종호","01085738206");
        Long userId = userService.createUser(user);

        Task task = new Task("번역 업무","번역","영어","영어실력","토익","WORD");
        task.setUser(user);
        Long taskId = taskService.createTask(task);

        Erumy erumy = new Erumy("이루미");
        Long erumyId = erumyService.createErumy(erumy);

        Review review = new Review("친절한 설명이 좋아요.",5, 5,5);

        //when
        review.setErumy(erumy);
        review.setTask(task);
        Long reviewId = reviewService.createReview(review);

        //then
        assertEquals(review, reviewRepository.findOne(reviewId));
        assertEquals(erumy, review.getErumy());
        assertEquals(task, review.getTask());
        assertEquals(erumyId, review.getErumy().getId());
        assertEquals(taskId, review.getTask().getId());
        assertEquals(user, review.getTask().getUser());
        assertEquals(userId, review.getTask().getUser().getId());
    }
}