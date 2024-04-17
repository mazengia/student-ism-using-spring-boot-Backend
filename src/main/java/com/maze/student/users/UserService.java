package com.maze.student.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;



@Service
public interface UserService {
    SystemUsers createStudents(SystemUsers students ,UsernamePasswordAuthenticationToken token) throws IllegalAccessException;

     SystemUsers getStudentsById(long id);

    Page<SystemUsers> getAllStudents(Pageable pageable);
     SystemUsers updateStudents(long id, SystemUsers systemUsers , UsernamePasswordAuthenticationToken token) throws IllegalAccessException;
    void deleteStudents(long id, JwtAuthenticationToken token);

    Page<SystemUsers> getStudentsGroupedByDptId(long id,Pageable pageable);
}






