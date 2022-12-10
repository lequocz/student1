package com.example.demo2.repository;

import com.example.demo2.model.DetailStudent;
import com.example.demo2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface DetailStudentRepository extends JpaRepository<DetailStudent,Integer> {
    @Transactional
    @Query(value = "select * from detail_student  where student_id=?1",nativeQuery = true)
    DetailStudent findById(int id);
}
