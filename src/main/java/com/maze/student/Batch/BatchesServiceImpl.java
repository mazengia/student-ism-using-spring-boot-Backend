package com.maze.student.Batch;


import com.maze.student._config.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import static com.maze.student._config.util.Util.getNullPropertyNames;


@Service
@RequiredArgsConstructor
public class BatchesServiceImpl implements BatchesService {
    private final BatchesRepository batchesRepository;
    @Override
    public Batches createBatches(Batches batches) throws IllegalAccessException {

        return batchesRepository.save(batches);
    }

    @Override
    public Batches getBatchesById(long id) {
        return batchesRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(Batches.class, "  Type with an id: " + id + " was not found!"));
    }


    @Override
    public Page<Batches> getAllBatches(Pageable pageable, JwtAuthenticationToken token) {
        return batchesRepository.findAllByOrderByCreatedAtDesc(pageable);
    }

    @Override
    public Batches updateBatches(long id, Batches batchesType, JwtAuthenticationToken token) throws IllegalAccessException {
        var et = getBatchesById(id);

        BeanUtils.copyProperties(batchesType, et, getNullPropertyNames(batchesType));
        return batchesRepository.save(et);
    }

    @Override
    public void deleteBatches(long id, JwtAuthenticationToken token) {
        batchesRepository.deleteById(id);
    }


}
