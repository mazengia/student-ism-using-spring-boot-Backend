package com.maze.student.StudentEnroll;

import com.maze.student.users.SystemUsers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEnrolment, Long> {

    Page<StudentEnrolment> findByStudentDptId(long dptId, Pageable pageable);

     StudentEnrolment findById(long dptId);


}