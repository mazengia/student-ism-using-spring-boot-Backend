package com.maze.student.StudentEnroll;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEnrolment, Long> {

    Page<StudentEnrolment> findByStudentDptId(long dptId, Pageable pageable);

     StudentEnrolment findById(long dptId);


}