package com.example.employeeDetails.repository;

import com.example.employeeDetails.entity.EmployeeModelMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepos extends MongoRepository<EmployeeModelMongo,String> {
}
