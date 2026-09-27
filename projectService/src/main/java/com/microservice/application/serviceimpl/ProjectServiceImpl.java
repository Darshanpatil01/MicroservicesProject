package com.microservice.application.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.application.dto.request.ProjectRequest;
import com.microservice.application.dto.response.EmployeeResponse;
import com.microservice.application.dto.response.ProjectResponse;
import com.microservice.application.mapper.ProjectMapper;
import com.microservice.application.service.EmployeeLookup;
import com.microservice.application.service.IProjectService;
import com.microservice.domain.entity.Project;
import com.microservice.domain.repository.ProjectRepository;

@Service
@Transactional
public class ProjectServiceImpl implements IProjectService {

    private final ProjectRepository repository;
    private final EmployeeLookup employeeLookup;

    public ProjectServiceImpl(
            ProjectRepository repository,
            EmployeeLookup employeeLookup) {

        this.repository = repository;
        this.employeeLookup = employeeLookup;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest request) {

        validateDates(request);

        // Verify that the employee exists.
        EmployeeResponse employee =
                employeeLookup.getEmployeeById(
                        request.getEmployeeId()
                );

        Project project = ProjectMapper.toEntity(request);

        Project savedProject = repository.save(project);

        return ProjectMapper.toResponse(savedProject, employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProjectResponse> getAllProjects() {

        return repository.findAll()
                .stream()
                .map(project -> {

                    EmployeeResponse employee =
                            employeeLookup.getEmployeeById(
                                    project.getEmployeeId()
                            );

                    return ProjectMapper.toResponse(
                            project,
                            employee
                    );
                })
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectResponse getProjectById(Long id) {

        Project project = findProject(id);

        EmployeeResponse employee =
                employeeLookup.getEmployeeById(
                        project.getEmployeeId()
                );

        return ProjectMapper.toResponse(project, employee);
    }

    @Override
    public ProjectResponse updateProject(
            Long id,
            ProjectRequest request) {

        validateDates(request);

        Project project = findProject(id);

        // Verify the employee before updating the project.
        EmployeeResponse employee =
                employeeLookup.getEmployeeById(
                        request.getEmployeeId()
                );

        ProjectMapper.updateEntity(project, request);

        Project updatedProject = repository.save(project);

        return ProjectMapper.toResponse(
                updatedProject,
                employee
        );
    }

    @Override
    public void deleteProject(Long id) {

        if (!repository.existsById(id)) {

            throw new NoSuchElementException(
                    "Project not found with ID: " + id
            );
        }

        repository.deleteById(id);
    }

    private Project findProject(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException(
                                "Project not found with ID: " + id
                        )
                );
    }

    private void validateDates(ProjectRequest request) {

        if (request.getEndDate() != null
                && request.getEndDate()
                        .isBefore(request.getStartDate())) {

            throw new IllegalArgumentException(
                    "End date cannot be before start date"
            );
        }
    }
}