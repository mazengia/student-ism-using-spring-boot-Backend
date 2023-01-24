package com.maze.student.Appeal;


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
public class AppealServiceImpl implements AppealService {
    private final AppealRepository appealRepository;
    @Override
    public Appeal createAppeal(Appeal appeal, JwtAuthenticationToken token) throws IllegalAccessException {

        return appealRepository.save(appeal);
    }

    @Override
    public Appeal getAppealById(long id) {
        return appealRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(Appeal.class, "  Type with an id: " + id + " was not found!"));
    }


    @Override
    public Page<Appeal> getAllAppeal(Pageable pageable, JwtAuthenticationToken token) {
        return appealRepository.findAllByOrderByCreatedAtDesc(pageable);
    }

    @Override
    public Appeal updateAppeal(long id, Appeal appealType, JwtAuthenticationToken token) throws IllegalAccessException {
        var et = getAppealById(id);

        BeanUtils.copyProperties(appealType, et, getNullPropertyNames(appealType));
        return appealRepository.save(et);
    }

    @Override
    public void deleteAppeal(long id, JwtAuthenticationToken token) {
        appealRepository.deleteById(id);
    }


}
