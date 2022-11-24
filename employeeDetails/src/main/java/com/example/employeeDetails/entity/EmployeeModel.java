package com.example.employeeDetails.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_no", nullable = false)
    private Integer emp_no;

    @Column
    private LocalDateTime birth_date;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String gender;

    @Column
    private LocalDateTime hire_date;

}
