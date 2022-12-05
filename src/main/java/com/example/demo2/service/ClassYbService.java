package com.example.demo2.service;

import com.example.demo2.model.ClassYB;
import com.example.demo2.repository.ClassRepository;
import org.springframework.http.ResponseEntity;

public interface ClassYbService {
    ResponseEntity creatClass(ClassYB classYB);
    ResponseEntity viewClass();
}
