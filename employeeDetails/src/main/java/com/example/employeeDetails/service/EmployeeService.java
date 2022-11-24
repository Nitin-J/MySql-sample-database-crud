package com.example.employeeDetails.service;

import com.example.employeeDetails.entity.EmployeeDTO;
import com.example.employeeDetails.entity.EmployeeModelMongo;
import com.example.employeeDetails.exception.userNotFoundException;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getEmployees();

    List<EmployeeDTO> getLimitedEmployees() throws userNotFoundException;

    List<EmployeeDTO> getByGender();

    void saveData() throws userNotFoundException;

    List<EmployeeModelMongo> getData();

    void deleteAll();
}
