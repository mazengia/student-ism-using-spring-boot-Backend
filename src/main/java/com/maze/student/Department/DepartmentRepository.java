package com.maze.student.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Override
    Optional<Department> findById(Long aLong);
    Boolean existsByName(String name);
    Boolean existsByCode(String code);
}