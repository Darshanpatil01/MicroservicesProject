package com.microservice.application.service;

import com.microservice.application.dto.response.EmployeeResponse;

public interface EmployeeLookup {

    EmployeeResponse getEmployeeById(Long id);

}