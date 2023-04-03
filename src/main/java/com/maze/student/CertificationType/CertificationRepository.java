package com.maze.student.CertificationType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CertificationRepository extends JpaRepository<Certifications, Long> {
    @Override
    Optional<Certifications> findById(Long aLong);
    Boolean existsByName(String name);
}