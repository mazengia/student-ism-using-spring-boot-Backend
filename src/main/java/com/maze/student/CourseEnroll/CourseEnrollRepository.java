package com.maze.student.CourseEnroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseEnrollRepository extends JpaRepository<CourseEnroll, Long> {
    @Override
    Optional<CourseEnroll> findById(Long aLong);
}