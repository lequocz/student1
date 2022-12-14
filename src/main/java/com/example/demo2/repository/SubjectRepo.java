package com.example.demo2.repository;

import com.example.demo2.model.Score;
import com.example.demo2.model.Student;
import com.example.demo2.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,Integer> {
    @Query(value = "select subject_name from subject ",nativeQuery = true)
    List<String> subName();
}

