package com.maze.student.Score;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class ResultAssembler implements RepresentationModelAssembler<Results, ResultDTO> {

    @Override
    public ResultDTO toModel(Results results) {
        return new ResultDTO(
                results.getId(),
                results.getStudentEnrolment(),
                results.getCourseEnroll(),
                results.getMid(),
                results.getQuiz(),
                results.getFinal_result(),
                results.getTotal(),
                results.getAssignment()
        );
    }
}