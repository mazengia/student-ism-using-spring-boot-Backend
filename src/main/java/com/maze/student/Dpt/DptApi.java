package com.maze.student.Dpt;

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

public interface DptApi {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    DptDTO createDpt(@RequestBody @Valid DptDTO dptDTO) throws IllegalAccessException;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    DptDTO getDptById(@PathVariable("id") long id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    DptDTO updateDpt(@PathVariable("id") long expenseId, @RequestBody @Valid DptDTO dptDTO) throws IllegalAccessException;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PagedModel<DptDTO>> getAllDpt(@Parameter(description = "pagination object", schema = @Schema(implementation = Pageable.class))
                                                 @Valid Pageable pageable,
                                                 PagedResourcesAssembler assembler,
                                                 UriComponentsBuilder uriBuilder,
                                                 final HttpServletResponse response);

    @GetMapping("/department/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PagedModel<DptDTO>> getAllDptByDepartmentId(
            @Parameter(description = "pagination object",
            schema = @Schema(implementation = Pageable.class))
            @Valid Pageable pageable,
            @PathVariable("id") long id,
            PagedResourcesAssembler assembler,
            UriComponentsBuilder uriBuilder,
            final HttpServletResponse response);

    @GetMapping("/group/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PagedModel<DptDTO>> getAllDptByGroup(
            @Parameter(description = "pagination object",
                    schema = @Schema(implementation = Pageable.class))
            @Valid Pageable pageable,
            @PathVariable("id") long id,
            PagedResourcesAssembler assembler,
            UriComponentsBuilder uriBuilder,
            final HttpServletResponse response);

}
