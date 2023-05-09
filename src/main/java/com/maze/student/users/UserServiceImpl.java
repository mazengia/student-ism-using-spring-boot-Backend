package com.maze.student.users;


import com.maze.student.Role.Roles;
import com.maze.student.Role.RolesRepository;
import com.maze.student._config.exception.EntityNotFoundException;
import com.maze.student._config.security.jwt.JwtUtils;
import com.maze.student._config.security.services.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.maze.student._config.util.Util.getNullPropertyNames;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RolesRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    public ResponseEntity<MessageResponse> createStudents(SystemUsers signupRequest) throws IllegalAccessException {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        Set<Roles> strRoles = signupRequest.getRole();
        Set<Roles> roles = new HashSet<>();
            strRoles.forEach(role -> {
                        Roles adminRole =  roleRepository.findById(role.getId())
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

            });
        signupRequest.setPassword(encoder.encode(signupRequest.getPassword()));
        signupRequest.setRole(roles);
        userRepository.save(signupRequest);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }



    @Override
    public SystemUsers getStudentsById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(SystemUsers.class, "  Type with an id: " + id + " was not found!"));
    }


    @Override
    public Page<SystemUsers> getAllStudents(Pageable pageable ) {
        return userRepository.findAllByOrderByCreatedAtDesc(pageable);
    }

    @Override
    public SystemUsers updateStudents(long id, SystemUsers systemUsers, JwtAuthenticationToken token) throws IllegalAccessException {
        var et = getStudentsById(id);

        BeanUtils.copyProperties(systemUsers, et, getNullPropertyNames(systemUsers));
        return userRepository.save(et);
    }

    @Override
    public void deleteStudents(long id, JwtAuthenticationToken token) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<SystemUsers> getStudentsGroupedByDptId(long id, Pageable pageable) {
        return userRepository.findAllByDptIdOrderByCreatedAtDesc(id,pageable);
    }


}
