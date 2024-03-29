package com.maze.student.Program;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProgramRepository extends JpaRepository<Programs, Long> {
    @Override
    Optional<Programs> findById(Long aLong);
    Boolean existsByName(String name);
}