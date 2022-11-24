package com.example.employeeDetails.controller;

import com.example.employeeDetails.entity.EmployeeDTO;
import com.example.employeeDetails.entity.EmployeeModelMongo;
import com.example.employeeDetails.exception.userNotFoundException;
import com.example.employeeDetails.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/employees")
public class Controller {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping
    public List<EmployeeDTO> getAllEmployee() throws userNotFoundException {
        return employeeService.getEmployees();
    }

    @GetMapping("/limited")
    public List<EmployeeDTO> getEmployees() throws userNotFoundException {
        return employeeService.getLimitedEmployees();
    }
    @GetMapping("/limited/byGender")
    public List<EmployeeDTO> getGender(){
        return employeeService.getByGender();
    }

    @GetMapping ("/saveData")
    public void getData() throws userNotFoundException {
         employeeService.saveData();
    }

    @GetMapping("/getAll")
    List<EmployeeModelMongo> getAll(){
        return employeeService.getData();
    }

    @DeleteMapping("/deleteAll")
    public void delete(){
        employeeService.deleteAll();
    }

}