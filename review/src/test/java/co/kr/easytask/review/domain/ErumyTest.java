package co.kr.easytask.review.domain;

import co.kr.easytask.review.repository.ErumyRepository;
import co.kr.easytask.review.service.ErumyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ErumyTest {

    @Autowired
    ErumyService erumyService;
    @Autowired
    ErumyRepository erumyRepository;

    @Test
    public void 이루미_생성() {
        Erumy erumy = new Erumy("이루미");

        Long erumyId = erumyService.createErumy(erumy);

        assertEquals(erumy, erumyRepository.findOne(erumyId));
    }
}