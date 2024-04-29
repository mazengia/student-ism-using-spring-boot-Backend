package com.maze.student.CerteficationYear;


import com.maze.student.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

import static com.maze.student.util.Util.getNullPropertyNames;


@Service
@RequiredArgsConstructor
public class CertificationYearServiceImpl implements CertificationYearService {
    private final CertificationYearRepository certificationYearRepository;
    @Override
    public CertificationYear createBatches(CertificationYear certificationYear) throws IllegalAccessException {

        return certificationYearRepository.save(certificationYear);
    }

    @Override
    public CertificationYear getBatchesById(long id) {
        return certificationYearRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(CertificationYear.class, "  Type with an id: " + id + " was not found!"));
    }


    @Override
    public Page<CertificationYear> getAllBatches(Pageable pageable ) {
        return certificationYearRepository.findAllByOrderByCreatedAtDesc(pageable);
    }

    @Override
    public CertificationYear updateBatches(long id, CertificationYear certificationYearType, JwtAuthenticationToken token) throws IllegalAccessException {

        var et = getBatchesById(id);
        BeanUtils.copyProperties(certificationYearType, et, getNullPropertyNames(certificationYearType));
        return certificationYearRepository.save(et);
    }

    @Override
    public void deleteBatches(long id, JwtAuthenticationToken token) {
        certificationYearRepository.deleteById(id);
    }


}
