package com.example.demo2.service;

import org.springframework.http.ResponseEntity;

public interface DetailStudentService {
    ResponseEntity findStudentById(int id);
}
