package co.kr.easytask.review.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Erumy {

    @Id
    @GeneratedValue
    @Column(name = "erumy_id")
    private Long id;

    @Column(name = "erumy_name")
    private String name;


    public Erumy(String name) {
        this.name = name;
    }


}
