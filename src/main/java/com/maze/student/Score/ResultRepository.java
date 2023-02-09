package com.maze.student.Score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<Results, Long> {
    @Override
    Optional<Results> findById(Long aLong);
}