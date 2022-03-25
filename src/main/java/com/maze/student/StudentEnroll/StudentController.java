package com.maze.student.StudentEnroll;

import com.maze.student.security.SecuredRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/student-enroll")

public class StudentController implements SecuredRestController {

    StudentService studentService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public StudentDTO addStudent(@RequestBody StudentEnrolment studentEnrolment) {
         return studentService.enrollStudent(studentEnrolment);
    }

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        CollectionModel<StudentDTO> studentDTOS = studentService.findAll(page, size);
        if (studentDTOS != null) {
            return ResponseEntity.ok(studentDTOS);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findStudentId(@PathVariable Long id) {
        StudentDTO studentDTO = studentService.findStudentById(id);
        if (studentDTO != null) return ResponseEntity.ok(studentDTO);
        return ResponseEntity.noContent().build();
    }
}
