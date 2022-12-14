package com.example.demo2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int scoreId;
    private int id;
    private int subject_id;
    private int score15p1;
    private int score15p2;
    private int score15p3;
    private int score45p1;
    private int score45p2;
    private int score45p3;
    private int score_final1;
    private int score_final2;
    private int score_finally;

}
