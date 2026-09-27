package com.microservice.application.dto.response;

import java.time.LocalDate;

public class ProjectResponse {

    private Long id;
    private String name;
    private String description;
    private Long employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    private EmployeeResponse employee;

    public ProjectResponse() {
    }

    public ProjectResponse(
            Long id,
            String name,
            String description,
            Long employeeId,
            LocalDate startDate,
            LocalDate endDate,
            String status) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmployeeResponse getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeResponse employee) {
        this.employee = employee;
    }
}