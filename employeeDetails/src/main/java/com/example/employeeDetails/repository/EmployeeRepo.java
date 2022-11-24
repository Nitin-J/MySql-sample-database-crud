package com.example.employeeDetails.repository;

import com.example.employeeDetails.entity.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel, Integer> {

}
