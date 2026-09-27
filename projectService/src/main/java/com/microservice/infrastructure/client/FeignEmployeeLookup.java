package com.microservice.infrastructure.client;

import org.springframework.stereotype.Component;

import com.microservice.application.dto.response.EmployeeResponse;
import com.microservice.application.service.EmployeeLookup;

@Component
public class FeignEmployeeLookup implements EmployeeLookup {

    private final EmployeeClient employeeClient;

    public FeignEmployeeLookup(EmployeeClient employeeClient) {
        this.employeeClient = employeeClient;
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {

        return employeeClient.getEmployeeById(id);
    }
}