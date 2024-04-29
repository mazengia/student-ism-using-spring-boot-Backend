package com.maze.student.users;

import com.maze.student.security.jwt.JwtResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

public interface UserApi {
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    UserDto createStudents(@RequestBody @Valid UserDto userDto,UsernamePasswordAuthenticationToken token) throws IllegalAccessException;
     @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    UserDto getStudentsById(@PathVariable("id") long id);
    @GetMapping("/groupedByDpt/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<PagedModel<UserDto>> getStudentsByDptId(@Parameter(description = "pagination object", schema = @Schema(implementation = Pageable.class))
                                                       @PathVariable("id") long id,
                                                       @Valid Pageable pageable,
                                                       PagedResourcesAssembler assembler,
                                                       UriComponentsBuilder uriBuilder,
                                                       final HttpServletResponse response);
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    SystemUsers updateStudents(@PathVariable("id") long expenseId, @RequestBody  SystemUsers userDto, Authentication token ) throws IllegalAccessException;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    ResponseEntity<PagedModel<UserDto>> getAllStudents(@Parameter(description = "pagination object", schema = @Schema(implementation = Pageable.class))
                                                       @Valid Pageable pageable,
                                                       PagedResourcesAssembler assembler,
                                                       UriComponentsBuilder uriBuilder,
                                                       final HttpServletResponse response);

    @PostMapping("/sign-in")
    JwtResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest);

}
