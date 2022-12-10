package com.example.demo2.service.impl;

import com.example.demo2.repository.DetailStudentRepository;
import com.example.demo2.repository.StudentRepository;
import com.example.demo2.service.DetailStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DetailStudentServiceIml implements DetailStudentService {
    @Autowired
    DetailStudentRepository detailStudentRepository;
    @Override
    public ResponseEntity findStudentById(int id) {
        return new ResponseEntity(detailStudentRepository.findById(id), HttpStatus.OK);
    }
}
