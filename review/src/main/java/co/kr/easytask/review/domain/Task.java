package co.kr.easytask.review.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "task_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "task_name", nullable = false, length = 100)
    private String name;

    @Column(name = "task_category", nullable = false)
    private String category;

    @Column(name = "task_category_detail", nullable = false)
    private String categoryDetail;

    @Column(name = "task_ability", nullable = false)
    private String ability;

    @Column(name = "task_ability_detail", nullable = false)
    private String abilityDetail;

    @Column(name = "task_program", nullable = false)
    private String program;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status", nullable = false)
    private TaskStatus taskStatus;

    public Task(String name, String category, String categoryDetail, String ability, String abilityDetail, String program) {
        this.name = name;
        this.category = category;
        this.categoryDetail = categoryDetail;
        this.ability = ability;
        this.abilityDetail = abilityDetail;
        this.program = program;
        this.taskStatus = TaskStatus.ACTIVE;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void cancel() {
        this.taskStatus = TaskStatus.CANCEL;
    }

    public void done() {
        this.taskStatus = TaskStatus.DONE;
    }
}
