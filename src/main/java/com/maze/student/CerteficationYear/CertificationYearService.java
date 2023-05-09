package com.maze.student.CerteficationYear;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;



@Service
public interface CertificationYearService {
    CertificationYear createBatches(CertificationYear certificationYear) throws IllegalAccessException;
    CertificationYear getBatchesById(long id);

    Page<CertificationYear> getAllBatches(Pageable pageable );
    CertificationYear updateBatches(long id, CertificationYear certificationYear, JwtAuthenticationToken token) throws IllegalAccessException;
    void deleteBatches(long id, JwtAuthenticationToken token);

}






