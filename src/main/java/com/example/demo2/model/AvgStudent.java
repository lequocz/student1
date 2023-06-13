package com.example.demo2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedStoredProcedureQuery(name="AvgStudent.revenue_student",procedureName = "revenue_student",
resultClasses = AvgStudent.class,parameters = {
        @StoredProcedureParameter(name = "stuId",type = String.class,mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "average",type = String.class,mode = ParameterMode.OUT)
})
public class AvgStudent {
    @Id
    private String average ;
}
