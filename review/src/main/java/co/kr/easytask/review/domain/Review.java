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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "erumy_id")
    private Erumy erumy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "review_text")
    private String text;

    @Column(name = "review_ability")
    private int ability;

    @Column(name = "review_program")
    private int program;

    @Column(name = "review_individual")
    private int individual;

    @Enumerated(EnumType.STRING)
    @Column(name = "review_recommend")
    private ReviewStatus recommend;

    @Enumerated(EnumType.STRING)
    @Column(name = "review_status")
    private ReviewStatus status;

    public Review(String text, int ability, int program, int individual) {
        this.text = text;
        this.ability = ability;
        this.program = program;
        this.individual = individual;
        this.recommend = ReviewStatus.DEPRECATED;
        this.status = ReviewStatus.ACTIVE;
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
