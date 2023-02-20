package co.kr.easytask.review.controller;


import co.kr.easytask.review.domain.Erumy;
import co.kr.easytask.review.service.ErumyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/erumies")
public class ErumyController {

    private final ErumyService erumyService;

    @PostMapping("")
    public void createErumy(@RequestBody Erumy erumy) {
        Long erumyId = erumyService.createErumy(erumy);
        System.out.println(erumyId);
    }
}
