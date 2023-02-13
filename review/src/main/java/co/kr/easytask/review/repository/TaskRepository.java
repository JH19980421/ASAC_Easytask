package co.kr.easytask.review.repository;


import co.kr.easytask.review.domain.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskRepository {

    private final EntityManager entityManager;

    public void save(Task task) {
        entityManager.persist(task);
    }

    public Task findOne(Long taskId) {
        return entityManager.find(Task.class, taskId);
    }

    public List<Task> findAllByUserId(Long userId) {
        return entityManager.createQuery("select t from Task t where t.user_id = :user_id", Task.class)
                .setParameter("user_id", userId).getResultList();
    }
}
