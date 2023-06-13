package com.example.demo2.service;

import com.example.demo2.model.StudentUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface StuUserService {
    Optional<StudentUser> getStudentUserByUserName(String username);
    Boolean exitsAllByUsername(String username);
}
