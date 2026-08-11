package com.microservices.application.dto;

public class EmployeeResponse {

    private Long id;

    private String name;

    private String email;

    private Double salary;

    private Long departmentId;

    private DepartmentResponse department;

    public EmployeeResponse() {
    }

    public EmployeeResponse(
            Long id,
            String name,
            String email,
            Double salary,
            Long departmentId,
            DepartmentResponse department) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.departmentId = departmentId;
        this.department = department;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public DepartmentResponse getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentResponse department) {
        this.department = department;
    }
}