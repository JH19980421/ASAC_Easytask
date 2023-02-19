package co.kr.easytask.review.domain;

import co.kr.easytask.review.repository.TaskRepository;
import co.kr.easytask.review.repository.UserRepository;
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
public class TaskTest {

    @Autowired
    TaskRepository taskRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;
    @Autowired
    EntityManager entityManager;

    @Test
    public void 업무_생성() throws Exception {
        //given
        User user = new User("최종호", "01085738206");
        Long userId = userService.createUser(user);
        Task task = new Task("번역 업무","번역","영어","영어실력","토익","WORD");

        //when
        task.setUser(user);
        Long taskId = taskService.createTask(task);

        //then
        assertEquals(task, taskRepository.findOne(taskId));
        assertEquals(user, userRepository.findOne(userId));
        assertEquals(userId, task.getUser().getId());
        assertEquals(user, task.getUser());

    }
}