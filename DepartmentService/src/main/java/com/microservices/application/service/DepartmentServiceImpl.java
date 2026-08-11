package com.microservices.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.microservices.application.dto.DepartmentRequest;
import com.microservices.application.dto.DepartmentResponse;
import com.microservices.domain.entity.Department;
import com.microservices.infrastucture.repository.*;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentResponse createDepartment(DepartmentRequest request) {

        Department department = new Department();

        department.setName(request.getName());
        department.setLocation(request.getLocation());

        Department savedDepartment = departmentRepository.save(department);

        return convertToResponse(savedDepartment);
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Department not found with id: " + id));

        return convertToResponse(department);
    }

    @Override
    public DepartmentResponse updateDepartment(
            Long id,
            DepartmentRequest request) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Department not found with id: " + id));

        department.setName(request.getName());
        department.setLocation(request.getLocation());

        Department updatedDepartment = departmentRepository.save(department);

        return convertToResponse(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Department not found with id: " + id));

        departmentRepository.delete(department);
    }

    private DepartmentResponse convertToResponse(Department department) {

        return new DepartmentResponse(
                department.getId(),
                department.getName(),
                department.getLocation()
        );
    }
}