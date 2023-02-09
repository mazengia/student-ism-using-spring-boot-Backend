package com.maze.student.Semisters;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SemestersMapper {
    Semesters toSemesters(SemestersDto semestersDto);
    SemestersDto toSemestersDto(Semesters semesters);
}
