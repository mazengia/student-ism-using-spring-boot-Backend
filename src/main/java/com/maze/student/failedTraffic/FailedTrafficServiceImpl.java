package com.maze.student.failedTraffic;


import com.maze.student.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import static com.maze.student.util.Util.getNullPropertyNames;


@Service
@RequiredArgsConstructor
public class FailedTrafficServiceImpl implements FailedTrafficService {
    private final FailedTrafficRepository failedTrafficRepository;

    @Override
    public FailedTraffics createTraffics(FailedTraffics failedTraffics, UsernamePasswordAuthenticationToken token) throws IllegalAccessException {
        UserDetails userDetails = (UserDetails) token.getPrincipal();
        failedTraffics.setCreatedBy(userDetails.getUsername());
        failedTraffics.setUpdatedBy(userDetails.getUsername());
        return failedTrafficRepository.save(failedTraffics);
    }

    @Override
    public FailedTraffics getTrafficById(long id) {
        return failedTrafficRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(FailedTraffics.class, "  Type with an id: " + id + " was not found!"));
    }


    @Override
    public Page<FailedTraffics> getAllTraffics(Pageable pageable) {
        return failedTrafficRepository.findAllByOrderByCreatedAtDesc(pageable);
    }

    @Override
    public FailedTraffics updateTrafficById(long id, FailedTraffics failedTraffics, UsernamePasswordAuthenticationToken token) throws IllegalAccessException {
        var et = getTrafficById(id);

        BeanUtils.copyProperties(failedTraffics, et, getNullPropertyNames(failedTraffics));
        return failedTrafficRepository.save(et);
    }

    @Override
    public void deleteTrafficById(long id, UsernamePasswordAuthenticationToken token) {
        failedTrafficRepository.deleteById(id);
    }


}
