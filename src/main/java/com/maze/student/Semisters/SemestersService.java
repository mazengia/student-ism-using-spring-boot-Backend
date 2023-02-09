package com.maze.student.Semisters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;



@Service
public interface SemestersService {
    Semesters createSemesters(Semesters semesters) throws IllegalAccessException;
    Semesters getSemestersById(long id);

    Page<Semesters> getAllSemesters(Pageable pageable, JwtAuthenticationToken token);
    Semesters updateSemesters(long id, Semesters semesters, JwtAuthenticationToken token) throws IllegalAccessException;
    void deleteSemesters(long id, JwtAuthenticationToken token);

}






