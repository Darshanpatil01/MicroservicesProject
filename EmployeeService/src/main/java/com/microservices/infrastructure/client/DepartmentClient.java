package com.microservices.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.application.dto.DepartmentResponse;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {

    @GetMapping("/api/departments/{id}")
    DepartmentResponse getDepartmentById(
            @PathVariable("id") Long id
    );
}