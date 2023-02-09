package com.maze.student.Score;

import org.springframework.hateoas.CollectionModel;

public interface ResultService {
    CollectionModel<ResultDTO> findAll(int page, int size );

    ResultDTO addScore(Results results);

    ResultDTO findScoreById(Long id);
}
