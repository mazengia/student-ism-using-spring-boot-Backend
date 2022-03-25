package com.maze.student.StudentEnroll;

import org.springframework.hateoas.CollectionModel;

public interface StudentService {
    CollectionModel<StudentDTO> findAll(int page, int size );

    StudentDTO enrollStudent(StudentEnrolment studentEnrolment);

    StudentDTO findStudentById(Long id);
}
