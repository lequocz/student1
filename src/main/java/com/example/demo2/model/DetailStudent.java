package com.example.demo2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetailStudent   {
    @Id
    @Column(name = "student_id", nullable = false)
    private int studentId;
    private String address;
    private long phoneNumber;
    private float mathScore;
    private float englishScore;

}

