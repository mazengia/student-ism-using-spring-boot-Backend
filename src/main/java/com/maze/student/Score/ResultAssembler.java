package com.maze.student.Score;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ResultAssembler implements RepresentationModelAssembler<ScoreRecord, ResultDTO> {

    @Override
    public ResultDTO toModel(ScoreRecord scoreRecord) {
        return new ResultDTO(
                scoreRecord.getId(),
                scoreRecord.getStudentId(),
                scoreRecord.getSubjectId(),
                scoreRecord.getFirstSemester(),
                scoreRecord.getSecondSemester(),
                scoreRecord.getThirdSemester(),
                scoreRecord.getYear()
        );
    }
}