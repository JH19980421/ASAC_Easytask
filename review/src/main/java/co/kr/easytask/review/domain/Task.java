package co.kr.easytask.review.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "task_name", nullable = false, length = 100)
    private String name;

    @Column(name = "task_category")
    private String category;

    @Column(name = "task_category_detail")
    private String categoryDetail;

    @Column(name = "task_ability")
    private String ability;

    @Column(name = "task_ability_detail")
    private String abilityDetail;

    @Column(name = "task_program")
    private String program;

    @Column(name = "task_status")
    private TaskStatus taskStatus;
}
