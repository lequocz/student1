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
@Table( name = "classyb")
public class ClassYB {
    @Id
    @Column(name = "classid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int classId;
    @Column(name = "classname")
    private String className;
}
