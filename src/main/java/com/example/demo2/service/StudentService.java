package com.example.demo2.service;

import com.example.demo2.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

public interface StudentService {
    ResponseEntity createStudent(Student student);
    ResponseEntity createStudent2(Student student);
    ResponseEntity findStudentById(int id);
    ResponseEntity deleteStudentById(int id);
    ResponseEntity updateStudent(Student student);
    ResponseEntity viewStudent();
}
