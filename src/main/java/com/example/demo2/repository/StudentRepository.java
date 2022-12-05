package com.example.demo2.repository;

import com.example.demo2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Transactional
    @Modifying
    @Query(value = "insert into student (id,age, class_id, name, score_id) values (:id,:age,:classId,:name,:scoreId)",nativeQuery = true)
    void create (@Param("id") int id,@Param("name") String name,@Param("age") int age,@Param("classId") int classId,@Param("scoreId") int scoreId);
    @Query(value = "select * from student s where s.id =?1",nativeQuery = true)
    Student findById(int id);
}
