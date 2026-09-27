package com.microservice.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.infrastructure.persistence.entity.ProjectJpaEntity;

public interface ProjectJpaRepository
        extends JpaRepository<ProjectJpaEntity, Long> {

}