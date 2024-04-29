package com.maze.student.Sections.Traffics;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;



@Service
public interface TrafficService {
    Traffics createTraffics(Traffics traffics, UsernamePasswordAuthenticationToken token) throws IllegalAccessException;
    Traffics getTrafficById(long id);

    Page<Traffics> getAllTraffics(Pageable pageable );
    Traffics updateTrafficById(long id, Traffics sections, UsernamePasswordAuthenticationToken token) throws IllegalAccessException;
    void deleteTrafficById(long id,UsernamePasswordAuthenticationToken token);

}






