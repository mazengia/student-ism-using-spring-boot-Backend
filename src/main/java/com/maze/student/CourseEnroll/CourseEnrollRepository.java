package com.maze.student.CourseEnroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseEnrollRepository extends JpaRepository<CoursEnroll, Long> {
    @Override
    Optional<CoursEnroll> findById(Long aLong);
}