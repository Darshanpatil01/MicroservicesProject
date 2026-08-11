package com.microservices.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.domain.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}