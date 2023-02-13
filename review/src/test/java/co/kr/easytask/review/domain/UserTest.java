package co.kr.easytask.review.domain;

import co.kr.easytask.review.repository.UserRepository;
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
public class UserTest {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    EntityManager entityManager;

    @Test
    public void 유저생성() throws Exception {
        //given
        User user = new User("최종호","01085738206");

        //when
        Long saveId = userService.createUser(user);

        //then
        assertEquals(user, userRepository.findOne(saveId));
    }
}