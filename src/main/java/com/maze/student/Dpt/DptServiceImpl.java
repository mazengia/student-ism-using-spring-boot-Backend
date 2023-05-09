package com.maze.student.Dpt;

import com.maze.student._config.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.maze.student._config.util.Util.getNullPropertyNames;


@Service
@RequiredArgsConstructor
public class DptServiceImpl implements DptService {

  private final   DptRepository dptRepository;
    @Override
    public Dpt createDpt(Dpt dpt) throws IllegalAccessException {

        return dptRepository.save(dpt);
    }

    @Override
    public Dpt getDptById(long id) {
        return dptRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(Dpt.class, "  Type with an id: " + id + " was not found!"));
    }


    @Override
    public Page<Dpt> getAllDpt(Pageable pageable) {
        return dptRepository.findAll(pageable);
    }

    @Override
    public Dpt updateDpt(long id, Dpt dpt) throws IllegalAccessException {
        var et = getDptById(id);

        BeanUtils.copyProperties(dpt, et, getNullPropertyNames(dpt));
        return dptRepository.save(et);
    }

    @Override
    public void deleteDpt(long id) {
        dptRepository.deleteById(id);
    }

    @Override
    public Page<Dpt> getAllDptByDepartmentId(Pageable pageable, long id) {
        return dptRepository.findAllByDepartmentId(pageable,id);
    }

    @Override
    public Page<Dpt> getAllDptByGroup(Pageable pageable, long id) {

        return dptRepository.findAllById(pageable,id);
    }


}
