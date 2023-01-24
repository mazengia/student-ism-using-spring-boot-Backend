package com.maze.student.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;



@Service
public interface UserService {
    ResponseEntity<MessageResponse> createStudents(SignupRequest students ) throws IllegalAccessException;
//    ResponseEntity<JwtResponse> signInStudents(Students students, JwtAuthenticationToken token) throws IllegalAccessException;

     SystemUsers getStudentsById(long id);

    Page<SystemUsers> getAllStudents(Pageable pageable, JwtAuthenticationToken token);
     SystemUsers updateStudents(long id, SystemUsers systemUsers, JwtAuthenticationToken token) throws IllegalAccessException;
    void deleteStudents(long id, JwtAuthenticationToken token);

}






