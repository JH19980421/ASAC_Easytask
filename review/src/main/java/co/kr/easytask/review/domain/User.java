package co.kr.easytask.review.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_phone")
    private String phone;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();

    public User (String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
}
