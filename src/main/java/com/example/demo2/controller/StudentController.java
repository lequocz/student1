package com.example.demo2.controller;

import com.example.demo2.model.ClassYB;
import com.example.demo2.model.Student;
import com.example.demo2.repository.ClassRepository;
import com.example.demo2.service.ClassYbService;
import com.example.demo2.service.DetailStudentService;
import com.example.demo2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
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
    @GetMapping("/listStudent")
    public ResponseEntity<?> listStudent() {
        return studentService.viewStudent() ;
    }
    @GetMapping("/findStudent")
    public ResponseEntity<?> findStudentById(@RequestParam("id")int id ) {
        return studentService.findStudentById(id) ;
    }
    @GetMapping("/deleteStudent")
    public ResponseEntity<?> deleteStudentById(@RequestParam("id")int id ) {
        return studentService.deleteStudentById(id) ;
    }
    @PostMapping("/updateStudent")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
    @Autowired
    DetailStudentService detailStudentService;
    @GetMapping("/detailStudent")
    public ResponseEntity<?> detailStudentById(@RequestParam("id")int id ) {
        return detailStudentService.findStudentById(id) ;
    }
}
