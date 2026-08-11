package com.microservices.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.microservices.application.dto.DepartmentResponse;
import com.microservices.application.dto.EmployeeRequest;
import com.microservices.application.dto.EmployeeResponse;
import com.microservices.domain.entity.Employee;
import com.microservices.infrastructure.client.DepartmentClient;
import com.microservices.infrastructure.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentClient departmentClient;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository,
            DepartmentClient departmentClient) {

        this.employeeRepository = employeeRepository;
        this.departmentClient = departmentClient;
    }


    @Override
    public EmployeeResponse createEmployee(
            EmployeeRequest request) {

        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary());
        employee.setDepartmentId(request.getDepartmentId());

        Employee savedEmployee =
                employeeRepository.save(employee);

        return convertToResponse(savedEmployee);
    }

    // ==========================================
    // GET ALL EMPLOYEES
    // ==========================================

    @Override
    public List<EmployeeResponse> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    // ==========================================
    // GET EMPLOYEE BY ID
    // ==========================================

    @Override
    public EmployeeResponse getEmployeeById(Long id) {

        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Employee not found with id: "
                                                + id
                                )
                        );

        return convertToResponse(employee);
    }

    // ==========================================
    // UPDATE EMPLOYEE
    // ==========================================

    @Override
    public EmployeeResponse updateEmployee(
            Long id,
            EmployeeRequest request) {

        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Employee not found with id: "
                                                + id
                                )
                        );

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary());
        employee.setDepartmentId(request.getDepartmentId());

        Employee updatedEmployee =
                employeeRepository.save(employee);

        return convertToResponse(updatedEmployee);
    }

    // ==========================================
    // DELETE EMPLOYEE
    // ==========================================

    @Override
    public void deleteEmployee(Long id) {

        Employee employee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Employee not found with id: "
                                                + id
                                )
                        );

        employeeRepository.delete(employee);
    }

    // ==========================================
    // CONVERT ENTITY TO RESPONSE
    // ==========================================

    private EmployeeResponse convertToResponse(
            Employee employee) {

        DepartmentResponse department = null;

        if (employee.getDepartmentId() != null) {

            department =
                    departmentClient.getDepartmentById(
                            employee.getDepartmentId()
                    );
        }

        return new EmployeeResponse(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getSalary(),
                employee.getDepartmentId(),
                department
        );
    }
}