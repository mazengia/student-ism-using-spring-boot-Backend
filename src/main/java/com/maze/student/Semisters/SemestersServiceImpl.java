package com.maze.student.Semisters;


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
public class SemestersServiceImpl implements SemestersService {
    private final SemestersRepository semestersRepository;
    @Override
    public Semesters createSemesters(Semesters semesters) throws IllegalAccessException {

        return semestersRepository.save(semesters);
    }

    @Override
    public Semesters getSemestersById(long id) {
        return semestersRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(Semesters.class, "  Type with an id: " + id + " was not found!"));
    }


    @Override
    public Page<Semesters> getAllSemesters(Pageable pageable, JwtAuthenticationToken token) {
        return semestersRepository.findAllByOrderByCreatedAtDesc(pageable);
    }

    @Override
    public Semesters updateSemesters(long id, Semesters semestersType, JwtAuthenticationToken token) throws IllegalAccessException {
        var et = getSemestersById(id);

        BeanUtils.copyProperties(semestersType, et, getNullPropertyNames(semestersType));
        return semestersRepository.save(et);
    }

    @Override
    public void deleteSemesters(long id, JwtAuthenticationToken token) {
        semestersRepository.deleteById(id);
    }


}
