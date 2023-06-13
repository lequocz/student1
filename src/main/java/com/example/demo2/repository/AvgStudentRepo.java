package com.example.demo2.repository;

import com.example.demo2.model.AvgStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface AvgStudentRepo extends JpaRepository<AvgStudent, String> {
    @Procedure(name = "AvgStudent.revenue_student")
    AvgStudent revenue_student(@Param("stuId")String stuId);

}
