package com.mysite.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment와 동일
    private Integer id;
    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;


    private LocalDateTime createTime;


    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    public void setCreateDate(LocalDateTime now) {
    }
}
