package com.microservice.domain.repository;

import java.util.List;
import java.util.Optional;

import com.microservice.domain.entity.Project;

public interface ProjectRepository {

    Project save(Project project);

    List<Project> findAll();

    Optional<Project> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);
}