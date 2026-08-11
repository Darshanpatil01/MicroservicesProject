package com.microservices.application.service;

import java.util.List;

import com.microservices.application.dto.DepartmentRequest;
import com.microservices.application.dto.DepartmentResponse;

public interface IDepartmentService {

    DepartmentResponse createDepartment(DepartmentRequest request);

    List<DepartmentResponse> getAllDepartments();

    DepartmentResponse getDepartmentById(Long id);

    DepartmentResponse updateDepartment(Long id, DepartmentRequest request);

    void deleteDepartment(Long id);
}