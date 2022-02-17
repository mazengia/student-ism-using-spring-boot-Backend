package com.bezkoder.student.StudentEnroll;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEnrolment, Long> {
    @Override
    Optional<StudentEnrolment> findById(Long aLong);
}