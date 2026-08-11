package com.microservices.application.service;

import java.util.List;

import com.microservices.application.dto.EmployeeRequest;
import com.microservices.application.dto.EmployeeResponse;

public interface IEmployeeService {

    EmployeeResponse createEmployee(
            EmployeeRequest request
    );

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(
            Long id
    );

    EmployeeResponse updateEmployee(
            Long id,
            EmployeeRequest request
    );

    void deleteEmployee(
            Long id
    );
}