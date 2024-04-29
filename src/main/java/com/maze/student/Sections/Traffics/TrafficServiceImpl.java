package com.maze.student.Sections.Traffics;


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
public class TrafficServiceImpl implements TrafficService {
    private final TrafficRepository trafficRepository;

    @Override
    public Traffics createTraffics(Traffics traffics, UsernamePasswordAuthenticationToken token) throws IllegalAccessException {
        traffics.setEightTime(Times.EIGHT);
        traffics.setFortiethTime(Times.FORTIETH);
        traffics.setEighteenTime(Times.EIGHTEEN);
        UserDetails userDetails = (UserDetails) token.getPrincipal();
        traffics.setCreatedBy(userDetails.getUsername());
        traffics.setUpdatedBy(userDetails.getUsername());
        return trafficRepository.save(traffics);
    }

    @Override
    public Traffics getTrafficById(long id) {
        return trafficRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Traffics.class, "  Type with an id: " + id + " was not found!"));
    }


    @Override
    public Page<Traffics> getAllTraffics(Pageable pageable) {
        return trafficRepository.findAllByOrderByCreatedAtDesc(pageable);
    }

    @Override
    public Traffics updateTrafficById(long id, Traffics traffics, UsernamePasswordAuthenticationToken token) throws IllegalAccessException {
        var et = getTrafficById(id);

        BeanUtils.copyProperties(traffics, et, getNullPropertyNames(traffics));
        return trafficRepository.save(et);
    }

    @Override
    public void deleteTrafficById(long id, UsernamePasswordAuthenticationToken token) {
        trafficRepository.deleteById(id);
    }


}
