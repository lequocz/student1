package com.example.demo2.repository;

import com.example.demo2.model.StudentUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentUserRepo extends JpaRepository<StudentUser,Integer> {
    Optional<StudentUser> getStudentUserByUsername(String username);
    Boolean existsAllByUsername(String username);

}
