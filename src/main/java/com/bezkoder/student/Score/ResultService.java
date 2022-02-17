package com.bezkoder.student.Score;

import org.springframework.hateoas.CollectionModel;

public interface ResultService {
    CollectionModel<ResultDTO> findAll(int page, int size );

    ResultDTO addScore(ScoreRecord scoreRecord);

    ResultDTO findScoreById(Long id);
}
