package com.example.demo2.repository;

import com.example.demo2.model.Score;
import com.example.demo2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ScoreRepository extends JpaRepository<Score,Integer> {

}
