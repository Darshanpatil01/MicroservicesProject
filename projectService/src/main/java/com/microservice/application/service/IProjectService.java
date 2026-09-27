package com.microservice.application.service;

import java.util.List;

import com.microservice.application.dto.request.ProjectRequest;
import com.microservice.application.dto.response.ProjectResponse;

public interface IProjectService {

    ProjectResponse createProject(ProjectRequest request);

    List<ProjectResponse> getAllProjects();

    ProjectResponse getProjectById(Long id);

    ProjectResponse updateProject(
            Long id,
            ProjectRequest request
    );

    void deleteProject(Long id);
}