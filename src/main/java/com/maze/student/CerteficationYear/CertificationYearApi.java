package com.maze.student.CerteficationYear;

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

public interface CertificationYearApi {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    CertificationYearDto createBatches(@RequestBody @Valid CertificationYearDto certificationYearDto) throws IllegalAccessException;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CertificationYearDto getBatchesById(@PathVariable("id") long id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    CertificationYearDto updateBatches(@PathVariable("id") long expenseId, @RequestBody @Valid CertificationYearDto certificationYearDto, JwtAuthenticationToken token) throws IllegalAccessException;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PagedModel<CertificationYearDto>> getAllBatches(@Parameter(description = "pagination object", schema = @Schema(implementation = Pageable.class))
                                                       @Valid Pageable pageable,
                                                                   PagedResourcesAssembler assembler,
                                                                   JwtAuthenticationToken token,
                                                                   UriComponentsBuilder uriBuilder,
                                                                   final HttpServletResponse response);
}
