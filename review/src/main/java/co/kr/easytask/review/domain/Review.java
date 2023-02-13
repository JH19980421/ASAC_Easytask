package co.kr.easytask.review.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    @Column(name = "review_user")
    private Long userId;

    @Column(name = "review_erumy")
    private Long erumyId;

    @Column(name = "review_task")
    private Long taskId;

    @Column(name = "review_text")
    private String text;

    @Column(name = "review_ability")
    private int ability;

    @Column(name = "review_program")
    private int program;

    @Column(name = "review_individual")
    private int individual;

    @Column(name = "review_recommend")
    private String recommend;

    @Enumerated(EnumType.STRING)
    @Column(name = "review_status")
    private ReviewStatus status;

    public Review(Long userId, Long erumyId, Long taskId, String text, int ability, int program, int individual) {
        this.userId = userId;
        this.erumyId = erumyId;
        this.taskId = taskId;
        this.text = text;
        this.ability = ability;
        this.program = program;
        this.individual = individual;
        this.recommend = null;
        this.status = ReviewStatus.ACTIVE;
    }

}
