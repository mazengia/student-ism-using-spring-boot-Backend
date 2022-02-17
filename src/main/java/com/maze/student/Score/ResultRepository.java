package com.maze.student.Score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResultRepository extends JpaRepository<ScoreRecord, Long> {
    @Override
    Optional<ScoreRecord> findById(Long aLong);
}