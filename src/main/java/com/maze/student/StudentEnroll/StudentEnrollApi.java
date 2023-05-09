package com.maze.student.StudentEnroll;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;



public interface StudentEnrollApi   {
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PagedModel<EnrollDto>> findAll(@Parameter(description = "pagination object", schema = @Schema(implementation = Pageable.class))
                                                       @Valid Pageable pageable,
                                                  PagedResourcesAssembler assembler,
                                                  UriComponentsBuilder uriBuilder,
                                                  final HttpServletResponse response);

    @PostMapping
    EnrollDto addStudent(@RequestBody StudentEnrolment studentEnrolment)throws IllegalAccessException;
    @GetMapping("/dpt/{dptId}")
    @ResponseStatus(HttpStatus.OK)
    EnrollDto findAllEnrolledByDptId(@PathVariable("dptId") long dptId,
                                     @Valid Pageable pageable);
    @GetMapping("/{id}")
    EnrollDto findStudentId(@PathVariable Long id);
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    EnrollDto updateStudent(@PathVariable long id, @RequestBody StudentEnrolment studentEnrolment)throws IllegalAccessException;
}
