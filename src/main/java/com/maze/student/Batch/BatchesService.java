package com.maze.student.Batch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;



@Service
public interface BatchesService {
    Batches createBatches(Batches batches) throws IllegalAccessException;
    Batches getBatchesById(long id);

    Page<Batches> getAllBatches(Pageable pageable, JwtAuthenticationToken token);
    Batches updateBatches(long id, Batches batches, JwtAuthenticationToken token) throws IllegalAccessException;
    void deleteBatches(long id, JwtAuthenticationToken token);

}






