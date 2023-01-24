package com.maze.student.Appeal;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppealMapper {
    Appeal toAppeal(AppealDto appealDto);
    AppealDto toAppealDto(Appeal appeal);
}
