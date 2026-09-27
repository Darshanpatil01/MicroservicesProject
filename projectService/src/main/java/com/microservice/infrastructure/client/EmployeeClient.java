package com.microservice.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.application.dto.response.EmployeeResponse;

@FeignClient(name = "EMPLOYEE-SERVICE")
public interface EmployeeClient {

    @GetMapping("/api/employees/{id}")
    EmployeeResponse getEmployeeById(
            @PathVariable("id") Long id
    );

}