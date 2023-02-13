package co.kr.easytask.review.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
public class Erumy {

    @Id
    @GeneratedValue
    @Column(name = "erumy_id")
    private Long id;

    @Column(name = "erumy_name")
    private String name;


}
