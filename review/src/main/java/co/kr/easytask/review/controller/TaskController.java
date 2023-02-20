package co.kr.easytask.review.controller;

import co.kr.easytask.review.domain.Task;
import co.kr.easytask.review.domain.User;
import co.kr.easytask.review.repository.UserRepository;
import co.kr.easytask.review.service.TaskService;
import co.kr.easytask.review.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("app/tasks")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    @PostMapping("/{userId}")
    public void createTask(@PathVariable("userId") Long userId, @RequestBody Task task) {
        User user = userService.findOne(userId);
        task.setUser(user);
        Long taskId = taskService.createTask(task);
        System.out.println(taskService.findOne(taskId));
    }

    @GetMapping("/{taskId}")
    public void getTask(@PathVariable("taskId") Long taskId) {
        Task task = taskService.findOne(taskId);
        System.out.println(task);
    }

    @GetMapping("/list/{userId}")
    public void getTasksByUserId(@PathVariable("userId") Long userId) {
        taskService.findTasksByUserId(userId);
    }
}
