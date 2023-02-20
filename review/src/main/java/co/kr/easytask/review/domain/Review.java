package co.kr.easytask.review.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    @GeneratedValue
    @Column(name = "review_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "erumy_id", nullable = false)
    private Erumy erumy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(name = "review_text", nullable = false)
    private String text;

    @Column(name = "review_ability")
    private int ability;

    @Column(name = "review_program")
    private int program;

    @Column(name = "review_individual")
    private int individual;

    @Enumerated(EnumType.STRING)
    @Column(name = "review_recommend", nullable = false)
    private ReviewStatus recommend = ReviewStatus.DEPRECATED;

    @Enumerated(EnumType.STRING)
    @Column(name = "review_status", nullable = false)
    private ReviewStatus status = ReviewStatus.ACTIVE;

    public Review(String text, int ability, int program, int individual) {
        this.text = text;
        this.ability = ability;
        this.program = program;
        this.individual = individual;
    }

    public void setErumy(Erumy erumy) {
        this.erumy = erumy;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public void recommendReview() {
        this.recommend = ReviewStatus.RECOMMEND;
    }

    public void delete() {
        this.status = ReviewStatus.INACTIVE;
    }

}
