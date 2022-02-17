package com.maze.student.Dpt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DptRepository extends JpaRepository<Dpt, Long> {
    @Override
    Optional<Dpt> findById(Long aLong);
}