package com.maze.student.users;

import com.maze.student.security.jwt.JwtResponse;
import com.maze.student.security.jwt.JwtUtils;
import com.maze.student.security.services.UserDetailsImpl;
import com.maze.student.util.PaginatedResultsRetrievedEvent;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController implements UserApi {
    private final UserService userService;
    private final UserMapper userMapper;
    private final ApplicationEventPublisher eventPublisher;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    public UserDto createStudents(UserDto userDto, UsernamePasswordAuthenticationToken token) throws IllegalAccessException {
        return userMapper.toUsersDto(userService.createStudents(userMapper.toUsers(userDto), token));
    }

    @Override
    public JwtResponse authenticateUser(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        JwtResponse jwtResponse = new JwtResponse();
        jwtResponse.setToken(jwt);
        jwtResponse.setId(userDetails.getId());
        jwtResponse.setUsername(userDetails.getUsername());
        jwtResponse.setFirstName(userDetails.getFirstName());
        jwtResponse.setLastName(userDetails.getLastName());
        jwtResponse.setEmail(userDetails.getEmail());
        jwtResponse.setRoles(roles);
        return jwtResponse;
    }

    @Override
    public UserDto getStudentsById(long id) {
        return userMapper.toUsersDto(userService.getStudentsById(id));
    }


    @Override
    public ResponseEntity<PagedModel<UserDto>> getStudentsByDptId(long id, Pageable pageable, PagedResourcesAssembler assembler, UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                UserDto.class, uriBuilder, response, pageable.getPageNumber(), userService.getStudentsGroupedByDptId(id, pageable).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<UserDto>>(assembler.toModel(userService.getStudentsGroupedByDptId(id, pageable).map(userMapper::toUsersDto)), HttpStatus.OK);
    }

    @Override
    public SystemUsers updateStudents(long id, SystemUsers userDto, Authentication token) throws IllegalAccessException {
        return userService.updateStudents(id, userDto, token);
    }

    @Override
    public ResponseEntity<PagedModel<UserDto>> getAllStudents(Pageable pageable, PagedResourcesAssembler assembler, UriComponentsBuilder uriBuilder, HttpServletResponse response) {
        eventPublisher.publishEvent(new PaginatedResultsRetrievedEvent<>(
                UserDto.class, uriBuilder, response, pageable.getPageNumber(), userService.getAllStudents(pageable).getTotalPages(), pageable.getPageSize()));
        return new ResponseEntity<PagedModel<UserDto>>(assembler.toModel(userService.getAllStudents(pageable).map(userMapper::toUsersDto)), HttpStatus.OK);
    }


}
