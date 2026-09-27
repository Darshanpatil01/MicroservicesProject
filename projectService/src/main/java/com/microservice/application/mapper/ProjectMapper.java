package com.microservice.application.mapper;

import com.microservice.application.dto.request.ProjectRequest;
import com.microservice.application.dto.response.EmployeeResponse;
import com.microservice.application.dto.response.ProjectResponse;
import com.microservice.domain.entity.Project;

public class ProjectMapper {

    private ProjectMapper() {
    }

    public static Project toEntity(ProjectRequest request) {

        Project project = new Project();

        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setEmployeeId(request.getEmployeeId());
        project.setStartDate(request.getStartDate());
        project.setEndDate(request.getEndDate());
        project.setStatus(request.getStatus());

        return project;
    }

    public static ProjectResponse toResponse(Project project) {

        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getEmployeeId(),
                project.getStartDate(),
                project.getEndDate(),
                project.getStatus()
        );
    }

    public static ProjectResponse toResponse(
            Project project,
            EmployeeResponse employee) {

        ProjectResponse response = toResponse(project);

        response.setEmployee(employee);

        return response;
    }

    public static void updateEntity(
            Project project,
            ProjectRequest request) {

        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setEmployeeId(request.getEmployeeId());
        project.setStartDate(request.getStartDate());
        project.setEndDate(request.getEndDate());
        project.setStatus(request.getStatus());
    }
}