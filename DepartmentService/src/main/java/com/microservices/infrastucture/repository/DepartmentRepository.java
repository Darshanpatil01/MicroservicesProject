package com.microservices.infrastucture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.domain.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}