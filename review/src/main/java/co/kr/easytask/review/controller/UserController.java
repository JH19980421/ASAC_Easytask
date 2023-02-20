package co.kr.easytask.review.controller;

import co.kr.easytask.review.domain.User;
import co.kr.easytask.review.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/users")
public class UserController {

    private final UserService userService;

    @ResponseBody
    @PostMapping("")
    public void createUser(@RequestBody User user) {
        Long userId = userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public void getUser(@PathVariable("userId") Long userId) {
        User user = userService.findOne(userId);
        System.out.println(user);
    }

    @GetMapping("")
    public void getUsers() {
        userService.findAll();
    }


}
