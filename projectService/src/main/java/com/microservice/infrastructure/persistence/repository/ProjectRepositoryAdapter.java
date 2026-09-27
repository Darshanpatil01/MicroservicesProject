package com.microservice.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.microservice.domain.entity.Project;
import com.microservice.domain.repository.ProjectRepository;
import com.microservice.infrastructure.persistence.entity.ProjectJpaEntity;

@Repository
public class ProjectRepositoryAdapter implements ProjectRepository {

    private final ProjectJpaRepository jpaRepository;

    public ProjectRepositoryAdapter(
            ProjectJpaRepository jpaRepository) {

        this.jpaRepository = jpaRepository;
    }

    @Override
    public Project save(Project project) {

        ProjectJpaEntity entity = toJpaEntity(project);

        ProjectJpaEntity saved = jpaRepository.save(entity);

        return toDomain(saved);
    }

    @Override
    public List<Project> findAll() {

        return jpaRepository.findAll()
                .stream()
                .map(this::toDomain)
                .toList();
    }

    @Override
    public Optional<Project> findById(Long id) {

        return jpaRepository.findById(id)
                .map(this::toDomain);
    }

    @Override
    public boolean existsById(Long id) {

        return jpaRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {

        jpaRepository.deleteById(id);
    }

    private ProjectJpaEntity toJpaEntity(Project project) {

        ProjectJpaEntity entity = new ProjectJpaEntity();

        entity.setId(project.getId());
        entity.setName(project.getName());
        entity.setDescription(project.getDescription());
        entity.setEmployeeId(project.getEmployeeId());
        entity.setStartDate(project.getStartDate());
        entity.setEndDate(project.getEndDate());
        entity.setStatus(project.getStatus());

        return entity;
    }

    private Project toDomain(ProjectJpaEntity entity) {

        return new Project(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getEmployeeId(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getStatus()
        );
    }
}