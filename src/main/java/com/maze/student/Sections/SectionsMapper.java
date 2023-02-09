package com.maze.student.Sections;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SectionsMapper {
    Sections toAppeal(SectionsDto sectionsDto);
    SectionsDto toAppealDto(Sections sections);
}
