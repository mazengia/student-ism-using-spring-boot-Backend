package com.maze.student.Sections;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;



@Service
public interface SectionsService {
    Sections createSections(Sections sections) throws IllegalAccessException;
    Sections getSectionsById(long id);

    Page<Sections> getAllSections(Pageable pageable );
    Sections updateSections(long id, Sections sections, JwtAuthenticationToken token) throws IllegalAccessException;
    void deleteSections(long id, JwtAuthenticationToken token);

}






