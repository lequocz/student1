package com.example.demo2.service.impl;

import com.example.demo2.model.Student;
import com.example.demo2.repository.StudentRepository;
import com.example.demo2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public ResponseEntity createStudent(Student student){
        studentRepository.save(student);
        return new ResponseEntity(student, HttpStatus.OK);
    }
    @Override
    public ResponseEntity createStudent2(Student student){
         studentRepository.create(student.getId(),student.getName(),student.getAge(),student.getClassId(),student.getScoreId());
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @Override
    public ResponseEntity findStudentById(int id) {
        Student student;
        student = studentRepository.findById(id);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteStudentById(int id) {
        studentRepository.delete(studentRepository.findById(id));
        return new ResponseEntity(studentRepository.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateStudent(Student student) {
        Student student1;
        student1 = studentRepository.findById(student.getId());
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setClassId(student.getClassId());
        student1.setScoreId(student.getScoreId());
        return new ResponseEntity(student1, HttpStatus.OK);
    }

}
