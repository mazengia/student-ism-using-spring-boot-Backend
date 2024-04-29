package com.maze.student.StudentEnroll;

import com.maze.student.util.PaginatedResultsRetrievedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/student-enroll")
@RequiredArgsConstructor

public class StudentController implements StudentEnrollApi {

    private final StudentService studentService;
    private final StudentEnrollMapper studentEnrollMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public ResponseEntity<PagedModel<EnrollDto>> findAll(Pageable pageable, PagedResourcesAssembler assembler, UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                EnrollDto.class, uriBuilder, response, pageable.getPageNumber(), studentService.findAll(pageable).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<EnrollDto>>(assembler.toModel(studentService.findAll(pageable).map(studentEnrollMapper::toStudentDTO)), HttpStatus.OK);
    }

    @Override
    public EnrollDto addStudent(StudentEnrolment studentEnrolment) throws IllegalAccessException {
        return studentEnrollMapper.toStudentDTO(studentService.enrollStudent(studentEnrolment));
    }

    @Override
    public EnrollDto findAllEnrolledByDptId(long dptId, Pageable pageable) {
        return studentEnrollMapper.toStudentDTO((StudentEnrolment) studentService.findAllEnrolledByDptId(dptId,pageable));
    }


    @Override
    public EnrollDto findStudentId(Long id) {
        return studentEnrollMapper.toStudentDTO(  studentService.findStudentById(id));

    }

    @Override
    public EnrollDto updateStudent(long id, StudentEnrolment studentEnrolment) throws IllegalAccessException {
        return studentEnrollMapper.toStudentDTO(studentService.updateStudent(id,  studentEnrolment) );

    }
}
