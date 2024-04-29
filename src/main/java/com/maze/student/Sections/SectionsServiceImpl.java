package com.maze.student.Sections;


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
public class SectionsServiceImpl implements SectionsService {
    private final SectionsRepository sectionsRepository;
    @Override
    public Sections createSections(Sections sections) throws IllegalAccessException {

        return sectionsRepository.save(sections);
    }

    @Override
    public Sections getSectionsById(long id) {
        return sectionsRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(Sections.class, "  Type with an id: " + id + " was not found!"));
    }


    @Override
    public Page<Sections> getAllSections(Pageable pageable ) {
        return sectionsRepository.findAllByOrderByCreatedAtDesc(pageable);
    }

    @Override
    public Sections updateSections(long id, Sections sectionsType, JwtAuthenticationToken token) throws IllegalAccessException {
        var et = getSectionsById(id);

        BeanUtils.copyProperties(sectionsType, et, getNullPropertyNames(sectionsType));
        return sectionsRepository.save(et);
    }

    @Override
    public void deleteSections(long id, JwtAuthenticationToken token) {
        sectionsRepository.deleteById(id);
    }


}
