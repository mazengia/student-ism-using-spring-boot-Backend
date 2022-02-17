package com.maze.student.Score;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.time.Year;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ResultDTO extends RepresentationModel<ResultDTO> {
    private  Long id;
    private  String studentId;
    private  String subjectId;
    private  String firstSemester;
    private  String secondSemester;
    private String thirdSemester;
    private Year year;
}
