package com.example.employeeDetails.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO implements Comparable<EmployeeDTO> {

    @Id
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

    @Override
    public int compareTo(EmployeeDTO employeeDTO) {
        return this.first_name.compareTo(employeeDTO.first_name);
    }

}
