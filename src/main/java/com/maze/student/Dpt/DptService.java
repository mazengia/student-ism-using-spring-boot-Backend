package com.maze.student.Dpt;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DptService {
    Dpt createDpt(Dpt dpt) throws IllegalAccessException;

    Dpt getDptById(long id);

    Page<Dpt> getAllDpt(Pageable pageable);

    Dpt updateDpt(long id, Dpt dpt) throws IllegalAccessException;

    void deleteDpt(long id);

    Page<Dpt> getAllDptByDepartmentId(Pageable pageable, long id);

    Page<Dpt> getAllDptByGroup(Pageable pageable, long id);
}
