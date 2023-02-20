package co.kr.easytask.review.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Erumy {

    @Id
    @GeneratedValue
    @Column(name = "erumy_id")
    private Long id;

    @Column(name = "erumy_name", nullable = false)
    private String name;


    public Erumy(String name) {
        this.name = name;
    }

}
