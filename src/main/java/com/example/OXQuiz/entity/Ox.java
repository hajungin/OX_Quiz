package com.example.OXQuiz.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class Ox {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String detail;

    @Column(length = 3, nullable = false)
    private String answer;

    @Column(length = 10, nullable = false)
    private String name;




}
