package com.example.javatechtask.models.repository;

import com.example.javatechtask.models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findByFirstName(String name);
}
