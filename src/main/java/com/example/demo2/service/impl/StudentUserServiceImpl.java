package com.example.demo2.service.impl;

import com.example.demo2.model.StudentUser;
import com.example.demo2.repository.StudentUserRepo;
import com.example.demo2.service.StuUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StudentUserServiceImpl implements StuUserService {
    @Autowired
    StudentUserRepo studentUserRepo;
    @Override
    public Optional<StudentUser> getStudentUserByUserName(String username) {
        return studentUserRepo.getStudentUserByUsername(username);
    }

    @Override
    public Boolean exitsAllByUsername(String username) {
        return studentUserRepo.existsAllByUsername(username);
    }
}
