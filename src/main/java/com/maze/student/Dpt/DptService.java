package com.maze.student.Dpt;

import org.springframework.hateoas.CollectionModel;

public interface DptService {
    CollectionModel<DptDTO> findAll(int page, int size );

    DptDTO addDpt(Dpt dpt);

    DptDTO findDptById(Long id);
}
