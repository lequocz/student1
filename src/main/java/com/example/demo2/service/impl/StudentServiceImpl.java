package com.example.demo2.service.impl;

import com.example.demo2.model.Student;
import com.example.demo2.model.TestSch;
import com.example.demo2.repository.StudentRepository;
import com.example.demo2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    WebClient.Builder webClientBuilder;
    @Override
    public ResponseEntity createStudent(Student student){
        studentRepository.save(student);
        return new ResponseEntity(student, HttpStatus.OK);
    }
    @Override
    public ResponseEntity createStudent2(Student student){
         studentRepository.create(student.getId(),student.getName(),student.getAge(),student.getClassId());
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @Override
    public ResponseEntity findStudentById(int id) {
        return new ResponseEntity(studentRepository.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteStudentById(int id) {
        studentRepository.delete(studentRepository.findById(id));
        return new ResponseEntity(studentRepository.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateStudent(Student student) {
        studentRepository.save(student);
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @Override
    public ResponseEntity viewStudent() {
        return new ResponseEntity(studentRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity getSchStudent(int id) {
        TestSch testSch =webClientBuilder.build().get().uri("localhost:8081/school/findbyid?id="+id)
                .retrieve()
                .bodyToMono(TestSch.class)
                .block();

        return new ResponseEntity(testSch,HttpStatus.OK);
    }

    @Override
    public ResponseEntity getListSchStudent() {
        Mono<TestSch[]> response = webClientBuilder.build().get()
                .uri("localhost:8081/school/getall")
                .retrieve()
                .bodyToMono(TestSch[].class).log();
        TestSch[] readers = response.block();
        List<TestSch> testSches = Arrays.asList(readers);
//        return Arrays.stream(readers)
//                .map(TestSch::getFavouriteBook)
//  .collect(Collectors.toList());

        return new ResponseEntity(testSches,HttpStatus.OK);
    }


}
