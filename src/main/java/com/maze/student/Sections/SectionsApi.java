package com.maze.student.Sections;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

public interface SectionsApi {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    SectionsDto createSections(@RequestBody @Valid SectionsDto sectionsDto) throws IllegalAccessException;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    SectionsDto getSectionsById(@PathVariable("id") long id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    SectionsDto updateSections(@PathVariable("id") long expenseId, @RequestBody @Valid SectionsDto sectionsDto, JwtAuthenticationToken token) throws IllegalAccessException;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PagedModel<SectionsDto>> getAllSections(@Parameter(description = "pagination object", schema = @Schema(implementation = Pageable.class))
                                                       @Valid Pageable pageable,
                                                           PagedResourcesAssembler assembler,
                                                           UriComponentsBuilder uriBuilder,
                                                           final HttpServletResponse response);
}
