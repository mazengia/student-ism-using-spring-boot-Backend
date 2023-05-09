package com.maze.student.StudentEnroll;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<StudentEnrolment> findAll(Pageable pageable);

    Page<StudentEnrolment> findAllEnrolledByDptId(long dptId, Pageable pageable);
    StudentEnrolment updateStudent(long id, StudentEnrolment studentEnrolment);

    StudentEnrolment enrollStudent(StudentEnrolment studentEnrolment);

    StudentEnrolment findStudentById(Long id);
}
