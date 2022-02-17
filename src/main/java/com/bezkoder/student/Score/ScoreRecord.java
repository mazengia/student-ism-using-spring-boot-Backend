package com.bezkoder.student.Score;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Year;

@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class ScoreRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String studentId;
    private  String subjectId;
    private  String firstSemester;
    private  String secondSemester;
    private String thirdSemester;
    @Transient private Year year;
}
