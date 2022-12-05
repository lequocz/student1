package com.example.demo2.controller;

import com.example.demo2.model.ClassYB;
import com.example.demo2.model.Student;
import com.example.demo2.repository.ClassRepository;
import com.example.demo2.service.ClassYbService;
import com.example.demo2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/save")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
    @Autowired
    ClassYbService classYbService;
    @PostMapping("/saveClass")
    public ResponseEntity<?> createStudent(@RequestBody ClassYB classYB) {
        return classYbService.creatClass(classYB) ;
    }
    @GetMapping("/listClass")
    public ResponseEntity<?> listClass() {
        return classYbService.viewClass() ;
    }
    @GetMapping("/findStudent")
    public ResponseEntity<?> findStudentById(@RequestParam("abcx")int id ) {
        return studentService.findStudentById(id) ;
    }
    @GetMapping("/deleteStudent")
    public ResponseEntity<?> deleteStudentById(@RequestParam("abcx")int id ) {
        return studentService.deleteStudentById(id) ;
    }
    @PostMapping("/updateStudent")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
}
