package com.maze.student.users;

import com.maze.student._config.security.jwt.JwtUtils;
import com.maze.student._config.security.services.UserDetailsImpl;
import com.maze.student._config.util.PaginatedResultsRetrievedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController implements UserApi {
    private final UserService userService;
    private final UserMapper userMapper;
    private final ApplicationEventPublisher eventPublisher;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    @Override
    public UserDto createStudents(UserDto userDto) throws IllegalAccessException {
        return userMapper.toUsersDto(userService.createStudents(userMapper.toUsers(userDto)));
    }


@PostMapping("/sign-in")
public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt,
            userDetails.getId(),
            userDetails.getUsername(),
            userDetails.getFirstName(),
            userDetails.getLastName(),
            userDetails.getEmail(),
            roles));
}

    @Override
    public UserDto getStudentsById(long id) {
        return userMapper.toGetUsersDto(userService.getStudentsById(id));
    }



    @Override
    public ResponseEntity<PagedModel<UserDto>> getStudentsByDptId(long id,Pageable pageable, PagedResourcesAssembler assembler, UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                UserDto.class, uriBuilder, response, pageable.getPageNumber(), userService.getStudentsGroupedByDptId(id,pageable).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<UserDto>>(assembler.toModel(userService.getStudentsGroupedByDptId(id,pageable).map(userMapper::toGetUsersDto)), HttpStatus.OK);
    }

    @Override
    public UserDto updateStudents(long id, UserDto userDto, JwtAuthenticationToken token) throws IllegalAccessException {
        return userMapper.toGetUsersDto(userService.updateStudents(id, userMapper.toUsers(userDto), token));
    }


    @Override
    public ResponseEntity<PagedModel<UserDto>> getAllStudents(Pageable pageable, PagedResourcesAssembler assembler, UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                UserDto.class, uriBuilder, response, pageable.getPageNumber(), userService.getAllStudents(pageable).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<UserDto>>(assembler.toModel(userService.getAllStudents(pageable).map(userMapper::toGetUsersDto)), HttpStatus.OK);
    }
}
