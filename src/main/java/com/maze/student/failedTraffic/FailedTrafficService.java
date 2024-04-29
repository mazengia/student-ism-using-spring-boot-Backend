package com.maze.student.failedTraffic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;



@Service
public interface FailedTrafficService {
    FailedTraffics createTraffics(FailedTraffics failedTraffics, UsernamePasswordAuthenticationToken token) throws IllegalAccessException;
    FailedTraffics getTrafficById(long id);

    Page<FailedTraffics> getAllTraffics(Pageable pageable );
    FailedTraffics updateTrafficById(long id, FailedTraffics sections, UsernamePasswordAuthenticationToken token) throws IllegalAccessException;
    void deleteTrafficById(long id,UsernamePasswordAuthenticationToken token);

}






