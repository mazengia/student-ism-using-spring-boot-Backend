package com.maze.student.users;


import com.maze.student.Role.Roles;
import com.maze.student.Role.RolesRepository;
import com.maze.student.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.maze.student.util.Util.getNullPropertyNames;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RolesRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public ResponseEntity<MessageResponse> createStudents(SignupRequest signupRequest) throws IllegalAccessException {
        SystemUsers systemUsers = new SystemUsers();
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
        String pass = encoder.encode(signupRequest.getPassword());
        signupRequest.setPassword(pass);
        Set<String> strRoles = signupRequest.getRole();
        Set<Roles> roles = new HashSet<>();

        if (strRoles == null) {
            Roles userRole = (Roles) roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin" -> {
                        Roles adminRole = (Roles) roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                    }
                    case "mod" -> {
                        Roles modRole = (Roles) roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                    }
                    default -> {
                        Roles userRole = (Roles) roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                    }
                }
            });
        }

        systemUsers.setPassword(signupRequest.getPassword());
        systemUsers.setEmail(signupRequest.getEmail());
        systemUsers.setUsername(signupRequest.getUsername());
        systemUsers.setDpt(signupRequest.getDpt());
        systemUsers.setRoles(roles);
        userRepository.save(systemUsers);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

//    @Override
//    public ResponseEntity<JwtResponse> signInStudents(Students students, JwtAuthenticationToken token) throws IllegalAccessException {
//        Authentication authentication = authenticationManager
//                .authenticate(new UsernamePasswordAuthenticationToken(
//                        students.getUsername(),
//                        students.getPassword()));
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtils.generateJwtToken(authentication);
//
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        List<String> roles = userDetails
//                .getAuthorities()
//                .stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok(new JwtResponse(jwt,
//                userDetails.getId(),
//                userDetails.getUsername(),
//                userDetails.getEmail(),
//                roles));
//    }

    @Override
    public SystemUsers getStudentsById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(SystemUsers.class, "  Type with an id: " + id + " was not found!"));
    }


    @Override
    public Page<SystemUsers> getAllStudents(Pageable pageable, JwtAuthenticationToken token) {
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


}
