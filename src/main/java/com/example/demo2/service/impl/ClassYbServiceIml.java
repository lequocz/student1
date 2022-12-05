package com.example.demo2.service.impl;

import com.example.demo2.model.ClassYB;
import com.example.demo2.repository.ClassRepository;
import com.example.demo2.service.ClassYbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassYbServiceIml implements ClassYbService {
    @Autowired
    ClassRepository classRepository;
    @Override
    public ResponseEntity creatClass(ClassYB classYB) {
        classRepository.save(classYB);
        return new ResponseEntity(classYB, HttpStatus.OK);
    }

    @Override
    public ResponseEntity viewClass() {
        List<ClassYB> classYBS = classRepository.findAll();
        return new ResponseEntity(classYBS, HttpStatus.OK);
    }
}
