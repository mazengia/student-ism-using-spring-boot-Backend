package com.maze.student.Sections.Traffics;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

public interface TrafficApi {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    TrafficDtos createTraffics(@RequestBody @Valid TrafficDtos trafficDtos, UsernamePasswordAuthenticationToken token) throws IllegalAccessException;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    TrafficDtos getTrafficById(@PathVariable("id") long id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    TrafficDtos updateTrafficById(@PathVariable("id") long trafficId, @RequestBody @Valid TrafficDtos trafficDtos, UsernamePasswordAuthenticationToken token) throws IllegalAccessException;
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteTrafficById(@PathVariable("id") long trafficId,UsernamePasswordAuthenticationToken token) throws IllegalAccessException;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PagedModel<TrafficDtos>> getAllTraffics(@Parameter(description = "pagination object", schema = @Schema(implementation = Pageable.class))
                                                       @Valid Pageable pageable,
                                                           PagedResourcesAssembler assembler,
                                                           UriComponentsBuilder uriBuilder,
                                                           final HttpServletResponse response);
}
