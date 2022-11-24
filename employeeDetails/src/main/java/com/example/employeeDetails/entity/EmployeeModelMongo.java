package com.example.employeeDetails.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("EmployeeRecord")
public class EmployeeModelMongo {

    @Id
    @Indexed(unique=true)
    private ObjectId emp_no;

    private LocalDateTime birth_date;

    private String first_name;

    private String last_name;

    private String gender;

    private LocalDateTime hire_date;

}
