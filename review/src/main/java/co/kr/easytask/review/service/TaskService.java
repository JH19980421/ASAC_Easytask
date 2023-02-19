package co.kr.easytask.review.service;

import co.kr.easytask.review.domain.Task;
import co.kr.easytask.review.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    public Long createTask(Task task) {
        taskRepository.save(task);
        return task.getId();
    }

    public List<Task> findTasksByUserId(Long userId) {
        return taskRepository.findAllByUserId(userId);
    }

    public Task findOne(Long taskId) {
        return taskRepository.findOne(taskId);
    }

    public void cancelTask(Long taskId) {
        Task task = taskRepository.findOne(taskId);
        task.cancel();
    }

    public void doneTask(Long taskId) {
        Task task = taskRepository.findOne(taskId);
        task.done();
    }
}
